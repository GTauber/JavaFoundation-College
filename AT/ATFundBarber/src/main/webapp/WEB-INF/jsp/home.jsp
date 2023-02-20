<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Barbershop Website</title>
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
<%@ include file="common/menu.jsp" %>
<div class="container mt-5">
    <h1>Welcome to our Barbershop</h1>
    <p class="mt-3">We provide a wide range of services to meet your grooming needs. Our experienced barbers are committed to providing the best quality services to our clients, with exceptional
        attention to detail and customer service.</p>
    <div class="row mt-5">
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://www.w3schools.com/bootstrap4/img_avatar1.png" alt="Barber">
                <div class="card-body">
                    <h4 class="card-title">John Doe</h4>
                    <p class="card-text">Experience: 5 years</p>
                    <p class="card-text">Specialty: Classic haircuts</p>
                    <a href="#" class="btn btn-primary">Book appointment</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://www.w3schools.com/bootstrap4/img_avatar2.png" alt="Barber">
                <div class="card-body">
                    <h4 class="card-title">Jane Smith</h4>
                    <p class="card-text">Experience: 10 years</p>
                    <p class="card-text">Specialty: Beard grooming</p>
                    <a href="#" class="btn btn-primary">Book appointment</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <img class="card-img-top" src="https://www.w3schools.com/bootstrap4/img_avatar3.png" alt="Barber">
                <div class="card-body">
                    <h4 class="card-title">Mike Johnson</h4>
                    <p class="card-text">Experience: 8 years</p>
                    <p class="card-text">Specialty: Hot towel shaves</p>
                    <a href="#" class="btn btn-primary">Book appointment</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>