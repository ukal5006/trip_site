package com.example.trip.data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BreweryCrawler {

    private static final String API_KEY = "cd6e74b7d32c299e048bab9bf7c33fa8";

    public void executeCrawl() {
        WebDriver driver = null;
        try {
            // WebDriver 경로 설정
            System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 웹사이트 열기
            driver.get("https://www.goingsool.com/");

            List<String[]> data = new ArrayList<>();

            for (int i = 1; i <= 6; i++) {
                String elementId = String.format("%03d", i);
                WebElement element = driver.findElement(By.id(elementId));
                element.click();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> liElements = driver.findElements(By.cssSelector(".list li"));

                for (WebElement li : liElements) {
                    // StaleElementReferenceException 발생 시 재시도
                    for (int attempt = 0; attempt < 3; attempt++) {
                        try {
                            String[] infoText = li.getText().split("\n");

                            if (li.getText().contains("해당 권역에 등록된 양조장이 없습니다.")) {
                                continue;
                            }

                            // 데이터 파싱 로직
                            String name = infoText[0];
                            String address = infoText[1].split("주소 ")[1];
                            String drinkType = infoText[2].split("주종 ")[1];
                            String reservation = infoText[3].split("예약문의 ")[1];
                            String minimumPeople = infoText[4].split("최소인원 ")[1];

                            String imageSrc;
                            try {
                                WebElement imageElement = li.findElement(By.tagName("img"));
                                imageSrc = imageElement.getAttribute("src");
                            } catch (Exception e) {
                                imageSrc = "null"; // 이미지가 없는 경우 예외 처리
                            }

                            // 위도와 경도 가져오기
                            double[] coordinates = getLocation(address);
                            double latitude = coordinates[0];
                            double longitude = coordinates[1];

                            data.add(new String[]{name, address, drinkType, reservation, minimumPeople, imageSrc, String.valueOf(latitude), String.valueOf(longitude)});
                            break; // 성공하면 루프 종료
                        } catch (StaleElementReferenceException e) {
                            // 재시도 전에 요소를 다시 찾음
                            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                            li = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list li")));
                        }
                    }
                }
            }

            // 데이터 출력
            saveToCSV(data);

        } finally {
            // 브라우저 종료
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private double[] getLocation(String address) {
        double[] coordinates = {0.0, 0.0};
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Authorization", "KakaoAK " + API_KEY)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(responseBody);
            JsonNode documents = rootNode.path("documents");

            if (documents.isArray() && documents.size() > 0) {
                JsonNode addressInfo = documents.get(0).path("address");
                coordinates[0] = addressInfo.path("y").asDouble();
                coordinates[1] = addressInfo.path("x").asDouble();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    private void saveToCSV(List<String[]> data) {
        String[] headers = {"brewery_title", "brewery_address", "brewery_kind", "brewery_num", "min_people", "brewery_img", "brewery_lat", "brewery_long"};
        String filePath = "C:\\Users\\jsio2\\Computer\\SSAFY\\trip_site\\backend\\src\\main\\resources\\data\\brewery_data.csv";

        try (BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(
                Files.newOutputStream(Paths.get(filePath)), StandardCharsets.UTF_8))) {
            // BOM 추가
            csvWriter.write('\uFEFF');

            // 헤더 작성
            for (String header : headers) {
                csvWriter.append(header).append(",");
            }
            csvWriter.append("\n");

            // 데이터 작성
            for (String[] rowData : data) {
                for (String field : rowData) {
                    csvWriter.append(field).append(",");
                }
                csvWriter.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
