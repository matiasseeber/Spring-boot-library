arreg<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link rel="stylesheet" href="/css/colors.css">
    <link rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/css/tables.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#table').DataTable();
        });
    </script>
    <style type="text/css">
	<%@include file="css/colors.css" %>
	<%@include file="css/tables.css" %>
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body class="vh-100">
    <header class="fixed-top">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="ps-3 navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ps-5">
                    <li class="nav-item">
                        <a class="nav-link" href="libros.html">Libros</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="prestamos.html">Prestamos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="clientes.html">Clientes</a>
                    </li>
                    <!-- <a href="login.html" class="nav-link ps-3 pe-3">Iniciar sesion</a> -->
                </ul>
            </div>
            <div class="d-flex justify-content-center align-items-center flex-row ps-3 pe-3">
                <!-- <a href="login.html" class="nav-link ps-3 pe-3">Iniciar sesion</a> -->
                <!-- <a href="registrarse.html" class="nav-link ps-3 pe-3">Registrarse</a> -->
                <p class="ps-3 pe-3 mb-0">${username}</p>
                <a href="index.html" class="nav-link ps-3 pe-3">Cerrar sesion</a>
            </div>
        </nav>
    </header>
    <main class="d-flex flex-column justify-content-center align-items-center p-5 w-100">
        <p class="text-primary m-5 bg-white">${msg}</p>
        <form action="addLoan.html" method="post" class="d-flex flex-row rounded shadow bg-white rounded w-50 mb-5 mt-5 p-3 flex-wrap justify-content-center">
            <h1>Sacar prestamo</h1>
            <div class="w-100 d-flex flex-row">
                <div class="m-3 w-50">
                    <label for="Biblioteca" class="form-label">Biblioteca</label>
                    <select class="form-select" aria-label="Default select example" id="Biblioteca" name="Biblioteca">
                        <c:forEach items="${bibliotecas}" var="item">
                        <option value="${item.getID()}">${item.getID()}</option>
                    	</c:forEach>
                    </select>
                </div>
                <div class="m-3 w-50">
                    <label for="client" class="form-label">Cliente</label>
                    <select class="form-select" aria-label="Default select example" id="client" name="client">
                        <c:forEach items="${clientesList}" var="item">
                        	<option value="${item.getID()}">${item.getNombreCompleto()}</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
            <div class="w-100 d-flex flex-row">
                <div class="m-3 w-50">
                    <label for="date" class="form-label">Fecha de prestamo</label>
                    <input type="date" class="form-control" required name="date">
                </div>
                <div class="m-3 w-50">
                    <label for="cantdias" class="form-label" required>Cantidad de dias</label>
                    <input type="number" name="cantdias" id="cantdias" class="form-control" min="1">
                </div>
            </div>
            <div class="w-100 d-flex flex-row justify-content-center align-content-center pt-3">
                <button type="submit" class="btn btn-primary" id="submit" name="submit">Sacar prestamo</button>
            </div>
        </form>
        <div style="background-color: white;" class="d-flex justify-content-center align-items-center">
            <table class="tableCss" id="table">
                <thead class="">
                    <tr>
                        <th>ID de prestamo</th>
                        <th>ID de Biblioteca</th>
                        <th>ISBN</th>
                        <th>Cliente</th>
                        <th>Fecha de prestamo</th>
                        <th>Cantidad de dias</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${loans}" var="item">
                        <tr>
                        <form action="cerrarPrestamo.html" method="post">
                            <td class="p-3">${item.getID()}
                            <input type="hidden" name="idPrestamo" value="${item.getID()}">
                            </td>
                            <td class="p-3">${item.getBiblioteca().getID()}</td>
                            <td class="p-3">${item.getBiblioteca().getLibro().getISBN()}</td>
                            <td class="p-3">${item.getCliente().getNombreCompleto()}</td>
                            <td class="p-3">${item.getFechaDePrestamo()}</td>
                            <td class="p-3">${item.getCantDias()}
                                <input type="hidden" class="estadoPrestamoInput" value="${item.isEstado()}">
                                </td>
                            <td class="p-3">
                            	<button type="submit" class="btn btn-primary">Cerrar prestamo</button>
                            </td>
                        </form>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
    <script type="text/javascript">
        let arrInputsEstado = document.getElementsByClassName("estadoPrestamoInput");
            for(let i = 0; i < arrInputsEstado.length; i++){
                let inputEstado = arrInputsEstado[i];
                let btnCerrarPrestamo = inputEstado.parentElement.nextElementSibling.firstElementChild;
                if(inputEstado.value.toLowerCase() != "true")
                    btnCerrarPrestamo.disabled = true;
            }
    </script>
</body>

</html>