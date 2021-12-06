<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Estonia&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link href="css/index.css" rel="stylesheet">
<link href="sticky-footer.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<title>Turismo Tierra Media</title>
</head>

<body id="listado" class="flex-column h-100 w-100 bg-verde-light">

	<nav class="shadow navbar navbar-dark bg-obscure">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img src="img/GAMGEE-White.png"
				width="60" height="50" class="d-inline-block align-text-bottom">
				GAMGEE TOURISM AGENCY
			</a>
			<button class="btn shadow" type="button" data-bs-toggle="offcanvas"
				data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
				<i class="bi bi-list" style="font-size: 2rem; color: white"></i>
			</button>
			<div class="offcanvas offcanvas-end bg-verde-dark" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h3 class="offcanvas-title" id="offcanvasNavbarLabel"></h3>
					<button type="button" class="btn-close btn-close-white text-reset"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#homepage">
								<h5>Inicio</h5>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								<h5>Contacto</h5>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								<h5>Promociones</h5>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">
								<h5>Paquetes turisticos</h5>
						</a></li>
					</ul>
					<img id="logo-offcanvas" class="float-end"
						src="img/GAMGEE-verde.png">
				</div>
			</div>
		</div>
	</nav>

	<div
		class="container navbar sticky-top border-round shadow bg-obscure justify-content-center">
		<div class="container row justify-content-center">
			<select class="form-select shadow center-element "
				aria-label="Default select example">
				<option class="text-center text-dark" selected
					placeholder="Tipo Paquete">Tipo de Paquete</option>
				<option class="text-center text-dark" value="1">AVENTURA</option>
				<option class="text-center text-dark" value="2">
					DEGUSTACION</option>
				<option class="text-center text-dark" value="3">PAISAJE</option>
			</select> <select class="form-select shadow center-element "
				aria-label="Default select example">
				<option class="text-center text-dark" selected>Rango de
					Precio</option>
				<option class="text-center text-dark" value="1">0 - 200</option>
				<option class="text-center text-dark" value="2">201 - 400</option>
				<option class="text-center text-dark" value="3">401 - 600</option>
				<option class="text-center text-dark" value="3">601 - 800</option>
				<option class="text-center text-dark" value="3">801 - 1000
				</option>
			</select> <select class="form-select shadow center-element "
				aria-label="Default select example">
				<option class="text-center text-dark" selected>Duracion Hs</option>
				<option class="text-center text-dark" value="1">1 - 2</option>
				<option class="text-center text-dark" value="2">3 - 4</option>
				<option class="text-center text-dark" value="3">5 - 6</option>
			</select>
			<button class="btn boton-filtro shadow btn-success bg-verde-light"
				type="submit">
				<b><i class="bi bi-search"></i></b>
			</button>
		</div>
	</div>

	<div id="listado-cartas" class="row row-cols-1 row-cols-md-2 g-4">

		<c:forEach items="${vendiblesFiltrados}" var="lista">
			<div class="col">
				<div class="card bg-verde-dark shadow text-white carta">
					<img src="img/La-Comarca.jpg" class="card-img-top" alt="..." />
					<div class="card-img-overlay">
						<h5 class="card-title">
							<c:out value="${lista.getNombre() }"></c:out>
						</h5>
						<h6>
							<c:out value="${lista.getTipo() }"></c:out>
							-
							<c:out value="${lista.getTiempoNecesario() }"></c:out>
							}hs de Excursion
						</h6>
					</div>
					<div class="container card-body">
						<div class="row">
							<div class="text-left col-xs-12 col-md-6">
								<h6>Detalles</h6>
							</div>
							<div class="text-derecha col-xs-12 col-md-6">
								<h5 class="btn btn-outline-light">Precio:
									${lista.getCosto()}</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>

	<footer class="sticky-bottom mt-5 py-4 bg-verde-dark">
		<div class="container">
			<div class="row">
				<div class="text-left col-xs-12 col-md-6">
					<h6>GAMGEE TOURISM AGENCY</h6>
				</div>
				<div class="col-xs-12 col-md-6 text-derecha ">
					<h6>Created by: EL Grupo</h6>
					<h6>
						<small>Proyecto final: Turismo en la Tierra Media</small>
					</h6>
					<div class="redes-footer">
						<a href="https://github.com/EL-Grupo-ARGPROG/TurismoTierraMedia">
							<i class="d-inline-block align-text-top link-light bi bi-github"
							style="font-size: 2rem;"></i>
						</a> <a href="https://www.youtube.com/watch?v=wM8Hfo-M_Vw"> <i
							class="d-inline-block align-text-top link-light bi bi-youtube"
							style="font-size: 2rem;"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>