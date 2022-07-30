<!doctype html>

<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>

<link rel="stylesheet" href="/css/colors.css">
<link rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="/css/tables.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table').DataTable();
		$('.dataTables_length').addClass('bs-select');
	});
</script>
<style type="text/css">
<%@include file="css/colors.css"%>
<%@include file="css/tables.css"%>
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body class="">
	<header class="fixed-top">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="ps-3 navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ps-5">
					<li class="nav-item"><a class="nav-link" href="libros.html">Libros</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="prestamos.html">Prestamos</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="clientes.html">Clientes</a>
					</li>
					<!-- <a href="login.html" class="nav-link ps-3 pe-3">Iniciar sesion</a> -->
				</ul>
			</div>
			<div
				class="d-flex justify-content-center align-items-center flex-row ps-3 pe-3">
				<!-- <a href="login.html" class="nav-link ps-3 pe-3">Iniciar sesion</a> -->
				<!-- <a href="registrarse.html" class="nav-link ps-3 pe-3">Registrarse</a> -->
				<p class="ps-3 pe-3 mb-0">${username}</p>
				<a href="index.html" class="nav-link ps-3 pe-3">Cerrar sesion</a>
			</div>
		</nav>
	</header>
	<main
		class="d-flex flex-column justify-content-center align-items-center p-5 w-100">
	<p class="text-primary m-5 bg-white">${msg}</p>
	<form
		class="d-flex flex-row rounded shadow bg-white rounded w-50 mb-5 mt-5 p-3 flex-wrap justify-content-center"
		action="addBook.html" method="post">
		<h1>Añadir biblioteca</h1>
		<div class="w-100 d-flex flex-row">
			<div class="m-3 w-50">
				<label for="Libro" class="form-label">Libros</label> <select
					class="form-select" aria-label="Default select example" id="Libro"
					name="Libro">
					<c:forEach items="${libros}" var="item">
						<option value="${item.getISBN()}">${item.getTitulo()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="m-3 w-50">
				<label for="fechaAlta" class="form-label">Fecha de
					lanzamiento</label> <input type="date" class="form-control"
					name="fechaAlta" id="fechaAlta" required>
			</div>
		</div>
		<div
			class="w-100 d-flex flex-row justify-content-center align-content-center pt-3">
			<button type="submit" class="btn btn-primary" id="submit"
				name="submit">Añadir biblioteca</button>
		</div>
	</form>
	<div style="background-color: white;"
		class="d-flex justify-content-center align-items-center">
		<table class="tableCss" id="table">
			<thead class="">
				<tr>
					<th>Biblioteca</th>
					<th>Isbn</th>
					<th>Titulo</th>
					<th>Fecha de lanzamiento</th>
					<th>Fecha de alta</th>
					<th>Idioma</th>
					<th>Cantidad de paginas</th>
					<th>Autor</th>
					<th>Estado</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bibliotecas}" var="item">
					<tr>
				<form action="eliminarBiblioteca.html" method="post">
					<td class="p-3">${item.getID()}
					<input type="hidden" name="id"
						value="${item.getID()}" readonly class="form-control"></td>
					<td class="p-3">${item.getLibro().getISBN()}
					<input type="hidden"
						value="${item.getLibro().getISBN()}" readonly class="form-control"></td>
					<td class="p-3">
					${item.getLibro().getTitulo()}
					<input type="hidden"
						value="${item.getLibro().getTitulo()}" readonly class="form-control"></td>
					<td class="p-3">
					${item.getLibro().getFechaLanzamiento()}
					<input type="hidden"value="${item.getLibro().getFechaLanzamiento()}" readonly class="form-control"></td>
					<td class="p-3">${item.getFechaDeAlta()}
					<input type="hidden"
						value="${item.getFechaDeAlta()}" readonly
						class="form-control"></td>
					<td class="p-3">
					${item.getLibro().getIdioma()}
					<input type="hidden"
						value="${item.getLibro().getIdioma()}" readonly class="form-control"></td>
					<td class="p-3">
					${item.getLibro().getCantidadPaginas()}<input type="hidden"
						value="${item.getLibro().getCantidadPaginas()}" readonly class="form-control"></td>
					<td class="p-3">
					${item.getLibro().getAutor().getNombreCompleto()}
					<input type="hidden"
						value="${item.getLibro().getAutor().getNombreCompleto()}" class="form-control" readonly></td>
					<td class="p-3">${item.getEstado()}
					<input type="hidden" name="estado"
						value="${item.getEstado()}" class="form-control" readonly></td>
					<td class="p-3 d-flex flex-row"><button type="submit"
							class="btn btn-primary" id="Eliminar" name="Eliminar">Eliminar</button>
					</td>
				</form>
					</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</main>
	<script type="text/javascript">
        let arrInputsEstado = document.getElementsByName("estado");
            for(let i = 0; i < arrInputsEstado.length; i++){
                let inputEstado = arrInputsEstado[i];
                let btnCerrarPrestamo = inputEstado.parentElement.nextElementSibling.firstElementChild;
                if(inputEstado.value.toLowerCase() != "en biblioteca")
                    btnCerrarPrestamo.disabled = true;
            }
    </script>
</body>

</html>