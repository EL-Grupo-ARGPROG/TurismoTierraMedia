package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Atracciones implements Vendible {

	protected String nombre;
	protected double costo;
	protected double tiempoNecesario;
	protected int cupo;
	protected TiposAtracciones tipo;
	
	private Map<String, String> errors;

	public Atracciones(String nombre, double costo, double tiempoNecesario, int cupo, TiposAtracciones tipo) {
		this.costo = costo;
		this.tiempoNecesario = tiempoNecesario;
		this.cupo = cupo;
		this.tipo = tipo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {

		return  "\nAtraccion: " + this.getNombre() + "\n" + 
	            "Costo: " + this.getCosto() + "$" + "\n"+ 
				"Tiempo de excursion " + this.getTiempoNecesario() + "H"+"\n";
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempoNecesario() {
		return tiempoNecesario;
	}

	@Override
	public int getCupo() {
		return cupo;
	}

	public void restarCupo() {
		this.cupo--;
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public boolean hayCupo() {
		if (this.cupo <= 0)
			return false;
		else
			return true;
	}

	public String mostrarOfertaDescriptiva() {
		return  "\nAtraccion: " + this.getNombre() + "\n" + 
                "Costo: " + this.getCosto() + "$" + "\n"+ 
                "Tiempo de excursion " + this.getTiempoNecesario() + "H"+"\n";
	}

	@Override
	public TiposAtracciones getTipo() {
		return this.tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombre, tiempoNecesario, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atracciones other = (Atracciones) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo) && cupo == other.cupo
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoNecesario) == Double.doubleToLongBits(other.tiempoNecesario)
				&& tipo == other.tipo;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (this.costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (this.tiempoNecesario <= 0) {
			errors.put("duracion", "Debe ser positivo");
		}
		if (this.cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	@Override
	public void serVendido() {
		this.cupo -= 1;
		
	}

}
