package co.edu.uniquindio.tallerMatrices.exception;

@SuppressWarnings("serial")
public class ExceptionMatrizVacia extends RuntimeException {

	public ExceptionMatrizVacia(){
		super("la matriz que introdujo esta vacia");
	}
	
}
