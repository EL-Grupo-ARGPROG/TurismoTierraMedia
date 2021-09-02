//Para cada usuario, el sistema:
//Sugerir� una atracci�n que coincida con sus preferencias, costos y tiempos.

//Deber� priorizarse la oferta de promociones, las atracciones m�s caras y que requieran mayor tiempo, en ese orden.

//No deber� ofertarse una atracci�n o promoci�n que no pueda costearse o para la cual no tenga tiempo disponible.
//Tampoco deber� ofertarse una atracci�n que ya haya sido incluida en una promoci�n anteriormente comprada por el mismo usuario.
//Una vez agotadas las ofertas que coincidan con sus intereses, se ofertar�n aquellas que no coincidan, bajo el mismo criterio.
//Si el usuario acepta, se guardar� dentro de su sugerencia.
//Una atracci�n o promoci�n aceptada no podr� cancelarse.
//Se repetir� el proceso hasta que no quede tiempo disponible, monedas, o cupo para el itinerario, conforme las ofertas restantes.
//Se mostrar� un resumen de todo su itinerario, contabilizando las horas necesarias para realizarlo y las monedas que deber� gastar.
//Se repetir� para el siguiente usuario.
//La interacci�n se realizar� por medio de la l�nea de comandos.

package tierraMedia;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Vendible> vendibles;
	private Usuario[] visitantes;
	// private Atracciones[] atracciones;

	// private Vendible getPromocionMasCara() {
	// int costoMayor = 0;
	// Vendible promocionMasCara = null;
	//
	// for (Vendible vendible : this.vendibles) {
	// costoMayor = Math.max(costoMayor, vendible.getCosto());
	// }
	// for(Vendible vendible : this.vendibles) {
	// if(vendible.getCosto() == costoMayor) {
	// promocionMasCara = vendible;
	// }
	// }
	// return promocionMasCara;
	// }
	//
	// private Vendible getPromoConMayorTiempoNecesario() {
	// int mayorTiempoRequerido = 0;
	// Vendible promocionMasTardosa = null;
	//
	// for (Vendible vendible : this.vendibles) {
	// mayorTiempoRequerido = Math.max(mayorTiempoRequerido,
	// vendible.getTiempoNecesario());
	// }
	// for(Vendible vendible : this.vendibles) {
	// if(vendible.getCosto() == mayorTiempoRequerido) {
	// promocionMasTardosa = vendible;
	// }
	// }
	// return promocionMasTardosa;
	// }

	public void sugerirPromocion() {
		for (Usuario visitante : this.visitantes) {

		}
	}

	public static void main(String[] args) {
		System.out.println("Hola Mundo");
	}

}
