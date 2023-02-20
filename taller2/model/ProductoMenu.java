package model;

public class ProductoMenu implements Producto {
	
	
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String nom,int precioB) {
		
		this.nombre = nom;
		this.precioBase = precioB;
		
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public int getPrecio() {
		return precioBase;
	}
	@Override
	public String generarTextoFactura() {
		return "con" + nombre;
	}

}
