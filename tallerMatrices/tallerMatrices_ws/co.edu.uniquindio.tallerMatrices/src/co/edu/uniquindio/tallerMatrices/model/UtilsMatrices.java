package co.edu.uniquindio.tallerMatrices.model;

import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatricesNoCompatibles;
import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatrizNula;

public class UtilsMatrices {

	/**
	 * este metodo permite crear un nuevo arreglo de cadenas exactamente igual al que se le pasa por parametro, pero cuando este es editado, no se edita el que se pasa por parametro
	 * @param arregloDeCadenas
	 * @return
	 */
	public static String[] crearNuevoArreglo(String[] arregloDeCadenas) {
		
		String[] nuevoArreglo = new String[arregloDeCadenas.length];
		
		for (int i = 0; i < arregloDeCadenas.length; i++) {
			nuevoArreglo[i] = arregloDeCadenas[i];
		}
		
		return nuevoArreglo;
	}

	/**
	 * este metodo permite obtener una sub matriz de la matriz original, recibe la matriz original, la fila y la columna en la que esta el primer elemento y la cantidad de filas y columnas que va a tener la submatriz, respectivamente
	 * @param matrizContentora
	 * @param filaPrimerElemento
	 * @param columnaPrimerElemento
	 * @param filasSubMatriz
	 * @param columnasSubMatriz
	 * @return
	 */
	public static int[][] obtenerSubMatriz(int[][] matrizContentora, int filaPrimerElemento, int columnaPrimerElemento,
			int filasSubMatriz, int columnasSubMatriz) {

		int[][] subMatrizResultante = null;
		
		if (matrizContentora == null) {
			throw new ExceptionMatrizNula();
		} else {
			
			subMatrizResultante = new int[filasSubMatriz][columnasSubMatriz];
			for (int k = 0; k < subMatrizResultante.length; k++) {
				
				int columnaPrimerElementoAux = columnaPrimerElemento;
				for (int k2 = 0; k2 < subMatrizResultante[k].length; k2++) {
					subMatrizResultante[k][k2] = matrizContentora[filaPrimerElemento][columnaPrimerElementoAux];
					columnaPrimerElementoAux++;
				}
				filaPrimerElemento++;
			}
		}
		
		return subMatrizResultante;
	}

	/**
	 * este metodo devuelve true si las dos matrices que se le pasan por parametro son exactamente identicas, false en el caso contrario
	 * @param primeraMatriz
	 * @param segundaMatriz
	 * @return
	 * @throws ExceptionMatrizNula
	 * @throws ExceptionMatricesNoCompatibles
	 */
	public static boolean matricesIguales(int[][] primeraMatriz, int[][] segundaMatriz) throws ExceptionMatrizNula, ExceptionMatricesNoCompatibles {

		if (!matricesMismoTamaño(primeraMatriz, segundaMatriz)) {
			throw new ExceptionMatricesNoCompatibles();
		} else {
			
			for (int i = 0; i < primeraMatriz.length; i++) {
				for (int j = 0; j < primeraMatriz[i].length; j++) {
					
					if (primeraMatriz[i][j] != segundaMatriz[i][j]) {
						
						return false;
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * este metodo devuelve true si las matrices que se le pasan por parametro tienen las mismas dimensiones, false en el caso contrario
	 * @param primeraMatriz
	 * @param segundaMatriz
	 * @return
	 * @throws ExceptionMatrizNula
	 */
	public static boolean matricesMismoTamaño(int[][] primeraMatriz, int[][] segundaMatriz) throws ExceptionMatrizNula {

		if (primeraMatriz == null || segundaMatriz == null) {
			throw new ExceptionMatrizNula();
		} else {
			
			return (primeraMatriz.length == segundaMatriz.length && primeraMatriz[0].length == segundaMatriz[0].length);
		}
	}

	/**
	 * este metodo retorna una matriz nueva en la que sus columnas son las filas de la matriz original
	 * @param matriz
	 * @return
	 * @throws ExceptionMatrizNula
	 */
	public static int[][] obtenerMatrizTranspuesta(int[][] matriz) throws ExceptionMatrizNula{

		int[][] matrizTranspuesta = null;
		
		if (matriz == null) {
			throw new ExceptionMatrizNula();
		} else {
			
			matrizTranspuesta = new int[matriz.length][matriz[0].length];
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					matrizTranspuesta[j][i] = matriz[i][j];
					
				}
			}
		}
		
		return matrizTranspuesta;
	}

	/**
	 * este metodo devuelve true si la matriz que se pasa por parametro tiene la misma cantidad de filas que de columnas, false en el caso contrario
	 * @param matriz
	 * @return
	 */
	public static boolean esCuadrada(int[][] matriz) {

		return (matriz.length == matriz[0].length);
		
	}

	/**
	 * este metodo multiplica elemento por elemento dos filas de una matriz, multiplica los elementos que estan en la misma posicion y los suma entre si, devuelve el resultado de esta sumatoria
	 * @param primeraFila
	 * @param segundaFila
	 * @return
	 */
	public static int obtenerMultiplicacionFilas(int[] primeraFila, int[] segundaFila) {

		int resultado = 0;
		
		for (int i = 0; i < primeraFila.length; i++) {
			resultado += (primeraFila[i] * segundaFila[i]);
		}
		
		return resultado;
	}

	/**
	 * este metodo devuelve la columna de la matriz que se le pasa por parametro ubicada en la posicion que tambien se le pasa por parametro
	 * @param matriz
	 * @param indiceColumna
	 * @return
	 */
	public static int[] obtenerColumnaMatriz(int[][] matriz, int indiceColumna) {

		int[] columnaMatriz = new int[matriz.length];
		
		for (int i = 0; i < columnaMatriz.length; i++) {
			columnaMatriz[i] = matriz[i][indiceColumna];
		}
		
		return columnaMatriz;
	}
	
	/**
	 * este metodo recibe una matriz de cadenas y devuelve la cadena con menos longitud
	 * @param cadenasAux
	 * @return
	 */
	public static String obtenerCadenaMasCorta(String[] cadenasAux) {
		
		String cadenaMasCorta = cadenasAux[0];
		
		for (int i = 0; i < cadenasAux.length; i++) {
			if (cadenaMasCorta.length() > cadenasAux[i].length()) {
				cadenaMasCorta = cadenasAux[i];
			}
		}

		return cadenaMasCorta;
	}
	
	/**
	 * imprime una representacion de una matriz de enteros
	 * @param matriz
	 */
	public static void imprimirMatriz(int[][] matriz){
		
		String mensaje = "";
		
		if (matriz != null) {
			for (int[] arreglo : matriz) {
				for (int i : arreglo) {
					mensaje += i + "     ";
				}
				mensaje += String.format("%n");
			}
		} else {
			mensaje = "null";
		}
		
		System.out.println(mensaje);
	}
	
	/**
	 * imprime una representacion de una matriz de caracteres
	 * @param matriz
	 */
	public static void imprimirMatriz(char[][] matriz){
		
		String mensaje = "";
		
		if (matriz != null) {
			for (char[] arreglo : matriz) {
				for (char i : arreglo) {
					mensaje += i + "     ";
				}
				mensaje += String.format("%n");
			}
		} else {
			mensaje = "null";
		}
		
		System.out.println(mensaje);
	}
	
}
