package es.upm.dit.algoritmos.ej209;

public class Cambio {

	public static int contarFormasCambio(int objetivo, int[] monedas) {
		// Definimos los valores de las monedas según el índice del array
		// 0->1, 1->2, 2->5
		// Así podemos reutilizar este array con otros tipos de monedas
		int[] valores = { 1, 2, 5 };

		// Sin un recuento por cada tipo de moneda no se puede calcular nada
		if (monedas == null || monedas.length != valores.length) {
			return 0;
		}

		// Llamada al auxiliar empezando por la moneda más grande
		return contarAux(objetivo, monedas, valores, valores.length - 1);
	}

	// Para evitar contar permutaciones (ej: 1+2 y 2+1) como distintas, usamos un
	// método auxiliar que impone un orden en el uso de monedas
	private static int contarAux(int objetivo, int[] monedas, int[] valores, int indiceMoneda) {
		// Casos base
		if (objetivo == 0)
			return 1; // Solución encontrada, ya tenemos 1 forma
		if (objetivo < 0)
			return 0; // Se pasó
		if (indiceMoneda < 0)
			return 0; // No quedan tipos de monedas para probar

		int valorActual = valores[indiceMoneda]; // Guardamos la moneda con la que vamos a trabajar
		int cantidadDisponible = monedas[indiceMoneda];
		int formas = 0;

		// Probamos a usar desde 0 hasta cantidadDisponible monedas de este tipo
		for (int i = 0; i <= cantidadDisponible; i++) {
			int sumaActual = i * valorActual;

			// Si nos pasamos, dejamos de probar (optimización)
			if (sumaActual > objetivo)
				break;

			// Llamada recursiva con el objetivo restante y pasando al siguiente tipo de moneda
			// Pasamos cantidades tal cual porque vamos a trabajar con otro tipo de moneda
			formas += contarAux(objetivo - sumaActual, monedas, valores, indiceMoneda - 1);
		}

		return formas;
	}
}
