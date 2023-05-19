package test;
import model.ProductoMenu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductoMenuTest {

	@Test
	void test() {
			ProductoMenu producto = new ProductoMenu("Papas", 1234);
			String factura = producto.generarTextoFactura();
			Assertions.assertEquals("con Papas",factura);
	}

}
