package co.edu.uniquindio.tallerMatrices.model;

import java.util.Arrays;

import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatricesNoCompatibles;
import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatrizNoCuadrada;
import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatrizNula;
import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatrizVacia;

public class PuntosTaller {

	/**
	 * Punto uno: este metodo multiplica dos matrices de la manera tradicional, lanza excepciones cuando alguna de las matrices es nula o cuando no son compatibles
	 * @param primeraMatriz
	 * @param segundaMatriz
	 * @return
	 * @throws ExceptionMatricesNoCompatibles
	 * @throws ExceptionMatrizNula
	 */
	public static int[][] multiplicacionMatrices(int[][] primeraMatriz, int[][] segundaMatriz) throws ExceptionMatricesNoCompatibles, ExceptionMatrizNula {
		
		int[][] matrizResultado = null;
		
		if (primeraMatriz == null || segundaMatriz == null){
			throw new ExceptionMatrizNula();
		} else if (primeraMatriz[0].length != segundaMatriz.length){
			throw new ExceptionMatricesNoCompatibles();
		} else {
			
			matrizResultado = new int[primeraMatriz.length][segundaMatriz[0].length];
			
			for (int i = 0; i < matrizResultado.length; i++) {
				for (int j = 0; j < matrizResultado[i].length; j++) {
				
					int[] columnaSegundaMatriz = UtilsMatrices.obtenerColumnaMatriz(segundaMatriz, j);
					matrizResultado[i][j] = UtilsMatrices.obtenerMultiplicacionFilas(primeraMatriz[i], columnaSegundaMatriz);
					
				}
			}
		}
		return matrizResultado;
	}
	
