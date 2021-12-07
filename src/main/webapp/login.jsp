<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
<link href="sticky-footer.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link href="css/index.css" rel="stylesheet" />

<title>Turismo Tierra Media</title>
</head>
<body style="width:100%" >

	<div class="container-fluid">
		<jsp:include page="components/nav.jsp"></jsp:include>

		<div class="col-lg-5 mx-auto p-3 py-md-5">

			<main>
				<h1>Turismo en la Tierra Media</h1>


				<c:if test="${flash != null}">
					<div class="alert alert-danger">
						<p>
							<c:out value="${flash}" />
						</p>
					</div>
				</c:if>

				<form action="login" method="post">

					<div class="mb-3">
						<label for="username" class="form-label">Usuario</label> <input
							class="form-control" name="username">
					</div>

					<div class="mb-3">
						<label for="password" class="form-label">Contraseña</label> <input
							type="password" class="form-control" name="password">
					</div>

					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
					</div>
				</form>

			</main>
		</div>
	</div>
</body>
</html>