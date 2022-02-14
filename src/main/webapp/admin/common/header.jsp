<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <!--    head-->
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="admin?action=display  ">Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <!--                toggle product-->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown">Product</a>
                        <ul class="dropdown-menu">
                            <!--                        forEach duyệt tên category ở dây-->
                            <!--                        sau khi product thêm category sẽ có thêm loại sp mới ngoài 3 cái đã có-->
                            <li><a class="dropdown-item" href="admin?action=products">CREATE AND EDIT PRODUCTS</a></li>
                            <li><a class="dropdown-item" href="admin?action=smartphone">Smart phone</a></li>
                            <li><a class="dropdown-item" href="admin?action=tablet">Tablet</a></li>
                            <li><a class="dropdown-item" href="admin?action=laptop">Laptop</a></li>


                        </ul>
                    </li>
                    <!--                toggle product-->

                    <!--                toggle user-->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">User</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="admin?action=users">ALL ACCOUNTS</a></li>
                            <li><a class="dropdown-item" href="admin?action=admins">Admin</a></li>
                            <li><a class="dropdown-item" href="admin?action=customers">Customer</a></li>
<%--                            <li><a class="dropdown-item" href="admin?action=staffs">Staff</a></li>--%>

                        </ul>
                    </li>
                    <!--                toggle order-->

                    <!--                toggle order - ship ment -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Order</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Order Detail</a></li>
                            <li><a class="dropdown-item" href="#">Ship Ment</a></li>
                        </ul>
                    </li>
                    <!--                 toggle order - ship ment -->
                </ul>

            </div>
        </div>
    </nav>
</div>