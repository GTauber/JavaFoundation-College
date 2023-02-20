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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/home">Barbershop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/listBarbers">Barbers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Beards</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Brows</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Hairs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Attendance</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/listUsers">List of Users</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1>List of Barbers</h1>
    <button type="button" class="btn btn-success" onclick="location.href='/registerBarber'">New</button>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>CPF</th>
            <th>Gender</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${barbers}" var="barber">
            <tr>
                <td>${barber.name}</td>
                <td>${barber.cpf}</td>
                <td>${barber.gender}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>