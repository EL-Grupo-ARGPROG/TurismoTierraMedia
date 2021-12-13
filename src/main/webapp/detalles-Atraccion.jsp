<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="persistence.impl.PromocionesDAOImpl,model.Sistema"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<<<<<<< HEAD
<meta name="viewport"
	content="width=device-width, height=device-height initial-scale=1.0" />
=======
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
>>>>>>> 95e2a8b1f6125ec296a45f135134f52e648b4093
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

<body class="flex-column h-100 w-100 bg-verde-light">

  	<jsp:include page="components/nav.jsp"></jsp:include>
  

  <div class="container-fluid py-0 px-0">
    <div id="banner" class="card bg-dark mb-5 text-white">
      <img src="img/La-Comarca.jpg" class="card-img  atraccion " alt="...">
      <div class="d-flex bg-gris carousel-caption text-start d-none d-sm-block">
        <h1 class="card-title">${vendible.getNombre() }</h1>
          <p class="">This is a wider card with supporting text below as a natural lead-in to additional
            content.
            This content is a little bit longer.</p>
          <div class="container card-body">
            <div class="row">
              <div class="text-left col-xs-12 col-md-4">
                <h6>Alojamiento incluido</h6>
              </div>
              <div class="text-derecha col-xs-12 col-md-8">
               <h5 class="btn border text-white"> Precio: ${vendible.getCosto()}</h5>
               <form action="comprar.do">
               <input type=hidden name="nombre" value="${vendible.getNombre()}">
               <input type=hidden name="esPromo" value="${vendible.esPromocion()}">
               <h5 class="btn btn-success"> COMPRAR</h5>
               </form>
              </div>
            </div>
          </div>
      </div>
    </div>
    
    <div class="container bg-verde py-5 px-5 text-color-light">
      <h4>Salidas Enero = 03 - 12 - 18 -  21 -  24 - 28</h4>
      <p>Programa Full 4 días / 3 noches.<br>
      Aéreos directos.<br>
      Equipaje de mano = incluído.<br>
      Equipaje de bodega = incluído (01 valija 15 kg).<br>
      Traslados in / out en chárter privado.<br>
      Hotelería exclusiva.<br>
      Media Pensión: Desayuno + Cena.</p>
      <h5>Excursiones</h5>
      <p>- Cataratas Argentinas / incluye los 3 circuitos + trencito a la Garganta del Diablo.<br>
      - La ARIPUCA.<br>
      - Minas de piedras semi preciosas Wanda.<br>
      - Paseo en Catamarán por el Río & Selva</p>
      No incluye entradas.
      <h5>Nuestra Hotelería</h5>
      <p>► Nuevo LA FAMILIA Hotel | PISCINA (lado argentino)</p>
      <h5>ITINERARIO DE ACTIVIDADES</h5>
      <p>Día 1: Partida en horas del mediodía / Llegada a destino / Traslado privado al Hotel / Check In / Excursión a la ARIPUCA / Cena <br>
      Día 2: Excursión a CATARATAS Argentinas / Cena <br>
      Día 3: Excursión a Minas de Wanda / Paseo en Catamarán por el Río & Selva / Cena<br>
      Día 4: check out / tiempo libre para compras / traslado privado al Aeropuerto / regreso en horas de la tarde / Llegada a origen y fin de los servicios.</p>
      La empresa se reserva el derecho de alterar y / o modificar itinerarios y excursiones contratados ante cuestiones de diagramación y/o causas de fuerza mayor y / o caso fortuito que impidan el normal cumplimiento del mismo: corte de rutas x nevadas, huracanes, inundaciones, reprogramación de eventos y / o cualquier otro factor que pueda significar un riesgo o una falta de servicio para el pasajero.
      
    </div>
  </div>

 	<jsp:include page="components/footer.jsp"></jsp:include>


</body>

</html>