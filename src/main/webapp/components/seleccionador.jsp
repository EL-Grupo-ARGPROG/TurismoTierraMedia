<div
	class="container navbar sticky-top border-round shadow bg-obscure justify-content-center">
	<form action="seleccionar" method="get"
		class="container row justify-content-center">

		<select name="tipo" class="form-select shadow center-element "
			aria-label="Default select example">
			<option class="text-center text-dark" selected>Tipo de
				Paquete</option>
			<option class="text-center text-dark">AVENTURA</option>
			<option class="text-center text-dark">DEGUSTACION</option>
			<option class="text-center text-dark">PAISAJE</option>

		</select> <select name="precio" class="form-select shadow center-element "
			aria-label="Default select example">
			<option class="text-center text-dark" selected>Rango de
				Precio</option>
			<option class="text-center text-dark">1 - 200</option>
			<option class="text-center text-dark">200 - 400</option>
			<option class="text-center text-dark">400 - 600</option>
			<option class="text-center text-dark">600 - 800</option>
			<option class="text-center text-dark">800 - 1000</option>

		</select> <select name="duracion" class="form-select shadow center-element "
			aria-label="Default select example">
			<option class="text-center text-dark" selected>Duracion Hs</option>
			<option class="text-center text-dark">1 - 2</option>
			<option class="text-center text-dark">3 - 5</option>
			<option class="text-center text-dark">6 - 10</option>
		</select>
		<button class="btn boton-filtro shadow btn-success bg-verde-light"
			type="submit">
			<b><i class="bi bi-search"></i></b>
		</button>
	</form>
</div>