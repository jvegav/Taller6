package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Combos implements Producto{
	
	private String descuento ;
	private String nombre;
	private int preciototal;
	private HashMap<String,ProductoAjustado> mapaCombos;
	private String facturaproducto;
	
	public Combos(String nombre,String des) {
		this.nombre = nombre;
		des = descuento;
		this.mapaCombos = new HashMap<String,ProductoAjustado>();
		generarTextoFactura();
	}
	@Override
	public String getNombre() {
		return nombre;
	}
	
	
	public void agregarIteamACombo(ProductoAjustado itemCombo) {
		int precio = itemCombo.getPrecio();
		String nombre = itemCombo.getNombre();
		
		preciototal = preciototal + precio;
		
		mapaCombos.put(nombre,itemCombo);
		
	}
	
	
	public ProductoAjustado getItemCombo(String nombreprod) {
		return mapaCombos.get(nombreprod);
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
