<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Barbers</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/menu.jsp" %>
<div class="container">
    <h1>List of Barbers</h1>
    <button type="button" class="btn btn-success" onclick="location.href='/registerBarber'">New</button>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>CPF</th>
            <th>Gender</th>
            <th>Related User ID</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${barbers}" var="barber">
            <tr>
                <td>${barber.name}</td>
                <td>${barber.cpf}</td>
                <td>${barber.gender}</td>
                <td>${barber.user.id}</td>
                <td>
                    <form action="/deleteBarber" method="post">
                        <input type="hidden" name="id" value="${barber.id}" />
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