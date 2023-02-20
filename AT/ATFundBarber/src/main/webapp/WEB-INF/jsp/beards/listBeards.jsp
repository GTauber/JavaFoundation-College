<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Beard List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/menu.jsp" %>
<div class="container">
    <div class="row mt-5">
        <div class="col-12">
            <h1>Beard List</h1>
            <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#newBeardModal">New</button>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Available</th>
                    <th>Style</th>
                    <th>Length</th>
                    <th>Texture</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${beards}" var="brows">
                    <tr>
                        <td>${brows.id}</td>
                        <td>${brows.name}</td>
                        <td>${brows.price}</td>
                        <td>${brows.available}</td>
                        <td>${brows.style}</td>
                        <td>${brows.length}</td>
                        <td>${brows.texture}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%-- New Beard Modal --%>
<div class="modal fade" id="newBeardModal" tabindex="-1" role="dialog" aria-labelledby="newBeardModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newBeardModalLabel">New Beard</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="POST" action="/registerBeard">
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
                    <div class="mb-3">
                        <label for="style" class="form-label">Style</label>
                        <select class="form-select" id="style" name="style" required>
                            <option value="">Choose...</option>
                            <option value="Natural">Natural</option>
                            <option value="Stubble">Stubble</option>
                            <option value="Short Beard">Short Beard</option>
                            <option value="Medium Beard">Medium Beard</option>
                            <option value="Long Beard">Long Beard</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="length" class="form-label">Length</label>
                        <input type="number" class="form-control" id="length" name="length" required>
                    </div>
                    <div class="mb-3">
                        <label for="texture" class="form-label">Texture</label>
                        <input type="text" class="form-control" id="texture" name="texture" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>