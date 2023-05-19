package model;

import java.io.File;
import Exceptions.CostoPedidoException;
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
	private int costoPedido;
	
	
	
	public Pedido(String nombre, String direccion) {
		this.nombreCliente = nombre;
		this.direccionCliente = direccion;
				
		this.idPedido = (int) Math.random()*1000;
		this.mapapedido = new HashMap<Integer,Pedido>();
		this.mapaproductos = new HashMap<String,Integer>();
		this.listaproductos = new ArrayList<Producto>();
		this.costoPedido = 0;
		this.factura="";
		
		numeroPedidos++;
	}
	
	
	public int getIdPedido () {
		return idPedido;
	}
	public int getCostopedido() {
		return costoPedido;
	}
	public void agregarProducto(Producto nuevoItem) throws Exception{
		String nombre = nuevoItem.getNombre();
		Integer precio = nuevoItem.getPrecio();
		
		
		if(costoPedido+precio > 150000) {
			throw new CostoPedidoException(nombre,costoPedido);
		}
		else {
			costoPedido +=precio;
			mapaproductos.put(nombre, precio);
			listaproductos.add(nuevoItem);	
		}
		
		
		
	}
	
	
	public List<Producto> getListaProductos(){
		return listaproductos;
	}
	public String guardarFactura() {
		
		for (int i= 0;i<listaproductos.size();i++) {
			
			Producto prod = listaproductos.get(i);
			String nombre = prod.getNombre();
			
			generarTextoFactura(nombre);
			
			
		}
		
		return factura;
		
		
		
		
	}
	
	private String generarTextoFactura(String facturaproducto) {
		
		return this.factura = factura + facturaproducto;
		
	}
	
	
	
	public void quitarProductoPedido(int indice) {
		listaproductos.remove(indice);
		
	}
	
	

}
