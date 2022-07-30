<!doctype html>
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
        <%@include file="css/colors.css" %><%@include file="css/tables.css" %>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body class="">
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
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="micuenta.html">Mi cuenta</a>
                    </li> -->
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
    <main class="d-flex flex-column justify-content-center align-items-center p-5 w-100 mt-5">
        <p class="text-primary m-5 bg-white">${msg}</p>
        <form class="w-25 formBackground p-4 rounded shadow p-3 mb-5 bg-white rounded" action="addClient.html"
            method="post">
            <div class="mb-3">
                <label for="dni" class="form-label">DNI:</label>
                <input type="number" class="form-control" id="dni" name="dni" required>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="mb-3">
                <label for="surname" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="surname" name="surname" required>
            </div>
            <div class="mb-3">
                <label for="sex" class="form-label">Nacionalidad</label>
                <select class="form-select" aria-label="Default select example" id="nationality" name="nationality"
                    required>
                    <c:forEach items="${nacionalidadesList}" var="item">
                        <option value="${item.getID()}">${item.getDescripcion()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="sex" class="form-label">Sexo</label>
                <select class="form-select" aria-label="Default select example" id="sex" name="sex">
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="sex" class="form-label">Fecha de nacimiento</label>
                <input type="date" class="form-control" name="date" required>
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Direccion</label>
                <input type="text" class="form-control" id="address" name="address" aria-describedby="emailHelp"
                    required>
            </div>
            <div class="calendar" id="calendar"></div>
            <div class="mb-3">
                <label for="phone" class="form-label">Telefono</label>
                <input type="number" class="form-control" id="phone" name="phone" aria-describedby="emailHelp" required>
            </div>
            <div class="mb-3">
                <label for="district" class="form-label">Localidad</label>
                <input type="text" class="form-control" id="district" name="district" aria-describedby="emailHelp"
                    required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Direccion de email</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
            </div>
            <button type="submit" class="btn btn-primary" id="submit" name="submit">Cargar cliente</button>
        </form>
        <div style="background-color: white;" class="d-flex justify-content-center align-items-center">
            <table class="tableCss" id="table">
                <thead class="">
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Nacionalidad</th>
                        <th>Sexo</th>
                        <th>Fecha de nacimiento</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                        <th>Localidad</th>
                        <th>Direccion de email</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientesList}" var="item">
                        <tr>
                            <form action="modificarCliente.html" method="post">
                                <td class="p-3">
                                ${item.getID()}
                                <input type="hidden" name="id" value="${item.getID()}" readonly
                                        class="form-control"></td>
                                <td class="p-3">${item.getDni()}</td>
                                <td class="p-3">${item.getNombre()}</td>
                                <td class="p-3">${item.getApellido()}</td>
                                <td class="p-3">${item.getNacionalidad().getDescripcion()}</td>
                                <td class="p-3">${item.getSexo()}</td>
                                <td class="p-3">${item.getFechaNacimiento()}</td>
                                <td class="p-3">
                                <input type="text" name="address" value="${item.getDireccion()}"
                                        class="form-control"></td>
                                <td class="p-3">
                                <input type="text" name="phone" value="${item.getTelefono()}"
                                        class="form-control"></td>
                                <td class="p-3">
                                <input type="text" name="district" value="${item.getLocalidad()}"
                                        class="form-control"></td>
                                <td>
                                    ${item.getEmail()}
                                </td>
                                <td class="p-3 d-flex flex-row"><button type="submit" class="btn btn-primary"
                                        id="modify" name="modify">Modificar</button>
                                        <input type="button" value="Eliminar"  onclick="location.href = 'eliminarCliente.html?id=${item.getID()}';"	class="btn btn-primary ms-3">
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>

</html>