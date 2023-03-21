<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User List</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/menu.jsp" %>
<div class="container mt-5">
    <h1>User List</h1>
    <c:if test="${not empty success}">
        <div class="alert alert-success" role="alert">
            ${success}
        </div>
    </c:if>
    <button type="button" class="btn btn-success" onclick="location.href='/logged/registerUser'">New</button>
    <table class="table table-striped table-hover mt-3">
        <thead>
        <tr>
            <th>UUID</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="users" scope="request" type="java.util.List"/>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.userName}" /></td>
                <td><c:out value="${user.firstName}" /></td>
                <td><c:out value="${user.lastName}" /></td>
                <td><c:out value="${user.dateOfBirth}" /></td>
                <td>
                    <form action="/deleteUser" method="post">
                        <input type="hidden" name="id" value="${user.id}" />
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
                <td>
                    <button type="button" class="btn btn-primary disabled">Edit</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>