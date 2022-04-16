package co.edu.uniquindio.tallerMatrices.model;

public class UtilsCadenas {

	/**
	 * este metodo permite obtener la cantidad de vocales que hay en una cadena, ya sea minusculas o mayusculas
	 * @param cadena
	 * @return
	 */
	public static int obtenerCantidadVocales(String cadena) {

		int cantidadVocales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (esVocal(cadena.charAt(i))) {
				cantidadVocales++;
			}
		}
		
		return cantidadVocales;
	}
	
	/**
	 * este metodo convierte un arreglo compuesto de caracteres a una cadena que los una a todos
	 * @param nuevaCadena
	 * @return
	 */
	public static String convertirArregloDeCaracteresACadena(char[] nuevaCadena) {
		
		String cadenaResultante = "";
		for (char c : nuevaCadena) {
			cadenaResultante += c;
		}
		
		return cadenaResultante;
	}

	/**
	 * este metodo nos informa si el caracter que se le pasa por parametro es una vocal o no lo es
	 * @param c
	 * @return
	 */
	public static boolean esVocal(char c) {

		char[] vocales = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		for (int i = 0; i < vocales.length; i++) {
			if (vocales[i] == c) {
				return true;
			}
		}
		
		return false;
	}
	
}
