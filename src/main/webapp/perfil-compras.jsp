<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="persistence.impl.PromocionesDAOImpl,model.Sistema"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<title>Turismo Tierra Media</title>
</head>




<body id="container-body" class="container-fluid bg-verde-light">
	<div class="sticky-top">
		<jsp:include page="components/nav.jsp"></jsp:include>
	</div>
	<div class="container-fluid shadow">
		<div class="row">

			<div class="flex-column shadow p-0 col-md-2 bg-obscure">
				<h2 class="text-center mt-3">Sam</h2>

				<img class="foto-perfil" style="" src="img/Sam.jpg">

				<div class="row px-5">
					<div>
						<i title="monedas" style="color: white;" class="bi bi-coin p-1"></i>
						<c:out value="${user.getPresupuesto()}"></c:out>
					</div>
					<div>
						<i title="tiempo" style="color: white;"
							class="p-1 bi bi-clock-fill"></i>
						<c:out value="${user.getTiempoDisponible()}h"></c:out>
					</div>
				</div>

				<div class="nav navbuttons flex-column py-2 justify-content-top">
					<a class="btn bg-verde-dark active btn-success" aria-current="page"
						href="/perfil-datos.jsp">Datos</a> <a
						class="btn mt-1 mb-5 bg-verde-light btn-success"
						href="/TierraMedia/perfil-compras.jsp">Compras</a> <a
						class="btn mt-5 border-0 bg-verde-light btn-danger"
						href="/TierraMedia/logout">Cerrar session</a>
				</div>
			</div>
			<div class="col-md-10 p-5 container bg-verde text-center">
				<h1>Bienvenido a tu perfil, Sam.</h1>
				<br>
				<h6>Ahorra monedas y viaja con nosotros!</h6>
				<br>
				<div class="container-fluid">
					<table class="table table-success table-striped table-hover">
						<thead>
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Precio</th>
								<th scope="col">Horas</th>
								<th scope="col">Tematica</th>
								<th scope="col">Tipo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${user.getItinerario()}" var="itinerario">
								<tr>
									<td><c:out value="${itinerario.getNombre()}"></c:out></td>
									<td><c:out value="${itinerario.getCosto()}"></c:out></td>
									<td><c:out value="${itinerario.getTiempoNecesario()}"></c:out></td>
									<td><c:out value="${itinerario.getTipo()}"></c:out></td>
									<td><c:out value="${itinerario.esPromocion()}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>



	<jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>