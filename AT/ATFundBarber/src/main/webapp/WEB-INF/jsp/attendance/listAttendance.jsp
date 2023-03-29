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
    <h1>List Attendances</h1>
    <button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#registerAttendanceModal">New</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Total Price</th>
            <th>barber</th>
            <th>Attendance</th>
            <th>Cuts</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${attendances}" var="attendance">
            <tr>
                <td>${attendance.id}</td>
                <td>${attendance.date}</td>
                <td>${attendance.totalValue}</td>
                <td>${attendance.barber.name}</td>
<%--                <td>${attendance.cuts.name}</td>--%>
                <td>
                    <form action="/deleteAttendance" method="post">
                        <input type="hidden" name="id" value="${attendance.id}" />
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
<div class="modal fade" id="registerAttendanceModal" tabindex="-1" role="dialog" aria-labelledby="registerAttendanceModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" action="/registerAttendance">
                <div class="modal-header">
                    <h5 class="modal-title" id="registerAttendanceModalLabel">Register Hair</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="date">Date:</label>
                        <input type="date" class="form-control" id="date" name="date" required>
                    </div>
                    <div class="mb-3">
                        <label for="Barber" class="form-label">Barber</label>
                        <select class="form-select" id="Barber" name="barber" required>
                            <option value="">Choose...</option>
                            <c:forEach items="${barbers}" var="barber">
                                <option value="${barber.id}">${barber.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                            <label for="cuts[]" class="form-label">Cuts</label>
                        <c:forEach items="${cuts}" var="cut">
                            <input id="cuts[]" type="checkbox" name="cuts[]" value="${cut.id}"> ${cut.name}
                        </c:forEach>
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