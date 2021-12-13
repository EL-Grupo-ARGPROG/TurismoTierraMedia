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




<body class="flex-column h-100 w-100 bg-verde-light">
	<jsp:include page="components/nav.jsp"></jsp:include>
	<div class="container-fluid">

		<div class="nav flex-column justify-content-left bg-verde " style="width: 20%; height: 500px;">
			<img style="width:80px; height:70px; position:center;" src="img/GAMGEE-Verde.png">

			<nav class="nav nav-pills nav-fill">
				<a class="nav-link active" aria-current="page" href="#">Active</a> <a
					class="nav-link" href="#">Much longer nav link</a> <a
					class="nav-link" href="#">Link</a> <a class="nav-link disabled">Disabled</a>
			</nav>
		</div>

	</div>

	<jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>