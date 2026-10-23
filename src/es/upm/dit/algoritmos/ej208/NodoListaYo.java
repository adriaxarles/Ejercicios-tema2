package es.upm.dit.algoritmos.ej208;

public class NodoListaYo {

	private int dato;
	private NodoListaYo siguiente;

	public NodoListaYo(int dato) {
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoListaYo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaYo siguiente) {
		this.siguiente = siguiente;
	}
	/*
	 * Dada una lista enlazada simple (cada nodo tiene una referencia al siguiente,
	 * pero no al anterior), definida por la clase NodoLista, implemente un método
	 * recursivo que devuelva el nodo cabecera de otra lista del mismo tipo, con los
	 * mismos nodos, pero en orden inverso. El caso base ya se le proporciona:
	 */

	public static NodoListaYo invertirRecursivo(NodoListaYo actual) {
		// TODO: Complete este código
		// Caso base: lista vacía o único elemento
		if (actual == null || actual.siguiente == null) {
			return actual;
		}
		// Paso recursivo:
		NodoListaYo primero = invertirRecursivo(actual.getSiguiente());

		NodoListaYo penultimo = actual.siguiente;

		penultimo.siguiente = actual;
		actual.siguiente = null;
		return primero;

	}

	// Método auxiliar para visualizar la lista fácilmente en consola
	public static String imprimirLista(NodoListaYo nodo) {
		StringBuilder sb = new StringBuilder();
		NodoListaYo actual = nodo;
		while (actual != null) {
			sb.append(actual.dato).append(" -> "); // Cambia "dato" por el nombre del atributo si en tu clase se llama
													// diferente (ej: valor)
			actual = actual.siguiente; // Cambia "siguiente" si el atributo de enlace tiene otro nombre
		}
		sb.append("null");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("--- PRUEBAS PARA INVERTIR LISTA ENLAZADA (NodoListaYo) ---\n");

		// 1. Caso: Lista vacía (null)
		// -------------------------------------------------------------
		NodoListaYo listaVacia = null;
		NodoListaYo resultadoVacia = invertirRecursivo(listaVacia); // Cambia el nombre del método si es distinto
		System.out.println("Test 1 (Lista nula) - Esperado: null | Resultado: " + imprimirLista(resultadoVacia));

		// 2. Caso: Lista con un único elemento (Ej: 5)
		// -------------------------------------------------------------
		NodoListaYo listaUnica = new NodoListaYo(5); // Si no tienes constructor con parámetros, usa: NodoListaYo
														// listaUnica = new NodoListaYo(); listaUnica.dato = 5;
		NodoListaYo resultadoUnica = invertirRecursivo(listaUnica);
		System.out.println(
				"Test 2 (Un solo elemento) - Esperado: 5 -> null | Resultado: " + imprimirLista(resultadoUnica));

		// 3. Caso: Lista con varios elementos (Ej: 1 -> 2 -> 3)
		// -------------------------------------------------------------
		NodoListaYo listaOriginal = new NodoListaYo(1);
		listaOriginal.siguiente = new NodoListaYo(2);
		listaOriginal.siguiente.siguiente = new NodoListaYo(3);

		System.out.println("Lista original: " + imprimirLista(listaOriginal));

		NodoListaYo resultadoInvertida = invertirRecursivo(listaOriginal);
		System.out.println("Test 3 (Varios elementos) - Esperado: 3 -> 2 -> 1 -> null | Resultado: "
				+ imprimirLista(resultadoInvertida));
	}

}
