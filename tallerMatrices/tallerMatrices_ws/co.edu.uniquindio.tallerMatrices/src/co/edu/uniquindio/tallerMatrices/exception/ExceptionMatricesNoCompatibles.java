package co.edu.uniquindio.tallerMatrices.exception;

@SuppressWarnings("serial")
public class ExceptionMatricesNoCompatibles extends Exception{

	public ExceptionMatricesNoCompatibles(){
		super("las matrices que esta intentando operar no son compatibles");
	}
	
}
