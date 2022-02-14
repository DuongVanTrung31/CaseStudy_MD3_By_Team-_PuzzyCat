<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/login/admin/common" var="url"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="${url}/head.jsp"/>
</head>
<body>
<jsp:include page="${url}/header.jsp"/>

<div class="container-fluid">
    <h3>All User</h3>
    <p>Thông tin tất cả tài khoản hiện có được hiển thị ở đây !!</p>
</div>

<div class="container-fluid col-md-12">
    <div class="table-responsive">

        <table class="table table-bordered table-sm">
            <tr>
                <td>ID</td>
                <td>ACCOUNT</td>
                <td>FIRSTNAME</td>
                <td>LASTNAME</td>
                <td>ADDRESS</td>
                <td>PHONE</td>
                <td>EMAIL</td>
                <td>BIRTHDAY</td>
                <td>ROLE</td>
                <td>STATUS</td>
                <td colspan="2">Button</td>
            </tr>
            <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.account}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td>${user.birthDate}</td>
                    <td>${user.role}</td>
                    <td>${user.status}</td>
                    <td><a href="" class="btn btn-warning">Delete</a></td>
                    <td><a href="" class="btn btn-info">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
