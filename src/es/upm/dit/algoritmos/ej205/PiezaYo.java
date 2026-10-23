package es.upm.dit.algoritmos.ej205;

import java.util.ArrayList;
import java.util.List;

public class PiezaYo {
	private String nombre;
	private boolean esDefectuosa;
	private List<PiezaYo> componentes; // Piezas necesarias para montar esta

	public PiezaYo(String nombre, boolean esDefectuosa) {
		this.nombre = nombre;
		this.esDefectuosa = esDefectuosa;
		this.componentes = new ArrayList<PiezaYo>();
	}

	public boolean isDefectuosa() {
		return this.esDefectuosa;
	}

	public List<PiezaYo> getComponentes() {
		return this.componentes;
	}

	public void addComponente(PiezaYo componente) {
		this.componentes.add(componente);
	}

	/*
	 * Implemente el método recursivo contieneDefectos: Devuelve true si la
	 * piezaPrincipal o cualquiera de sus componentes (en cualquier nivel de
	 * profundidad) está marcado como defectuoso. Si todas las piezas están bien,
	 * devuelve false.
	 */
	public static boolean contieneDefectos(PiezaYo piezaPrincipal) {

		if (piezaPrincipal == null) {
			return false;
		}
		if (piezaPrincipal.isDefectuosa()) {
			return true;
		}
		boolean conDefectos = false;
		if (piezaPrincipal.getComponentes() != null) {
			for (PiezaYo e : piezaPrincipal.getComponentes()) {
				conDefectos = contieneDefectos(e);
				if (conDefectos) {
					break; //return true
				}
			}
		}
		return conDefectos;
	}

	public static void main(String[] args) {
		System.out.println("--- PRUEBAS PARA contieneDefectos ---\n");

		// Test 1: Pieza principal nula (debería dar false)
		boolean test1 = contieneDefectos(null);
		System.out.println("Test 1 (Pieza nula) - Esperado: false | Resultado: " + test1);

		// Test 2: Árbol donde ninguna pieza es defectuosa (debería dar false)
		// Estructura: Principal (OK) -> Sub1 (OK), Sub2 (OK)
		PiezaYo principal2 = new PiezaYo("Principal", false);
		PiezaYo sub2_1 = new PiezaYo("Sub1", false);
		PiezaYo sub2_2 = new PiezaYo("Sub2", false);
		principal2.addComponente(sub2_1);
		principal2.addComponente(sub2_2);

		boolean test2 = contieneDefectos(principal2);
		System.out.println("Test 2 (Todo bien) - Esperado: false | Resultado: " + test2);

		// Test 3: La pieza principal es defectuosa directamente (debería dar true)
		PiezaYo principal3 = new PiezaYo("Principal", true);
		boolean test3 = contieneDefectos(principal3);
		System.out.println("Test 3 (Principal defectuosa) - Esperado: true | Resultado: " + test3);

		// Test 4: Un componente interno profundo es defectuoso (debería dar true)
		// Estructura: Principal (OK) -> SubA (OK) -> SubSubA (DEFECTUOSA)
		PiezaYo principal4 = new PiezaYo("Principal", false);
		PiezaYo subA = new PiezaYo("SubA", false);
		PiezaYo subSubA = new PiezaYo("SubSubA", true);

		principal4.addComponente(subA);
		subA.addComponente(subSubA);

		boolean test4 = contieneDefectos(principal4);
		System.out.println("Test 4 (Defecto en profundidad) - Esperado: true | Resultado: " + test4);

		// Creamos la pieza principal sin defectos
		PiezaYo principal = new PiezaYo("Principal", false);

		// Creamos dos componentes directos:
		// 1. El primero es defectuoso
		// 2. El segundo está bien
		PiezaYo compDefectuosa = new PiezaYo("Comp1 (Defectuosa)", true);
		PiezaYo compBien = new PiezaYo("Comp2 (Bien)", false);

		// Los añadimos en este orden exacto
		principal.addComponente(compDefectuosa);
		principal.addComponente(compBien);

		// Ejecutamos el método
		boolean resultado = contieneDefectos(principal);

		System.out.println("--- PRUEBA DELATORA ---");
		System.out.println("¿Debería tener defectos? Esperado: true");
		System.out.println("Lo que devuelve tu método: " + resultado);

		// Creamos la pieza principal sin defectos
		principal = new PiezaYo("Principal", false);

		// Creamos dos componentes en este orden:
		// 1. El PRIMERO está bien (OK)
		// 2. El SEGUNDO es defectuoso (DEFECTUOSA)
		PiezaYo compPrimeroBien = new PiezaYo("Comp1 (Bien)", false);
		PiezaYo compSegundoDefectuoso = new PiezaYo("Comp2 (Defectuosa)", true);

		principal.addComponente(compPrimeroBien);
		principal.addComponente(compSegundoDefectuoso);

		// Ejecutamos el método
		resultado = contieneDefectos(principal);

		System.out.println("--- PRUEBA DELATORA ---");
		System.out.println("¿Debería tener defectos el conjunto? Esperado: true");
		System.out.println("Lo que devuelve tu método: " + resultado);

	}
}