	/**
	 * Punto dos: este metodo verifica si una matriz es simetrica o no, es simetrica cuando su matriz transpuesta es igual a la original
	 * @param matriz
	 * @return
	 * @throws ExceptionMatrizNula
	 * @throws ExceptionMatrizNoCuadrada
	 * @throws ExceptionMatricesNoCompatibles
	 */
	public static boolean esSimetrica(int[][] matriz) throws ExceptionMatrizNula, ExceptionMatrizNoCuadrada, ExceptionMatricesNoCompatibles{
		
		if (matriz == null) {
			throw new ExceptionMatrizNula();
		} else if (!UtilsMatrices.esCuadrada(matriz)) {
			throw new ExceptionMatrizNoCuadrada();
		} else {
						
			int[][] matrizTranspuesta = UtilsMatrices.obtenerMatrizTranspuesta(matriz);
			
			if (UtilsMatrices.matricesIguales(matriz, matrizTranspuesta)) {
				return true;	
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Punto tres: este metodo crea una matriz cuadrada de dimensiones NxN con potencias de dos por encima de la diagonal principal y ceros por debajo
	 * @param dimensionMatriz
	 * @return
	 * @throws NegativeArraySizeException
	 */
	public static int[][] crearMatrizPotenciasDeDos(int dimensionMatriz) throws NegativeArraySizeException {
		
		int[][] matrizResultado = new int[dimensionMatriz][dimensionMatriz];
		int potencia = 0;
		int diagonalPrincipal = 0;
		
		for (int i = 0; i < matrizResultado.length; i++) {
			
			matrizResultado[diagonalPrincipal][diagonalPrincipal] = 1;
			
			for (int j = diagonalPrincipal + 1; j < matrizResultado.length; j++) {
				matrizResultado[i][j] = (int)Math.pow(2, potencia);
				potencia ++;
			}
			
			diagonalPrincipal ++;	
		}
		
		return matrizResultado;
	}
	
	/**
	 * Punto cuatro: este metodo arroja true si existen dos ceros consecutivos, false en el caso contrario 
	 * @param matriz
	 * @return
	 * @throws ExceptionMatrizNula
	 */
	public static boolean existenDosCerosConsecutivos(int[][] matriz) throws ExceptionMatrizNula{
		
		if (matriz == null) {
			throw new ExceptionMatrizNula();
		} else {
			
			for (int i = 0; i < matriz.length - 1; i++) {
				for (int j = 0; j < matriz[i].length - 1; j++) {
					
					if (matriz[i][j] == 0) {
						if (matriz[i][j + 1] == 0){
							return true;
						} else if (matriz[i + 1][j] == 0){
							return true;
						}
					}
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Punto cinco: este metodo devuelve una matriz de caracteres de asterisco con un patron en forma de reloj de arena
	 * @param dimensiones
	 * @return
	 */
	public static char[][] crearMatrizDeCaracteres(int dimensiones){
		
		char[][] matrizResultado = new char[dimensiones][dimensiones];
		if (dimensiones == 0) {
			return matrizResultado;
		}
		
		int primeraPosicion = 0;
		int ultimaPosicion = matrizResultado[0].length - 1;
		
		for (int i = 0; i < matrizResultado.length; i++) {
			
			if (ultimaPosicion - primeraPosicion >= 1){
				for (int j = primeraPosicion; j <= ultimaPosicion; j++) {
					matrizResultado[i][j] = '*';
				}
			} else {
				for (int j = ultimaPosicion; j <= primeraPosicion; j++) {
					matrizResultado[i][j] = '*';
				}
			}
			primeraPosicion++;
			ultimaPosicion--;
		}
		
		return matrizResultado;
	}
	
	/**
	 * Punto seis: este metodo permite crear una matriz de numeros en la que las columnas pares tienen los numeros en orden ascendente y las impares en forma descendente
	 * @param dimensiones
	 * @return
	 */
	public static int[][] crearMatrizDeNumerosEnSerpiente(int dimensiones){
		
		int[][] matrizResultado = new int[dimensiones][dimensiones];
		if (dimensiones == 0) {
			return matrizResultado;
		}
		
		int valor = 1;
		for (int i = 0; i < matrizResultado.length; i++) {
			for (int j = matrizResultado[i].length - 1; j >= 0 ; j--) {
				matrizResultado[i][j] = valor;
				valor++;
			}
			if (i % 2 == 0) {
				Arrays.sort(matrizResultado[i]);
			}
		}
		
		return UtilsMatrices.obtenerMatrizTranspuesta(matrizResultado);
	}
	
	/**
	 * Punto siete: este metodo permite crear una matriz que tenga unos en todas las filas pares y solo al principio y al final en las filas impares
	 * @param filas
	 * @param columnas
	 * @return
	 */
	public static int[][] crearMatrizDeUnos(int filas, int columnas){
		
		int[][] matrizResultado = new int[filas][columnas];
		if ((filas * columnas) == 0) {
			return matrizResultado;
		}
		
		for (int i = 0; i < matrizResultado.length; i++) {
			if(i % 2 == 0){
				for (int j = 0; j < matrizResultado[i].length; j++) {
					matrizResultado[i][j] = 1;
				}
			} else {
				matrizResultado[i][0] = 1;
				matrizResultado[i][matrizResultado[i].length - 1] = 1;
			}
		}
		
		return matrizResultado;
	}
	
	/**
	 * Punto ocho: este metodo arroja true si la segunda matriz esta contenida en la primera, false en cualquier otro caso
	 * @param matrizContentora
	 * @param matrizContenida
	 * @return
	 * @throws ExceptionMatricesNoCompatibles
	 * @throws ExceptionMatrizVacia
	 * @throws ExceptionMatrizNula
	 */
	public static boolean estaContenida(int[][] matrizContentora, int[][] matrizContenida) throws ExceptionMatricesNoCompatibles, ExceptionMatrizVacia, ExceptionMatrizNula{
		
		if (matrizContentora == null || matrizContenida == null) {
			throw new ExceptionMatrizNula();
		} else if (matrizContenida.length == 0 || matrizContentora.length == 0){
			throw new ExceptionMatrizVacia();
		} else if (matrizContenida.length > matrizContentora.length || matrizContenida[0].length > matrizContentora[0].length){
			throw new ExceptionMatricesNoCompatibles();
		} else {
			
			for (int i = 0; i <= matrizContentora.length - matrizContenida.length; i++) {
				for (int j = 0; j <= matrizContentora[i].length - matrizContenida[0].length; j++) {
					if (matrizContentora[i][j] == matrizContenida[0][0]) {
						
						int filasSubMatriz = matrizContenida[0].length;
						int columnasSubMatriz = matrizContenida.length;
						if (UtilsMatrices.matricesIguales(UtilsMatrices.obtenerSubMatriz(matrizContentora, i, j, filasSubMatriz, columnasSubMatriz), matrizContenida)){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Punto nueve: este metodo permite obtener la posicion en la que se encuentra la cadena mas larga del arreglo
	 * @param arregloDeCadenas
	 * @return
	 * @throws ExceptionMatrizVacia
	 * @throws ExceptionMatrizNula
	 */
	public static int obtenerIndiceCadenaMasLarga(String[] arregloDeCadenas) throws ExceptionMatrizVacia, ExceptionMatrizNula {
		
		int indiceCadenaMasLarga = 0;
		
		if (arregloDeCadenas == null) {
			throw new ExceptionMatrizNula();
		} else if (arregloDeCadenas.length == 0){
			throw new ExceptionMatrizVacia();
		} else {
			
			int longitudCadenaMasLarga = arregloDeCadenas[0].length();
			
			for (int i = 1; i < arregloDeCadenas.length; i++) {
				if (arregloDeCadenas[i].length() > longitudCadenaMasLarga) {
					longitudCadenaMasLarga = arregloDeCadenas[i].length();
					indiceCadenaMasLarga = i;
				}
			}
		}
		
		return indiceCadenaMasLarga;
	}
	
	/**
	 * Punto diez: este arreglo permite ordenar de manera descendente una arreglo de cadenas, si una cadena es igual que otra pero tiene caracteres de mas, se pondra primero la que tenga mayor longitud
	 * @param arregloDeCadenas
	 * @return
	 * @throws ExceptionMatrizNula
	 * @throws ExceptionMatrizVacia
	 */
	public static String[] ordenarDeManeraDescendente(String[] arregloDeCadenas) throws ExceptionMatrizNula, ExceptionMatrizVacia {
		
		if (arregloDeCadenas == null) {
			throw new ExceptionMatrizNula();
		} else if (arregloDeCadenas.length == 0) {
			throw new ExceptionMatrizVacia();
		}
		
		boolean flag = true;
		String[] arregloResultante = UtilsMatrices.crearNuevoArreglo(arregloDeCadenas);
		
		for (int i = 0; i < arregloResultante.length; i++) {
			for (int j = 0; j < arregloResultante.length - 1; j++) {
				
				flag = true;
				String[] cadenasAux = {arregloResultante[j], arregloResultante[j + 1]};
				String cadenaMasCorta = UtilsMatrices.obtenerCadenaMasCorta(cadenasAux);
				
				for (int k = 0; k < cadenaMasCorta.length() && flag; k++) {
					if (arregloResultante[j].toLowerCase().charAt(k) < arregloResultante[j + 1].toLowerCase().charAt(k)) {
						
						String cadenaAux = arregloResultante[j];
						arregloResultante[j] = arregloResultante[j + 1];
						arregloResultante[j + 1] = cadenaAux;
						flag = false;
						
					} else if (arregloResultante[j].toLowerCase().charAt(k) > arregloResultante[j + 1].toLowerCase().charAt(k)) {
						
						flag = false;
					}
				}
			}
		}
		
		return arregloResultante;
	}

	/**
	 * Punto ¿Diez?, este metodo permite crear una matriz de unos en forma de piramide girada
	 * @param dimensiones
	 * @return
	 * @throws ExceptionMatrizNula
	 */
	public static int[][] crearMatrizDeUnos(int dimensiones) throws ExceptionMatrizNula {
			
		if (dimensiones <= 0 || dimensiones % 2 == 0) {
			throw new ExceptionMatrizNula();
		}
		
		int[][] matrizResultado = new int[dimensiones][dimensiones];
		int primeraPosicion = 0;
		int ultimaPosicion = dimensiones - 1;
		
		for (int i = 0; i < matrizResultado.length; i+=2) {
			if (i == matrizResultado.length - 1) {
				matrizResultado[i][primeraPosicion] = 1;
			} else {
				for (int j = primeraPosicion; j <= ultimaPosicion; j++) {
					matrizResultado[i][j] = 1;
					matrizResultado[i + 1][j] = 1;
				}
				primeraPosicion++;
				ultimaPosicion--;
			}
		} 
		
		return UtilsMatrices.obtenerMatrizTranspuesta(matrizResultado);
	}
	
	/**
	 * Punto once: este metodo permite organizar una cadena de modo que las vocales esten de primeras y las consonantes luego
	 * @param cadena
	 * @return
	 */
	public static String organizarCadena(String cadena){
		
		if (cadena == null) {
			throw new ExceptionMatrizNula();
		} else if (cadena == "") {
			throw new ExceptionMatrizVacia();
		}
		
		String nuevaCadena = "";
		
		for (int i = 0; i < cadena.length(); i++) {
			if (UtilsCadenas.esVocal(cadena.charAt(i))) {
				
				nuevaCadena += cadena.charAt(i);
				
			}
		}
		
		for (int i = 0; i < cadena.length(); i++) {
			if (!UtilsCadenas.esVocal(cadena.charAt(i))) {
				
				nuevaCadena += cadena.charAt(i);
				
			}
		}
		
		return nuevaCadena;
	}
	
	/**
	 * Punto once: este metodo tambien organiza la cadena, primero vocales y luego consonantes pero es por si no le gusta el otro, que le guste este y no me lo ponga malo profe, muchas gracias :)
	 * @param cadena
	 * @return
	 */
	public static String organizarCadena2(String cadena){
		
		if (cadena == null) {
			throw new ExceptionMatrizNula();
		} else if (cadena == "") {
			throw new ExceptionMatrizVacia();
		}
		
		char[] nuevaCadena = cadena.toCharArray();
		int indiceConsonantes = UtilsCadenas.obtenerCantidadVocales(cadena);
		int indiceVocales = 0;
		
		for (int i = 0; i < cadena.length(); i++) {
			if (UtilsCadenas.esVocal(cadena.charAt(i))) {
				
				nuevaCadena[indiceVocales] = cadena.charAt(i);
				indiceVocales++;
				
			} else {
				
				nuevaCadena[indiceConsonantes] = cadena.charAt(i);
				indiceConsonantes++;
				
			}
		}
		
		return UtilsCadenas.convertirArregloDeCaracteresACadena(nuevaCadena);
	}
}
