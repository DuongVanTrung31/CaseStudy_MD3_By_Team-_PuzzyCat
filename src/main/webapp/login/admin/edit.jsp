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


<div class="container col-md-9">
    <div class="row">
        <div class="col-md-6">
            <h3>Form ADD PRODUCT </h3>
            <form>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="ID" name="id">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="SERIAL" name="serial">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="NAME" name="name">
                </div>
                <div class="input-group mt-3 mb-3" name="category">
                    <input type="number" class="form-control" placeholder="Category" name="category">
                </div>
                <div class="input-group mt-3 mb-3" name="brand">
                    <input type="number" class="form-control" placeholder="Brand" name="brand">
                </div>
                <div class="input-group mb-3" name="price">
                    <span class="input-group-text">$</span>
                    <input type="text" class="form-control" aria-label="Dollar amount" placeholder="Price" name="price">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="QUANTITY" name="quantity">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="DESCRIPTION" name="description">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="IMG LINK" name="imageURL">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="CREATE DATE">
                </div>
                <input type="submit" value="ADD PRODUCT" href="admin?action=add">
            </form>
        </div>
    </div>
</div>