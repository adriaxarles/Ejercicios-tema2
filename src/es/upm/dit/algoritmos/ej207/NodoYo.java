package es.upm.dit.algoritmos.ej207;

public class NodoYo {
	private int valor;
	private NodoYo izq, der;

	public NodoYo(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoYo getIzq() {
		return izq;
	}

	public void setIzq(NodoYo izq) {
		this.izq = izq;
	}

	public NodoYo getDer() {
		return der;
	}

	public void setDer(NodoYo der) {
		this.der = der;
	}

	public static boolean esBST(NodoYo nodo) {
		return esBSTAux(nodo, null, null);
	}

	/*
	 * Dado un árbol binario, valide si cumple con la propiedad de un BST (Binary
	 * Search Tree, árbol binario de búsqueda): en cada nodo, todos los valores de
	 * los nodos del subárbol izquierdo son menores al del nodo, y todos los del
	 * derecho son mayores. Implemente la función auxiliar recursiva esBSTAux, que
	 * mantiene el rango de valores válidos mediante los nodos antecesores que lo
	 * acotan: min por debajo y max por arriba. Un límite a null indica que ese lado
	 * no está acotado, como ocurre en la raíz.
	 */
	private static boolean esBSTAux(NodoYo nodo, NodoYo min, NodoYo max) {
		if (nodo == null) {
			return true;
		}

		// evaluar el padre o el caso base
		if (min != null && nodo.getValor() <= min.getValor()) {
			return false;
		}
		if (max != null && nodo.getValor() >= max.getValor()) {
			return false;
		}

		// comprobar el hijo izq
		if (nodo.getIzq() != null) {
			if (!esBSTAux(nodo.getIzq(), min, nodo))
				return false;
		}

		// comprobar el hijo derecho
		if (nodo.getDer() != null) {
			if (!esBSTAux(nodo.getDer(), nodo, max))
				return false;
		}

		return true;
	}

	private static boolean esBSTAux2(NodoYo nodo, NodoYo min, NodoYo max) {
		if (nodo == null) {
			return true;
		}

		// evaluar el padre o el caso base
		if (min != null && nodo.getValor() <= min.getValor()) {
			return false;
		}
		if (max != null && nodo.getValor() >= max.getValor()) {
			return false;
		}

		// comprobar el hijo izq
		if (!esBSTAux(nodo.getIzq(), min, nodo))
			return false;

		// comprobar el hijo derecho
		if (!esBSTAux(nodo.getDer(), nodo, max))
			return false;

		return true;
	}

	public static void main(String[] args) {
		System.out.println("--- PRUEBAS PARA VALIDACIÓN DE BST (NodoYo) ---\n");

		// 1. Caso: Árbol vacío (normalmente se considera un BST válido)
		// -------------------------------------------------------------
		boolean testVacio = esBST(null); // Cambia "esBST" por el nombre de tu método de entrada si es diferente
		System.out.println("Test 1 (Árbol nulo) - Esperado: true | Resultado: " + testVacio);

		// 2. Caso: Árbol binario de búsqueda (BST) VÁLIDO
		// Estructura:
		// 10
		// / \
		// 5 15
		// / \ / \
		// 2 7 12 20
		// -------------------------------------------------------------
		NodoYo raizValida = new NodoYo(10);
		raizValida.izq = new NodoYo(5);
		raizValida.der = new NodoYo(15);

		raizValida.izq.izq = new NodoYo(2);
		raizValida.izq.der = new NodoYo(7);

		raizValida.der.izq = new NodoYo(12);
		raizValida.der.der = new NodoYo(20);

		boolean testValido = esBST(raizValida);
		System.out.println("Test 2 (BST Válido) - Esperado: true | Resultado: " + testValido);

		// 3. Caso: Árbol INVÁLido (Un nodo a la izquierda es mayor que la raíz)
		// Estructura:
		// 10
		// / \
		// 5 15
		// \
		// 12 <-- ¡Error! 12 es mayor que 10 y está en el subárbol izquierdo
		// -------------------------------------------------------------
		NodoYo raizInvalida = new NodoYo(10);
		raizInvalida.izq = new NodoYo(5);
		raizInvalida.der = new NodoYo(15);

		raizInvalida.izq.der = new NodoYo(12); // Rompe la regla del BST

		boolean testInvalido = esBST(raizInvalida);
		System.out.println("Test 3 (BST Inválido) - Esperado: false | Resultado: " + testInvalido);
	}

}
