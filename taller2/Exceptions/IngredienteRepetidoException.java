package Exceptions;

public class IngredienteRepetidoException extends HamburguesaException {
	
	
	private String nombreProducto;
	public IngredienteRepetidoException(String nombre) throws Exception {	
		nombreProducto = nombre;
		Repetido();
	}

	@Override
	public void Repetido() throws Exception {
		throw new Exception("Existe el ingrediente " + nombreProducto + " repetido");
		
		
	}

}
