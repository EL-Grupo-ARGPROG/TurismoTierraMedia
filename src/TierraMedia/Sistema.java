//Para cada usuario, el sistema:
//Sugerirá una atracción que coincida con sus preferencias, costos y tiempos.

//Deberá priorizarse la oferta de promociones, las atracciones más caras y que requieran mayor tiempo, en ese orden.

//No deberá ofertarse una atracción o promoción que no pueda costearse o para la cual no tenga tiempo disponible.
//Tampoco deberá ofertarse una atracción que ya haya sido incluida en una promoción anteriormente comprada por el mismo usuario.
//Una vez agotadas las ofertas que coincidan con sus intereses, se ofertarán aquellas que no coincidan, bajo el mismo criterio.
//Si el usuario acepta, se guardará dentro de su sugerencia.
//Una atracción o promoción aceptada no podrá cancelarse.
//Se repetirá el proceso hasta que no quede tiempo disponible, monedas, o cupo para el itinerario, conforme las ofertas restantes.
//Se mostrará un resumen de todo su itinerario, contabilizando las horas necesarias para realizarlo y las monedas que deberá gastar.
//Se repetirá para el siguiente usuario.
//La interacción se realizará por medio de la línea de comandos.

package tierraMedia;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Vendible> vendibles;
	private Usuario[] visitantes;
	//private Atracciones[] atracciones;

//	private Vendible getPromocionMasCara() {
//		int costoMayor = 0;
//		Vendible promocionMasCara = null;
//		
//		for (Vendible vendible : this.vendibles) {
//			costoMayor = Math.max(costoMayor, vendible.getCosto());
//		}
//		for(Vendible vendible : this.vendibles) {
//			if(vendible.getCosto() == costoMayor) {
//				promocionMasCara = vendible;
//			}
//		}
//		return promocionMasCara;
//	}
//	
//	private Vendible getPromoConMayorTiempoNecesario() {
//		int mayorTiempoRequerido = 0;
//		Vendible promocionMasTardosa = null;
//		
//		for (Vendible vendible : this.vendibles) {
//			mayorTiempoRequerido = Math.max(mayorTiempoRequerido, vendible.getTiempoNecesario());
//		}
//		for(Vendible vendible : this.vendibles) {
//			if(vendible.getCosto() == mayorTiempoRequerido) {
//				promocionMasTardosa = vendible;
//			}
//		}
//		return promocionMasTardosa;
//	}

	public void sugerirPromocion() {
		for (Usuario visitante : this.visitantes) {
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hola Mundo");
	}

}
