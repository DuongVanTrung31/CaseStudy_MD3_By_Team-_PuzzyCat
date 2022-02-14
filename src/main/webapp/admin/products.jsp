<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/admin/common" var="url"/>
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
    <h3>All Product</h3>
    <p>Thông tin tất cả sản phẩm hiện có được hiển thị ở đây !!</p>
</div>
<c:if test="${requestScope.checkDel}">
    <h1 class="danger"> Xóa sản phẩm thành công  !!!</h1>
</c:if>
<c:if test="${requestScope.checkDel}">
    <h1 class="danger"> Sửa sản phẩm thành công  !!!</h1>
</c:if>
<div class="container-fluid">
    <c:if test="${requestScope.checkDel == true}">
        <h3> DELETE PRODUCT SUCCESSFUL </h3>
    </c:if>
    <c:if test="${requestScope.checkDel == false}">
        <h3> DELETE PRODUCT FAILURE </h3>
    </c:if>
</div>
<div class="container-fluid col-md-12">
    <div class="table-responsive">
        <table class="table table-bordered table-sm" id="table">
            <tr>
                <td> ID</td>
                <td> SERIAL</td>
                <td> NAME</td>
                <td> Category</td>
                <td> Brand</td>
                <td> Price</td>
                <td> Quantity</td>
                <td> Description</td>
                <td> Image</td>
                <td colspan="2">Button</td>
            </tr>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.serial}</td>
                    <td>${product.name}</td>
                    <td>${product.category}</td>
                    <td>${product.brand}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.description}</td>
                    <td><img src="${product.img}" style="height: 100px"></td>
                    <td><a href="/admin?action=delete&id=${product.id}" class="btn btn-warning">Delete</a></td>
                    <td><a href="/admin?action=showFormEdit&id=${product.id}" class="btn btn-info">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="container-fluid">
    <h3> ADD PRODUCT</h3>
    <p>Thêm sản phẩm mới - Sửa thông tin sản phẩm ở đây !!</p>
</div>

<div class="container col-md-9">
    <div class="row">
        <div class="col-md-6">
            <h3>Form ADD PRODUCT </h3>
            <form action="/admin?action=add" method="post">
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="ID" name="id" disabled>
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="SERIAL" name="serial">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="NAME" name="name">
                </div>
                <div class="input-group mt-3 mb-3">
                    <select name="category">
                        <c:forEach items="${requestScope.categories}" var="cate">
                            <option value="${cate.id}">${cate.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group mt-3 mb-3">
                    <select name="brand">
                        <c:forEach items="${requestScope.brands}" var="brand">
                            <option value="${brand.id}">${brand.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group mb-3">
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
                    <input type="text" class="form-control" placeholder="CREATE DATE" disabled>
                </div>
                <input type="submit" value="ADD PRODUCT">
            </form>
        </div>
    </div>
</div>

</body>
</html>
