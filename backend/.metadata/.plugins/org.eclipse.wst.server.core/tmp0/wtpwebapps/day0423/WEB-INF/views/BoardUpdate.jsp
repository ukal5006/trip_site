<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 화면</title>
</head>
<body>

    <form action="${root}/board/update" method="post">
        
        <table border="1">
        	<tr>
                <td>bno:</td>
                <td><input type="number" name="bno" value="${board.bno}" readonly></td>
            </tr>
            <tr>
                <td>제목:</td>
                <td><input type="text" name="title" value="${board.title}"></td>
            </tr>
            <tr>
                <td>작성자:</td>
                <td><input type="text" name="writer" value="${board.writer}" readonly></td>
            </tr>
            <tr>
                <td>내용:</td>
                <td><input type="text" name="content" value="${board.content}"></td>
            </tr>
            <tr>
                <td>작성일시:</td>
                <td><input type="text" name="writeDate" value="${board.writeDate}" readonly></td>
            </tr>
            <tr>
                <td>조회수:</td>
                <td><input type="number" name="readCount" value="${board.readCount}" readonly></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정완료">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
