package model;

public class Ingrediente implements Producto{
	
	private String nombre;
	private int costoAdicional;
	
	
	public Ingrediente(String nom, int costoA) {
		this.nombre = nom;
		this.costoAdicional = costoA;
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	public int getCostoAdicional() {
		return costoAdicional;
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return costoAdicional;
	}
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return "con" + nombre;
	}
	

	
	

}
