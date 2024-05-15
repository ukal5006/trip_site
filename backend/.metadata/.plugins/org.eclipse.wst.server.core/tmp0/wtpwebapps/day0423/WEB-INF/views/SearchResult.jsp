<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
<body>
    <%@ include file="Header.jsp"%>

    <h2>검색 결과</h2>

    <table border="1">
        <tr>
            <th>bno.</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일시</th>
            <th>조회수</th>
        </tr>
        <c:if test="${empty pageInfo}">
            <tr>
                <td colspan="5">검색된 결과가 없습니다.</td>
            </tr>
        </c:if>
        <c:if test="${not empty pageInfo}">
            <c:forEach var="b" items="${pageInfo}">
                <tr>
                    <td>${b.bno}</td>
                    <td><a href="select?bno=${b.bno}&title=${b.title}&writer=${b.writer}&writeDate=${b.writeDate}&readCount=${b.readCount}">${b.title}</a></td>
                    <td>${b.writer}</td>
                    <td>${b.writeDate}</td>
                    <td>${b.readCount}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <a href="${root}/board/list">[목록으로 가기]</a>
</body>
</html>
