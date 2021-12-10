
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, height=device-height initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Estonia&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link href="css/index.css" rel="stylesheet" />
<link href="sticky-footer.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<title>Turismo Tierra Media</title>
</head>

<body id="listado" class="flex-column h-100 w-100 bg-verde-light">
	<jsp:include page="components/nav.jsp"></jsp:include>
	<div class="sticky-top">
		<jsp:include page="components/seleccionador.jsp"></jsp:include>
	</div>


	<div id="listado-cartas" class="container-fluid row row-cols-1 row-cols-md-2 g-4">


		<c:choose>
			<c:when test="${vendiblesFiltrados.isEmpty() }">
				<div class="container-fluid justify-center bg-verde"style="height: 300px; width:1000px ;">
					<h1 class="text-center">No se encontraron coincidencias</h1>
					<h3 class="text-center">Pruebe con otros parametros</h3>
				</div>
			</c:when>
			<c:when test="${!vendiblesfiltrados.isEmpty() }">
				<c:forEach items="${vendiblesFiltrados}" var="lista">

					<a href="/TierraMedia/index.jsp">
						<div class="col">
							<div class="card bg-verde-dark shadow text-white carta">
								<img src="img/La-Comarca.jpg" class="card-img" alt="..." />
								<div class="card-img-overlay">
									<h5 class="card-title">
										<c:out value="${lista.getNombre() }"></c:out>
									</h5>
									<h6>
										<c:out value="${lista.getTipo() }"></c:out>
										-
										<c:out value="${lista.getTiempoNecesario() }"></c:out>
										hs de Excursion
									</h6>
								</div>
								<div class="container card-body">
									<div class="row">
										<div class="text-left col-xs-12 col-md-6">
											<h6 class="btn btn-outline-light">Detalles</h6>
										</div>
										<div class="text-derecha col-xs-12 col-md-6">
											<h5 class="btn btn-outline-light">
												Precio:
												<c:out value="${lista.getCosto()}"></c:out>
											</h5>
										</div>
									</div>
								</div>
							</div>
						</div>
					</a>

				</c:forEach>
			</c:when>
		</c:choose>



	</div>

	<jsp:include page="components/footer.jsp"></jsp:include>
</body>

</html>