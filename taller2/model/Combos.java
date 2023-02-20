package model;

import java.util.ArrayList;

public class Combos implements Producto{
	
	private double descuento ;
	private String nombre;
	private int preciototal;
	private ArrayList<Producto> listaCombos;
	private String facturaproducto;
	
	public Combos(String nombre,double des) {
		this.nombre = nombre;
		des = descuento;
		this.listaCombos = new ArrayList<Producto>();
		generarTextoFactura();
		
		
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	
	
	public void agregarIteamACombo(Producto itemCombo) {
		int precio = itemCombo.getPrecio();
		
		preciototal = preciototal + precio;
		
		
		listaCombos.add(itemCombo);
		
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return preciototal;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		this.facturaproducto = "con " + nombre ;
		return facturaproducto;
	}
	
	

}
