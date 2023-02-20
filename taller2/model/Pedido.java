package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
	
	private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private Map<Integer ,Pedido> mapapedido;
	private Map<String,Integer> mapaproductos;
	private List<Producto> listaproductos;
	
	private String factura;
	
	
	
	public Pedido(String nombre, String direccion) {
		this.nombreCliente = nombre;
		this.direccionCliente = direccion;
		this.idPedido = (int) Math.random();
		this.mapapedido = new HashMap<Integer,Pedido>();
		this.mapaproductos = new HashMap<String,Integer>();
		this.listaproductos = new ArrayList<Producto>();
		
		numeroPedidos++;
	}
	
	
	public int getIdPedido () {
		return idPedido;
	}
	public void agregarProducto(Producto nuevoItem) {
		String nombre = nuevoItem.getNombre();
		Integer precio = nuevoItem.getPrecio();
		mapaproductos.put(nombre, precio);
		listaproductos.add(nuevoItem);
		
		
	}
	public String guardarFactura() {
		String nuevaFactura = "";
		
		for (int i= 0;i<listaproductos.size();i++) {
			Producto prod = listaproductos.get(i);
			String nombre = prod.getNombre();
			generarTextoFactura(nombre);
			
		}
		
		return nuevaFactura;
		
		
		
		
	}
	
	private String generarTextoFactura(String facturaproducto) {
		
		return this.factura = factura + facturaproducto;
		
	}
	
	

}
