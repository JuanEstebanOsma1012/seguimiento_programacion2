package co.edu.uniquindio.tallerMatrices.test;

import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatricesNoCompatibles;
import co.edu.uniquindio.tallerMatrices.exception.ExceptionMatrizNula;
import co.edu.uniquindio.tallerMatrices.model.PuntosTaller;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int[][] primeraMatriz = {{0, 5, 8, 6}, {2, 15, 23, 7}, {6, 94, 8, 3}};
		int[][] segundaMatriz = {{8, 15, 13, 18}, {2, 7, 1, 0}};
		int[][] terceraMatriz = {{8, 10}, {11, 2}, {0, 1}, {12, 5}};
		int[][] cuartaMatriz = {{8, 1, 2}, {1, -2, 3}, {2, 3, 1}};
		int[][] quintaMatriz = PuntosTaller.crearMatrizPotenciasDeDos(5);
		int[][] sextaMatriz = {{5, 8, 13, 2}, {7, 0, 15, 1}, {11, 0, 14, 3}, {6, 9, 1, 2}};
		char[][] septimaMatriz = PuntosTaller.crearMatrizDeCaracteres(7);
		int[][] octavaMatriz = PuntosTaller.crearMatrizDeNumerosEnSerpiente(6);
		int[][] novenaMatriz = PuntosTaller.crearMatrizDeUnos(4, 6);
		int[][] decimaMatriz = {{5, 8, 13, 2}, {7, 0, 15, 1}, {11, 0, 14, 3}, {6, 9, 1, 2}};
		int[][] onceavaMatriz = PuntosTaller.crearMatrizDeUnos(7);
		
		String[] arregloDeCadenas = {"arreglo", "bolas", "disposicion", "cola", "eraser", "raya", "huila", "bala", "bola"};
		String[] arregloCadenasOrdenado = PuntosTaller.ordenarDeManeraDescendente(arregloDeCadenas);
		
		try {
			int[][] matrizResultado = PuntosTaller.multiplicacionMatrices(primeraMatriz, terceraMatriz);
		} catch (ExceptionMatrizNula | ExceptionMatricesNoCompatibles e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cadenaPrueba = "pruebaGeneRAl";
		cadenaPrueba = PuntosTaller.organizarCadena2(cadenaPrueba);
		System.out.println(cadenaPrueba);
	}

}
