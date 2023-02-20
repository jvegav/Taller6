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

public class Restaurante {
	
	
	ArrayList<ProductoMenu> listaMenu ;
	ArrayList<Ingrediente> listaIngr ;
	ArrayList<Combos> listaCombos ;
	Map<String,Integer> mapaIngr;
	Map<String,Integer> mapaMenu;
	Map<String,Combos> mapaCombos;
	Stack<Pedido> pilaPedidos;
	
	
	
	public Restaurante() {
		this.listaMenu = new ArrayList<ProductoMenu>();
		this.listaIngr = new ArrayList<Ingrediente>();
		this.listaCombos = new ArrayList<Combos>();
		this.mapaIngr = new HashMap<String,Integer>();
		this.mapaCombos = new HashMap<String,Combos>();
		this.mapaMenu = new HashMap<String,Integer>();
		File archivoIngredientes = new File("ingredientes.txt");
		File archivoCombos = new File("combos.txt");
		File archivoMenu = new File("menu.txt");
		
		try {
			cargarInformacionRestaurante(archivoIngredientes,archivoMenu,archivoCombos);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	
	public  void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws NumberFormatException, IOException {
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private void cargarIngredientes(File archivoIngredientes)  {
		
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
				
				mapaIngr.put(ingrediente, precio);
				listaIngr.add(ingr);
				
				}	
			
			
		} catch(Exception e){
			System.out.println("Error " + e.getMessage());
			
		}
		
		
		
		
	}
	private void cargarMenu(File archivoMenu) {
		
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
				
				ProductoMenu menu = new ProductoMenu(nombreproducto,precio);
				
				listaMenu.add(menu);
				mapaMenu.put(nombreproducto, precio);
				
				}	

			
		} catch(Exception e){
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
				descuentoenporcentaje = descuentoenporcentaje.replace("%", "");
				
				
				Double descuento = Double.parseDouble(descuentoenporcentaje);
				descuento = descuento /100;
				Combos comb = new Combos(nombreCombo,descuento);
				
				for (int i =2; i< list.size(); i++ ) {
					String producto = list.get(i);
					
					Integer precioproducto = (int)((mapaMenu.get(producto) * descuento) + mapaMenu.get(producto)); 
					ProductoMenu prod = new ProductoMenu(producto,precioproducto);
					
					
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
	
	

}
