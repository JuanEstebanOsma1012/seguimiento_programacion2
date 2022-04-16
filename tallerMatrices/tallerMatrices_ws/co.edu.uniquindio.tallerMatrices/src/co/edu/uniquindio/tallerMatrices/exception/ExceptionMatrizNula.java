package co.edu.uniquindio.tallerMatrices.exception;

@SuppressWarnings("serial")
public class ExceptionMatrizNula extends RuntimeException{

	public ExceptionMatrizNula(){
		
		super("las matrices que esta ingresando no pueden ser nulas");
		
	}
	
}
