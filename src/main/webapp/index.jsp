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

<body id="container-body" class="container-fluid bg-verde-light">

	<div class="sticky-top">
    <jsp:include page="components/nav.jsp"></jsp:include>
    </div>

	<div id="container-body" class="container-fluid">

		<div id="CarouselIndex" class="carousel slide w-100"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/La-Comarca.jpg" class="d-block h-100 w-100" alt="..." />
					<div
						class="
                d-flex
                bg-gris-translucid
                carousel-caption
                d-none d-sm-block
              ">
						<h5 class="titulo-atraccion-index">¡Encuentra las mejores ofertas de la tierra media!</h5>
						<h4 class="text-color-light">Diferentes puntos turisticos que se acomodan a TÚ preferencia.</h4>
					</div>
				</div>
				<c:forEach items="${lista }" var="vendible">
				<div class="carousel-item">
					<img src="img/Mordor.jpg" class="d-block h-100 w-100" alt="..." />
					<div
						class="
                d-flex
                bg-gris-translucid
                carousel-caption
                d-none d-sm-block
              ">
						<h5 class="titulo-atraccion-index"><c:out value="${vendible.getNombre() }"></c:out></h5>
						<!-- <p class="text-color-light">Propuesta de Aventuras
							inimaginables por todo los terrenos de Mordor.</p> -->
					</div>
				</div>
				</c:forEach>
				
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#CarouselIndex" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#CarouselIndex" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<div
			 class="container navbar mt-5 pt-2 shadow bg-obscure justify-content-center">
			<h2 class="text-center mt-1 text-color-light col-sm-12">Lista
				nuestros paquetes segun tus preferencias.</h2>

		</div>
		<jsp:include page="components/seleccionador.jsp"></jsp:include>
		
		</div>

		<jsp:include page="components/footer.jsp"></jsp:include>
</body>

</html>