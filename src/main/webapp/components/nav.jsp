<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="css/index.css" rel="stylesheet" />

<nav class="shadow navbar navbar-dark bg-obscure">
	<div class="container-fluid">
		<a class="navbar-brand" href="/TierraMedia/index.jsp"> <img
			src="img/GAMGEE-White.png" width="60" height="50"
			class="d-inline-block align-text-bottom"> GAMGEE TOURISM AGENCY
		</a>
		<button class="btn shadow" type="button" data-bs-toggle="offcanvas"
			data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
			<i class="bi bi-list" style="font-size: 2rem; color: white"></i>
		</button>
		<div class="offcanvas offcanvas-end bg-verde-dark" tabindex="-1"
			id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
			<div class="offcanvas-header">
				<h3 class="offcanvas-title" id="offcanvasNavbarLabel">Bienvenido!</h3>
				<button type="button" class="btn-close btn-close-white"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<ul class="navbar-nav">
					<li class="nav-item"><a
						style="font-family: Estonia; font-size: 56px; text-align: center"
						class="nav-link" href="#" id="navbarDropdown" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <c:out
								value="${user.getNombre()}"></c:out> <c:if
								test="${user == null }">
								<a class="btn bg-verde-light ml-2 btn-sucess"
									href="/TierraMedia/login.jsp"> Iniciar sesion</a></a> </c:if>
						<ul
							class="dropdown-menu bg-verde-dark text-white dropdown-menu-end"
							aria-labelledby="navbarDropdown">

							<li><a class="dropdown-item text-light text-center"> <i
									title="monedas" style="color: white;" class="bi bi-coin"></i> <c:out
										value="${user.getPresupuesto()}"></c:out>
							</a></li>
							<li><a class="dropdown-item text-light text-center"> <i
									title="tiempo" style="color: white;" class="bi bi-clock-fill"></i>
									<c:out value="${user.getTiempoDisponible()}h"></c:out>
							</a></li>
							<div class="nav navbuttons flex-column py-2 justify-content-top">
								<a class="btn mt-1 mb-1 bg-verde-light btn-success"
									href="/TierraMedia/perfil-datos.jsp">Perfil</a>
								<c:if test="${user.isAdmin()}">
									<a class="btn mt-1 mb-1 bg-verde-light btn-success"
										href="/TierraMedia/atraccion-admin.jsp">Administrar</a>
								</c:if>

								<a class="btn mt-1 border-0 bg-verde-light btn-danger"
									href="/TierraMedia/logout">Cerrar session</a>
							</div>
						</ul></li>
				</ul>
				<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">
							<h5>Inicio</h5>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">
							<h5>Contacto</h5>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/TierraMedia/seleccionar.do?tipo=Tipo+de+Paquete&precio=Rango+de+Precio&duracion=Duracion+Hs&todos=TODOS">
							<h5>Paquetes turisticos</h5>
					</a></li>
				</ul>
				<img id="logo-offcanvas" class="float-end"
					src="img/GAMGEE-Verde.png">
			</div>
		</div>
	</div>
</nav>