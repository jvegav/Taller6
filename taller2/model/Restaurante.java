package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Exceptions.IngredienteRepetidoException;
import Exceptions.ProductoRepetidoException;

public class Restaurante {
	
	
	private ArrayList<ProductoMenu> listaMenu ;
	private ArrayList<Ingrediente> listaIngr ;
	private ArrayList<Combos> listaCombos ;
	private ArrayList<ProductoMenu> listaBebidas ;
	private Map<String,Integer> mapaIngr;
	private Map<String,Integer> mapaMenu;
	private Map<String,Combos> mapaCombos;
	private Map<String,Integer> mapaBebidas;
	private Stack<Pedido> pilaPedidos;
	
	
	
	public Restaurante() {
		this.listaMenu = new ArrayList<ProductoMenu>();
		this.listaIngr = new ArrayList<Ingrediente>();
		this.listaCombos = new ArrayList<Combos>();
		this.listaBebidas = new ArrayList<ProductoMenu>();
		this.mapaIngr = new HashMap<String,Integer>();
		this.mapaCombos = new HashMap<String,Combos>();
		this.mapaMenu = new HashMap<String,Integer>();
		this.mapaBebidas = new HashMap<String,Integer>();
		String[] pathNames = { "taller2", "data", "ingredientes.txt" };
        String pathIngredientes = String.join(File.separator, pathNames);
        File archivoIngredientes = new File(pathIngredientes);
        
        String[] pathNomCombo = { "taller2", "data", "combos.txt" };
        String pathCombo = String.join(File.separator, pathNomCombo);
        File archivoCombos = new File(pathCombo);
        
        String[] pathNomMenu = { "taller2", "data", "menu.txt" };
        String pathMenu = String.join(File.separator, pathNomMenu);
        File archivoMenu = new File(pathMenu);
        
        String[] pathNomBebidas = { "taller2", "data", "bebidas.txt" };
        String pathBebidas= String.join(File.separator, pathNomBebidas);
        File archivoBebidas= new File(pathBebidas);
		
		
		
		try {
			cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombos, archivoBebidas);
		} catch (ProductoRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IngredienteRepetidoException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	

	public ArrayList<ProductoMenu> getMenuBase(){
		return listaMenu;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return listaIngr;
		
	}
	
	public ArrayList<Combos> getCombos(){
		return listaCombos;
	}
	
	
	public  void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebidas)  throws IngredienteRepetidoException, ProductoRepetidoException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarBebidas(archivoBebidas);
		cargarCombos(archivoCombos);
	}
	
	
	
	
	
	
	
	private void cargarIngredientes(File archivoIngredientes)  throws IngredienteRepetidoException{
		
		FileReader archivo;
		BufferedReader lector;
		try {
			String ruta = archivoIngredientes.getPath();
			
			archivo = new FileReader(ruta);
			lector = new BufferedReader(archivo);
			String linea;
			
			
			
			while((linea = lector.readLine()) != null) {
				List<String> list = Arrays.asList(linea.split(";"));
				String ingrediente = list.get(0);
				
				int precio = Integer.parseInt(list.get(1));
				
				
				Ingrediente ingr = new Ingrediente(ingrediente,precio);
				
				if(mapaIngr.containsKey(ingrediente)) {
					throw new IngredienteRepetidoException(ingrediente);
				}
				else {
					mapaIngr.put(ingrediente, precio);
					listaIngr.add(ingr);
					
				}
				
				
				
				}
			
			
			
			
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
			
			
		}
		
		
		
		
	}
	private void cargarMenu(File archivoMenu) throws ProductoRepetidoException {
		
		FileReader archivo;
		BufferedReader lector;
		
		try {
			String ruta = archivoMenu.getPath();
			
			archivo = new FileReader(ruta);
			lector = new BufferedReader(archivo);
			String linea;
			while((linea = lector.readLine()) != null) {
				List<String> list = Arrays.asList(linea.split(";"));
				String nombreproducto = list.get(0);
				int precio = Integer.parseInt(list.get(1));
				
				if(mapaMenu.containsKey(nombreproducto)) {
					throw new ProductoRepetidoException(nombreproducto);
				}
				else {
					ProductoMenu menu = new ProductoMenu(nombreproducto,precio);
					
					listaMenu.add(menu);
					mapaMenu.put(nombreproducto, precio);
					
				}
				
				
				
				}	
		}
		catch(Exception e){
			System.out.println("Error " + e.getMessage());
		}
	}
	
	
private void cargarBebidas(File archivoBebidas) {
		
		FileReader archivo;
		BufferedReader lector;
		
		try {
			String ruta = archivoBebidas.getPath();
			
			archivo = new FileReader(ruta);
			lector = new BufferedReader(archivo);
			String linea;
			while((linea = lector.readLine()) != null) {
				List<String> list = Arrays.asList(linea.split(";"));
				String nombreproducto = list.get(0);
				int precio = Integer.parseInt(list.get(1));
				
				ProductoMenu bebida = new ProductoMenu(nombreproducto,precio);
				
				
				
				listaBebidas.add(bebida);
				mapaBebidas.put(nombreproducto, precio);
				
				}	
		}
		catch(Exception e){
			System.out.println("Error " + e.getMessage());
		}
	}


	private void cargarCombos(File archivoCombos) {
		
		FileReader archivo;
		BufferedReader lector;
		
		try {
			String ruta = archivoCombos.getPath();
			
			archivo = new FileReader(ruta);
			lector = new BufferedReader(archivo);
			String linea;
			while((linea = lector.readLine()) != null){
				
				List<String> list = Arrays.asList(linea.split(";"));
				
				
				String nombreCombo = list.get(0);
				String descuentoenporcentaje = list.get(1);
				
				Combos comb = new Combos(nombreCombo,descuentoenporcentaje);
				
				
				for (int i =2; i< list.size(); i++ ) {
					String producto = list.get(i);
					Integer precioProducto;
					if(mapaBebidas.containsKey(producto) == false) {
						precioProducto = mapaMenu.get(producto) ; 
					}
					else {
						precioProducto = mapaBebidas.get(producto); 
					}
					ProductoAjustado prod = new ProductoAjustado(producto,precioProducto,descuentoenporcentaje);
					comb.agregarIteamACombo(prod);
				}
				
				
				mapaCombos.put(nombreCombo, comb);
				listaCombos.add(comb);
				}
			
			
		} catch(Exception e){
			System.out.println("Error " + e.getMessage());
			
			
			
		}
		
		
	
		
		
			
		
		
		
	}
	
	public void iniciarPedido(String nombreCliente,String direccionCliente) {
		
		Pedido nuevopedido = new Pedido(nombreCliente,direccionCliente);
		this.pilaPedidos = new Stack<Pedido>();
		pilaPedidos.add(nuevopedido);
		
	}
	public Pedido getPedidoEnCurso() {
		
		Pedido ultimopedido = pilaPedidos.peek();
		
		return ultimopedido;
		
	}
	
	
	public String cerraryGuardarPedido(Pedido ped) {
		
		String factura = ped.guardarFactura();
		return factura;
		
	}
	public ArrayList<String> getListaProductosPedido(Pedido ped){
		List<Producto> listaOriginal = ped.getListaProductos();
		ArrayList<String> listaNueva =new ArrayList<String>();
		
		
		for(Producto prod: listaOriginal) {
			String nombre = prod.getNombre();
			listaNueva.add(nombre);	
		}
		
		return listaNueva;
			
	}
	
	public void quitarProductoPedido(int indice) {
		Pedido ped = getPedidoEnCurso();
		ped.quitarProductoPedido(indice);
	
	}
	

}
