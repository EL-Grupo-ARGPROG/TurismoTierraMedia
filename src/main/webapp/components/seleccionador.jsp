<div
	class="container navbar border-round shadow bg-obscure justify-content-center">
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
			<option class="text-center text-dark">1 - 99</option>
			<option class="text-center text-dark">100 - 299</option>
			<option class="text-center text-dark">300 - 600</option>

		</select> <select name="duracion" class="form-select shadow center-element "
			aria-label="Default select example">
			<option class="text-center text-dark" selected>Duracion Hs</option>
			<option class="text-center text-dark">1 - 3</option>
			<option class="text-center text-dark">4 - 6</option>
			<option class="text-center text-dark">6 - 10</option>
		</select> <input type="submit" name="todos" value="TODOS"
			class="btn boton-filtro shadow btn-success bg-verde-light">

		<button class="btn boton-filtro shadow btn-success bg-verde-light"
			type="submit">
			<b><i class="bi bi-search"></i></b>
		</button>

	</form>
</div>