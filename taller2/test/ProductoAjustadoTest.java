package test;
import model.ProductoAjustado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductoAjustadoTest {
	
	 private ProductoAjustado producto =  new ProductoAjustado("Papas",5000,"10%");

	@Test
	void test() {
		String factura = producto.generarTextoFactura();
		Assertions.assertEquals("con Papas", factura);
	}
	
	@Test
	void test2() {
		int precio = producto.getPrecio();
		Assertions.assertEquals(4400.0, precio);
	}

}
