<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid text-center bg-verde">

<div class="modal-body">
	<div class="form g-4 mb-2">
		<label for="nombre" class=col-form-label>Nombre:</label> <br> <input
			name="nombre" type="text" class="form" required disabled value="${atraccion.getNombre()}"/>
	</div>
	<div class="container text-center">
	<div class="form g-3 mb-2">
		<label for="costo"
			class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<br> <input name="costo" type="number" class="form" required value="${atraccion.getCosto()}"/>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("costo")}'></c:out>
		</div>
	</div>
	<div class="form g-3 mb-2">
		<label for="tiempoNecesario"
			class='col-form-label ${atraccion.errors.get("duracion") != null ? "is-invalid" : "" }'>Tiempo
			Necesario: </label> <br> <input name="tiempoNecesario" type="number"
			class="form" required value="${atraccion.getTiempoNecesario()}" />
			<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("duracion")}'></c:out>
		</div>
	</div>
	<div class="form g-3 mb-2">
		<label for="cupo"
			class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<br> <input name="cupo" type="number" class="form" required value="${atraccion.getCupo()}" />
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="form g-3 mb-2 text-center" style="justify-content:center;">
		<label>Tipo</label> <select name="tipo"
			class="form-select shadow center-element "
			aria-label="Default select example">
			<option class="text-center text-dark" selected>Tipo</option>
			<option class="text-center text-dark">AVENTURA</option>
			<option class="text-center text-dark">DEGUSTACION</option>
			<option class="text-center text-dark">PAISAJE</option>
		</select>
	</div>
	</div>
	
	<div class="modal-footer">
		<button type="submit" class="btn btn-success bg-verde-dark">Send
			message</button>
	</div>
</div>
</div>