package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import model.Combos;
import model.ProductoAjustado;

import org.junit.jupiter.api.Test;


class ComboTest {
	
	
	private Combos comb;
	@BeforeEach
	public void setUp() throws Exception {
		comb = new Combos("Combo Hamburguesa" , "10%");
	}
	
	
	@Test
	void testAgregarItem() {
		ProductoAjustado itemCombo = new ProductoAjustado("Papas",5000,"10%");
		
		comb.agregarIteamACombo(itemCombo);
		ProductoAjustado prodEsperado = comb.getItemCombo("Papas");
		
		Assertions.assertEquals(itemCombo, prodEsperado);
		
	}
	
	@Test
	void testgetPrecio() {
		ProductoAjustado itemCombo = new ProductoAjustado("Papas",5000,"10%");

		comb.agregarIteamACombo(itemCombo);
		int precio = comb.getPrecio();
		
		
		
		Assertions.assertEquals(4500, precio);
		
	}
	@Test
	void testFactura() {
		String factura = comb.generarTextoFactura();
		Assertions.assertEquals("con Combo Hamburguesa", factura);
	}
	
	

}
