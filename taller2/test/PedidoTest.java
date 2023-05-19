package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.CostoPedidoException;
import model.Pedido;
import model.ProductoMenu;
import model.Producto;
import java.util.ArrayList;

class PedidoTest {
	
	private Pedido pedido;
	private ProductoMenu prod;
	@BeforeEach
	public void setUp() throws Exception {
		pedido = new Pedido("Josue Vega" , "Universidad");
		prod = new ProductoMenu("Papas",5000);
		
		pedido.agregarProducto(prod);
	}

	@Test
	void testGetIdpedido() {
		int id = pedido.getIdPedido();
		
		// verifica que sea positivo que es lo unico que nos interesa
		Assertions.assertTrue(id >= 0);
	}
	
	@Test
	void testAgregarProducto() throws Exception {
		
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add(prod);
	    int costoPedido = pedido.getCostopedido();
		if(costoPedido+5000 > 150000) {
			throw new CostoPedidoException("Papas",costoPedido);
		}
		
		
		Assertions.assertIterableEquals(lista, pedido.getListaProductos());
		
	}
	
	
	@Test
	void testGuardarfactura() throws Exception {
		
		
		Assertions.assertEquals("Papas", pedido.guardarFactura());
	}
	
	@Test
	void testGetCostoPedido() throws Exception {
		
		
		Assertions.assertEquals(5000, pedido.getCostopedido());
	}
	
	
	@Test
	void testGetListaProductos() throws Exception {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add(prod);
		
		Assertions.assertIterableEquals(lista, pedido.getListaProductos());
	
	}
	
	
	
	
	
	
	
	
	

}
