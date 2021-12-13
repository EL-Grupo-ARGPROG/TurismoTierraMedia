<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="css/index.css" rel="stylesheet" />

<nav class="shadow navbar navbar-dark bg-obscure">
	<div class="container-fluid">
		<a class="navbar-brand" href="/TierraMedia/index.jsp"> <img src="img/GAMGEE-White.png"
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
				<ul class="navbar-nav">
					<li class="nav-item"><a style="font-family:Estonia; font-size:56px; text-align:center"
						class="nav-link" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<c:out value="${user.getNombre()}"></c:out>
					</a>
						<ul class="dropdown-menu bg-verde dropdown-menu-end"
							aria-labelledby="navbarDropdown" style=" border-radius: 15%">
							<li><a class="dropdown-item disabled" style="color: black;">
									<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
									<c:out value="${user.getPresupuesto()}"></c:out>
							</a></li>
							<li><a class="dropdown-item disabled" style="color: black;">
									<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
									<c:out value="${user.getTiempoDisponible()}h"></c:out>
							</a></li>
							<li><hr class="dropdown-divider"></li>
							<li ><a href="/TierraMedia/logout" style="border-radius: 31%" class="dropdown-item">Salir</a></li>
						</ul></li>
				</ul>
				<br>
				<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">
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
					src="img/GAMGEE-Verde.png">
			</div>
		</div>
	</div>
</nav>