package modelo;

public class Producto {
	
	private Integer id;
	private String nombre;
	private Integer cantidad;
	private Boolean disponible;
	
	public Producto(){}
	
	public Producto(Integer id, String nombre, Integer cantidad){
		this.id=id;
		this.nombre=nombre;
		this.cantidad=cantidad;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d ;nombre: %s; cantidad: %d", id, nombre, cantidad);
	}
}
