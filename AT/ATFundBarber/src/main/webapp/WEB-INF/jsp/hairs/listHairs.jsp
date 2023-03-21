<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Hairs</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/menu.jsp" %>
<div class="container">
    <h1>List Hairs</h1>
    <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#registerHairModal">New</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Available</th>
            <th>Height</th>
            <th>Width</th>
            <th>Fade</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hairs}" var="hair">
            <tr>
                <td>${hair.id}</td>
                <td>${hair.name}</td>
                <td>${hair.price}</td>
                <td>${hair.available}</td>
                <td>${hair.height}</td>
                <td>${hair.width}</td>
                <td>${hair.fade}</td>
                <td>
                    <form action="/deleteHair" method="post">
                        <input type="hidden" name="id" value="${hair.id}" />
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
<div class="modal fade" id="registerHairModal" tabindex="-1" role="dialog" aria-labelledby="registerHairModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/registerHair">
                <div class="modal-header">
                    <h5 class="modal-title" id="registerHairModalLabel">Register Hair</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number" step="0.01" class="form-control" id="price" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="available">Available:</label>
                        <select class="form-control" id="available" name="available" required>
                            <option value="true">Yes</option>
                            <option value="false">No</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="height">Height:</label>
                        <input type="number" step="0.01" class="form-control" id="height" name="height" required>
                    </div>
                    <div class="form-group">
                        <label for="width">Width:</label>
                        <input type="number" step="0.01" class="form-control" id="width" name="width" required>
                    </div>
                    <div class="form-group">
                        <label for="fade">Fade:</label>
                        <select class="form-control" id="fade" name="fade" required>
                            <option value="true">Yes</option>
                            <option value="false">No</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>