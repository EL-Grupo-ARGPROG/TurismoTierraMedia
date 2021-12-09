<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<body class="flex-column h-100 w-100 bg-verde-light">

	<jsp:include page="components/nav.jsp"></jsp:include>

	<div class="container-fluid">

		<div
			class="container navbar mt-5 shadow bg-verde justify-content-center col-sm-12">
			<h2 class="text-center mt-4 text-color-light col-sm-12">Panel de
				control: Atracciones</h2>
			<div class="container row justify-content-center">
				<select class="form-select shadow center-element"
					aria-label="Default select example">
					<option class="text-center text-dark" selected>Tipo de
						Paquete</option>
					<option class="text-center text-dark" value="1">Aventura</option>
					<option class="text-center text-dark" value="2">Degustacion</option>
					<option class="text-center text-dark" value="3">Paisaje</option>
				</select>
				<button class="btn boton-filtro shadow btn-success bg-verde-light"
					type="submit">
					<i style="font-size: 1.5rem" class="bi bi-filter"></i>
				</button>
				<button class="btn boton-filtro shadow btn-success bg-verde-light"
					type="button" data-bs-toggle="modal" data-bs-target="#modal1">
					<i style="font-size: 1.3rem" class="bi bi-plus-square"></i>
				</button>
			</div>

			<div class="modal fade" id="modal1" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1" aria-labelledby="modalLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content shadow bg-obscure">
						<div class="modal-header">
							<h5 class="modal-title">Nueva atraccion</h5>
							<button type="button" class="btn-close btn-close-white"
								data-bs-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form g-4 mb-2">
									<p>Nombre:</p>
									<input type="text" class="form" />
								</div>
								<div class="form g-3 mb-2">
									<p>Costo:</p>
									<input type="number" class="form" />
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="button" class="btn btn-success bg-verde-dark">
								Send message</button>
						</div>
					</div>
				</div>
			</div>

			<div class="container">
				<table class="table table-success table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nombre</th>
							<th scope="col">Costo</th>
							<th scope="col">Tiempo</th>
							<th scope="col">Cupos</th>
							<th scope="col">Tematica</th>
							<th scope="col">Administrar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vendiblesList}" var="vendible">
							<tr>
								<td><strong><c:out value="${vendible.getNombre()}"></c:out></strong></td>
								<td><c:out value="${vendible.getCosto()}"></c:out></td>
								<td><c:out value="${vendible.getTiempoNecesario()}"></c:out></td>
								<td><c:out value="${vendible.getCupo()}"></c:out></td>
								<td><c:out value="${vendible.getTipo()}"></c:out></td>
								<td>
									<div class="d-flex justify-content-center">
										<button class="btn btn-sm me-2 btn-success bg-verde-light"
											type="submit">
											<i style="font-size: 1.3rem" class="bi bi-pencil-square"></i>
										</button>
										<button class="btn btn-sm btn-success bg-verde-light"
											type="submit">
											<i style="font-size: 1.3rem" class="bi bi-eye"></i>
										</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>

	<jsp:include page="components/footer.jsp"></jsp:include>
</body>

</html>