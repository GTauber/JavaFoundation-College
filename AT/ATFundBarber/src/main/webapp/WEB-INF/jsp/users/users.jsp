<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tauber.atfundbarber.model.entity.User"%>
<%@ page import="com.tauber.atfundbarber.service.UserService" %>
<%@ page import="lombok.AllArgsConstructor" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.tauber.atfundbarber.repository.UserRepository" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: lightgrey">
<div class="container">
    <h2>List of Registered Users</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
        </tr>
        </thead>
        <tbody>
        <%
            UserService userService = new UserService() {
                @Override
                public User saveNewUser(User user) {
                    return null;
                }

                @Override
                public List<User> getAllUsers() {
                    return null;
                }
            };
            var users = userService.
            List<User> userList = (List<User>) request.getAttribute("users");
            for (User user : userList) {
        %>
        <tr>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getDateOfBirth().toString()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>