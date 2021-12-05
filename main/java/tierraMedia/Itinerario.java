package tierraMedia;

public class Itinerario {
	int id;
	int id_usuario;
	Vendible atraccion;
	Vendible promocion;
	
	public Itinerario(int id_usuario, Vendible atraccion, Vendible promocion) {
		this.id_usuario = id_usuario;
		this.atraccion = atraccion;
		this.promocion = promocion;
	}
	
	public Itinerario(int id, int id_usuario, Vendible atraccion, Vendible promocion) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.atraccion = atraccion;
		this.promocion = promocion;
	}
	
	
	public int getId() {
		return id;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Vendible getAtraccion() {
		return atraccion;
	}
	public void setAtraccion(Atracciones atraccion) {
		this.atraccion = atraccion;
	}
	
	public Vendible getPromocion() {
		return promocion;
	}
	public void setPromocion(Promociones promocion) {
		this.promocion = promocion;
	}

}
