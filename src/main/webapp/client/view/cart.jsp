
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/02/2022
  Time: 12:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/client/template" var="url"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="section">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col" class="text-uppercase header col-md-3">item</th>
                <th scope="col" class="text-uppercase header col-md-3">Name</th>
                <th scope="col" class="text-uppercase col-md-2">Quantity</th>
                <th scope="col" class="text-uppercase col-md-2">price each</th>
                <th scope="col" class="text-uppercase col-md-2">total</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${sessionScope.cart}" var="item">
                <td class="item">
                    <div class="d-flex"> <img src="${item.product.img}" alt="" height="100">
                    </div>
                </td>
                    <td class="item">
                            <div class="pl-2">${item.product.name}
                                <div class="d-flex flex-column justify-content-center">
                                    <div class="text-muted">${item.product.brand}</div>
                                </div>
                            </div>
                    </td>
                <td>
                    <div class="input-number">
                        <input type="number" name="qty" value="${item.quantity}">
                        <span class="qty-up">+</span>
                        <span class="qty-down">-</span>
                    </div>
                </td>
                <td class="d-flex flex-column"><span class="red">$ ${item.product.price} VND </span> <del class="cross">${item.product.price * 1.1}</del></td>
                <td class="font-weight-bold">${item.product.price * item.quantity}<div class="close"><a href="/cart?action=remove&id=${item.product.id}" class="btn btn-danger"> × Remove</a></div></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="4"><span class="red">$ Subtotal: <fmt:formatNumber value = "${requestScope.subtotal}"/> VND</span> </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
<!-- jQuery Plugins -->
<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/slick.min.js"></script>
<script src="${url}/js/nouislider.min.js"></script>
<script src="${url}/js/jquery.zoom.min.js"></script>
<script src="${url}/js/main.js"></script>
</body>
</html>