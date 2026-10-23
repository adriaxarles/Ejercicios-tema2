package es.upm.dit.algoritmos.ej209;

import java.util.Arrays;

public class CambioYo {
	/*
	 * Implemente un método recursivo que permita calcular de cuántas formas
	 * distintas se puede sumar la cantidad objetivo usando monedas de valores 1, 2
	 * y 5. Por ejemplo, para objetivo = 3 hay 2 formas: (1+1+1) y (1+2).
	 * 
	 * A continuación se la proporciona la cabecera del método a implementar. En
	 * ella, monedas es un array de tamaño 3 que contiene:
	 * 
	 * En la posición 0, el número de monedas de 1.
	 * 
	 * En la posición 1, el número de monedas de 2.
	 * 
	 * En la posición 2, el número de monedas de 5.
	 * 
	 * Pista: Los casos base son: objetivo == 0 (se encontró una forma),
	 * 
	 * objetivo <0 (se pasó) y
	 * 
	 * no quedan monedas.
	 */
	public static int contarFormasCambio(int objetivo, int[] monedas) {

		// Caso base
		for (int i = 0; i < monedas.length; i++) {
			if (monedas[i] < 0) {
				return 0;
			}
		}
		if (objetivo == 0) {
			return 1;
		}
		if (objetivo < 0) {
			return 0;
		}
		if (monedas[0] + monedas[1] + monedas[2] == 0) {
			return 0;
		}

		// Caso Recursivo
		int formas = 0;
		formas += contarFormasCambio(objetivo - 1, new int[] { monedas[0] - 1, monedas[1], monedas[2] });
		formas += contarFormasCambio(objetivo - 2, new int[] { 0, monedas[1] - 1, monedas[2] });
		formas += contarFormasCambio(objetivo - 5, new int[] { 0, 0, monedas[2] - 1 });

		return formas;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int objetivo = 0; objetivo < 100; objetivo++) {
			System.out.println("objetivo = " + objetivo + " num de formas = "
					+ contarFormasCambio(objetivo, new int[] { 10, 4, 20 }));
		}

	}
}
