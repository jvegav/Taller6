package model;

public class ProductoAjustado implements Producto{
	
	
	private int precio;
	private Double descuento;
	private String nombreProd;
	
	
	
	public ProductoAjustado(String nombre, int precioBase, String descuento) {
		this.nombreProd = nombre;
		
		String descuentofin = descuento.replace("%", "");
		Double descuentofinal = Double.parseDouble(descuentofin);
		descuentofinal = descuentofinal /100;
		
		
		this.descuento = descuentofinal;
		this.precio = (int) (precioBase - (this.descuento * precioBase) );
		
		
		
	}

	@Override
	public int getPrecio() {
		return precio;
	}

	@Override
	public String getNombre() {
		return nombreProd;
	}

	@Override
	public String generarTextoFactura() {
		return "con " + nombreProd;
	}
	
	

}
