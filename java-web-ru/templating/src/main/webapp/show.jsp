<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <table>
            <c:forEach var="entry" items="${user}">
            <tr>
            <td>${entry.getKey()}</td>
            <td>:</td>
            <td>${entry.getValue()}</td>
            <tr>
            </c:forEach>
        </table>
        <div><a href="/users/delete?id=${user.get("id")}"> delete user </a></div>
    </body>
</html>

<!-- END -->
