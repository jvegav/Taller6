package Exceptions;

public class ProductoRepetidoException extends HamburguesaException{
	
	private String nombreProducto;
	public ProductoRepetidoException(String nombre) throws Exception {
		nombreProducto = nombre;
		Repetido();
	}

	@Override
	public void Repetido() throws Exception {
		throw new Exception("Existe el producto " + nombreProducto + " repetido");
		
		
		
	}

}
