package Exceptions;

public class CostoPedidoException extends Exception{

	public CostoPedidoException(String nombreprod, int precio) throws Exception {
		throw new Exception("No se puede agregar el producto: ' " + nombreprod +
							" ' debido a que el valor del pedido superaria los 150.000 pesos. Costo pedido actual : " + precio);
		
	}

}
