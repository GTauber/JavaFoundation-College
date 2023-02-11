<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>User Registration Form</title>
</head>
<body>
<div class="container">
    <h2 class="text-center">User Registration Form</h2>
    <form action="${pageContext.request.contextPath}/registerUser"
          method="post">
        <div class="form-group">
            <label for="firstName">First Name:</label> <input type="text"
                                                              class="form-control" id="firstName" placeholder="Enter first name"
                                                              name="firstName" required>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label> <input type="text"
                                                            class="form-control" id="lastName" placeholder="Enter last name"
                                                            name="lastName" required>
        </div>
        <div class="form-group">
            <label for="dateOfBirth">Date of Birth:</label> <input type="date"
                                                                   class="form-control" id="dateOfBirth" name="dateOfBirth" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label> <input type="password"
                                                           class="form-control" id="password" placeholder="Enter password"
                                                           name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>