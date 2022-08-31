<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <head>
        <title>MangaShop</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
                crossorigin="anonymous"></script>
    </head>
</head>
<body>

<header>

    <div class="navbar navbar-dark bg-dark shadow-sm">
        <button type="button" class="btn btn-secondary">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person"
                 viewBox="0 0 16 16">
                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
            </svg>
        </button>
        <div class="container" style="background-color: rgba(55, 56, 55, 0.767);">
            <a href="#" class="navbar-brand d-flex align-items-center"
               style="background-color: rgba(55, 56, 55, 0.767);">
                <form action="main" method="get">
                    <strong>MangaShop</strong>
                </form>
            </a>
        </div>
    </div>
</header>
<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-4">
    <div class="col">
        <p style="text-align: center">Данные Покупателя</p>
        <div class="card shadow-sm">

            <div class="card-body">
                <p class="card-text">Фамилия: ${customer.firstName}</p>
                <p class="card-text">Имя: ${customer.lastName}</p>
                <p class="card-text">Почта: ${customer.email}</p>
                <p class="card-text">Телефон: ${customer.phone}</p>
                <p class="card-text">Город: ${customer.city}</p>
                <p class="card-text">Улица: ${customer.address}</p>
                <p class="card-text">Номер дома: ${customer.houseNumber}</p>
                <p class="card-text">Номер квартиры: ${customer.apartment}</p>
            </div>
        </div>
    </div>
</div>


<br>
<div class="col">
    <core:forEach var="order" items="${orders}">
        <br>
        <div class="card-body">
            <p class="card-text">Номер чека: ${order.cheque}</p>
            <p class="card-text">Название: ${order.title}</p>
            <p class="card-text">Цена: ${order.price}</p>
            <p class="card-text">Итоговая стоимость: ${order.amount}</p>
        </div>
        <br>
    </core:forEach>
</div>


<div class="container">
    <footer class="py-3 my-4">
        <p class="text-center text-muted">© 2022 Test</p>
    </footer>
</div>
</body>
</html>
