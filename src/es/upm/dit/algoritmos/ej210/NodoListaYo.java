package es.upm.dit.algoritmos.ej210;

import java.util.List;

public class NodoListaYo {

	int dato;
	NodoListaYo siguiente;

	public NodoListaYo(int dato) {
		this.dato = dato;
	}

	public NodoListaYo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaYo siguiente) {
		this.siguiente = siguiente;
	}

	public int getDato() {
		return dato;
	}
	/*
	 * La fusión de 2 listas ordenadas es la base del algoritmo Merge sort, uno de
	 * los algoritmos que se vio en clase. Dadas dos listas enlazadas simples l1 y
	 * l2 como las del ejercicio 2.8, que ya están ordenadas de menor a mayor,
	 * implemente un método recursivo que devuelva una única lista ordenada
	 * fusionando ambas.
	 */

	public static NodoListaYo fusionarListas(NodoListaYo l1, NodoListaYo l2) {
		// caso base
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		// Paso Recursivo
		if (l1.getDato() < l2.getDato()) {
			NodoListaYo nodo = new NodoListaYo(l1.getDato());
			nodo.setSiguiente(fusionarListas(l1.getSiguiente(), l2));
			return nodo;
		} else if (l1.getDato() > l2.getDato()) {
			NodoListaYo nodo = new NodoListaYo(l2.getDato());
			nodo.setSiguiente(fusionarListas(l1, l2.getSiguiente()));
			return nodo;
		} else {
			NodoListaYo nodo = new NodoListaYo(l1.getDato());
			NodoListaYo nodo2 = new NodoListaYo(l2.getDato());
			nodo.setSiguiente(nodo2);
			nodo2.setSiguiente(fusionarListas(l1.getSiguiente(), l2.getSiguiente()));
			return nodo;
		}

	}

	public static NodoListaYo crearLista(int... valores) {
		NodoListaYo cabeza = null;
		NodoListaYo ultimo = null;
		for (int v : valores) {
			NodoListaYo nuevo = new NodoListaYo(v);
			if (cabeza == null) {
				cabeza = nuevo;
			} else {
				ultimo.setSiguiente(nuevo);
			}
			ultimo = nuevo;
		}
		return cabeza;
	}

	public static String listaToString(NodoListaYo lista) {
		if (lista == null) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		NodoListaYo actual = lista;
		while (actual != null) {
			sb.append(actual.getDato());
			if (actual.getSiguiente() != null) {
				sb.append(", ");
			}
			actual = actual.getSiguiente();
		}
		return sb.append("]").toString();
	}

	private static void probar(String nombre, NodoListaYo l1, NodoListaYo l2, String esperado) {
		NodoListaYo resultado = fusionarListas(l1, l2);
		String obtenido = listaToString(resultado);
		System.out.println(nombre);
		System.out.println("  l1:        " + listaToString(l1));
		System.out.println("  l2:        " + listaToString(l2));
		System.out.println("  resultado: " + obtenido);
		System.out.println("  esperado:  " + esperado);
		System.out.println("  " + (obtenido.equals(esperado) ? "OK" : "FALLO"));
		System.out.println();
	}

	public static void main(String[] args) {
		// 1. Caso normal, intercaladas
		probar("Caso normal", crearLista(1, 3, 5), crearLista(2, 4, 6), "[1, 2, 3, 4, 5, 6]");

		// 2. Con valores duplicados entre ambas listas
		probar("Con duplicados entre listas", crearLista(1, 3, 5), crearLista(1, 3, 5), "[1, 1, 3, 3, 5, 5]");

		// 3. Distinto tamaño
		probar("Distinto tamaño", crearLista(1, 2), crearLista(3, 4, 5, 6, 7), "[1, 2, 3, 4, 5, 6, 7]");

		// 4. Una lista completamente menor que la otra
		probar("Una lista entera antes de la otra", crearLista(10, 20, 30), crearLista(1, 2, 3),
				"[1, 2, 3, 10, 20, 30]");

		// 5. Duplicados dentro de una misma lista
		probar("Duplicados dentro de una lista", crearLista(1, 1, 2), crearLista(1, 3), "[1, 1, 1, 2, 3]");

		// 6. Primera lista vacía
		probar("l1 vacía", null, crearLista(1, 2, 3), "[1, 2, 3]");

		// 7. Segunda lista vacía
		probar("l2 vacía", crearLista(1, 2, 3), null, "[1, 2, 3]");

		// 8. Ambas vacías
		probar("Ambas vacías", null, null, "[]");

		// 9. Un solo elemento cada una
		probar("Un elemento cada una", crearLista(5), crearLista(2), "[2, 5]");
	}
}
