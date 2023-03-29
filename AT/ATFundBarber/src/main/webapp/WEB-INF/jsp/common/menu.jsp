<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light d-flex justify-content-between">
    <a class="navbar-brand" href="/home">Barbershop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon">saaaa</span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <c:if test="${not empty userSession}">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/listBarbers">Barbers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/beards">Beards</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/brows">Brows</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hairs">Hairs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/listAttendance">Attendance</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listUsers">List of Users</a>
                </li>
            </ul>
        </c:if>
    </div>
    <div class="d-flex">
        <c:if test="${not empty userSession}">
            <p class="m-0">Bem-vindo: ${userSession.userName}!</p>
            <a class="nav-link p-0 pl-1" href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:if>
    </div>
</nav>