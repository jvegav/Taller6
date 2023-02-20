package console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Combos;
import model.Ingrediente;
import model.Pedido;
import model.ProductoMenu;
import model.Restaurante;

public class Aplicacion {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		System.out.println("BIENVENIDOS A COMIDAS RAPIDAS DPOO :)");
		Restaurante restaurante = new Restaurante();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese su nombre: ");
		
		String nombreCliente = entrada.next();
		
		System.out.println("Ingrese su direccion: ");
		String direccionCliente = entrada.next();
		
		restaurante.iniciarPedido(nombreCliente, direccionCliente);
		System.out.println("PEDIDO");
		
		System.out.println("¿Desea agregar un combo a su pedido ?");
		System.out.println("1. Si");
		System.out.println("2. No");
		Scanner entrada2 = new Scanner(System.in);
		Integer opcionCombo = entrada2.nextInt();
		
		
		if(opcionCombo == 1) {
			mostrarMenuCombos();
			
			while(opcionCombo ==1) {
				System.out.println("Seleccione el numero de el combo: ");
				int opcionunCombo = entrada2.nextInt();
				ejecutarOpcionCombo(opcionunCombo,restaurante);
				System.out.println("Se agrego su combo al pedido");
				System.out.println("¿Desea agregar otro combo al pedido ?");
				System.out.println("1. Si");
				System.out.println("2. No");
				Integer opcionotrocombo = entrada2.nextInt();
				if (opcionotrocombo != 1) {
					opcionCombo = 0;
				}	
			}	
		}
		
		
		
		
		
		
		System.out.println("¿Desea agregar un producto del menu ?");
		System.out.println("1. Si");
		System.out.println("2. No");
		Integer opcionMenu = entrada2.nextInt();
		
		
		if(opcionMenu == 1) {
			System.out.println("PRODUCTOS MENU:");
			ArrayList<ProductoMenu> listaMenu = restaurante.getMenuBase();
			for(int i =0 ; i<listaMenu.size() ; i++) {
				
				String nombre = listaMenu.get(i).getNombre();
				int precio  = listaMenu.get(i).getPrecio();
				System.out.println( i + ". " + nombre +"--"+precio );
			}
			
			while(opcionMenu ==1) {
				System.out.println("Seleccione el producto: ");
				int opcionProductoMenu = entrada2.nextInt();
				ejecutarOpcionMenu(opcionProductoMenu,restaurante);
				System.out.println("Se agrego su producto al pedido");
				System.out.println("¿Desea agregar otro producto del menu ?");
				System.out.println("1. Si");
				System.out.println("2. No");
				Integer opcionotroproducto = entrada2.nextInt();
				if (opcionotroproducto != 1) {
					opcionMenu = 0;
				}	
			}	
		}
		
			
			
		
		
		
		System.out.println("¿Desea algun ingrediente adicional ?");
		System.out.println("1. Si");
		System.out.println("2. No");
		Integer opcionIngredienteAdicional = entrada2.nextInt();
		if(opcionIngredienteAdicional == 1) {
			System.out.println("INGREDIENTES ADICIONALES: ");
			ArrayList<Ingrediente> listaIngrediente = restaurante.getIngredientes();
			for(int i =0 ; i<listaIngrediente.size() ; i++) {
				
				
				String nombre = listaIngrediente.get(i).getNombre();
				int precio  = listaIngrediente.get(i).getCostoAdicional();
				System.out.println( i + ". " + nombre +"--"+precio );
			}
			
			while(opcionIngredienteAdicional ==1) {
				System.out.println("Seleccione el ingrediente a adicionar: ");
				int opcionIngrediente = entrada2.nextInt();
				ejecutarOpcionIngrediente(opcionIngrediente,restaurante);
				System.out.println("Se agrego su ingrediente al pedido");
				System.out.println("sDesea agregar otro ingrediente al menu ?");
				System.out.println("1. Si");
				System.out.println("2. No");
				Integer opcionotroingrediente = entrada2.nextInt();
				if (opcionotroingrediente != 1) {
					opcionIngredienteAdicional = 0;
				}	
			}	
		}
		
		entrada.close();
		
		
		
		String factura = restaurante.cerraryGuardarPedido(restaurante.getPedidoEnCurso());
		
		System.out.println(factura);
		
		
		System.out.println("Su pedido fue cargado con exito por favor espere a que sea entregado en la direccion que ingreso....");
		System.out.println("HASTA LUEGO :)");
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
	
	}
	
	
	public static void mostrarMenuCombos() {
		Restaurante restaurante = new Restaurante();
		System.out.println("La siguiente es la carta de nuestros combos: ");
		ArrayList<Combos> listacombos = restaurante.getCombos();
		for(int i =0 ; i<listacombos.size() ; i++) {
			String nombre = listacombos.get(i).getNombre();
			int precio  = listacombos.get(i).getPrecio();
			System.out.println( i + ". " + nombre +"--"+precio );
		}
		System.out.println( listacombos.size() + "No desea agregar un combo.. " );
	}
	
	
	public static void ejecutarOpcionCombo(int opcionSelecccionada,Restaurante rest)  {
		ArrayList<Combos> listacombos = rest.getCombos();
		
		
		Combos comb = listacombos.get(opcionSelecccionada);
		Pedido pedidoencurso = rest.getPedidoEnCurso();
		
		pedidoencurso.agregarProducto(comb);
	}
	
	
	
	
	public static void ejecutarOpcionMenu(int opcionseleccionada,Restaurante rest) {
		ArrayList<ProductoMenu> listacombos = rest.getMenuBase();
		System.out.println(listacombos);
		ProductoMenu productomenu = listacombos.get(opcionseleccionada);
		Pedido pedidoencurso = rest.getPedidoEnCurso();
		pedidoencurso.agregarProducto(productomenu);
		
	}
	
	public static void ejecutarOpcionIngrediente(int opcionSeleccionada, Restaurante rest) {
		ArrayList<Ingrediente> listaIngrediente = rest.getIngredientes();
		Ingrediente ingrediente = listaIngrediente.get(opcionSeleccionada);
		Pedido pedidoencurso = rest.getPedidoEnCurso();
		pedidoencurso.agregarProducto(ingrediente);
		
	}

}
