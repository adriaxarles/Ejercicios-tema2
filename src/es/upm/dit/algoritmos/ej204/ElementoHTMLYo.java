package es.upm.dit.algoritmos.ej204;

import java.util.ArrayList;
import java.util.List;

public class ElementoHTMLYo {

	private String tag; // Ejemplo: "div", "p", "img"
	private List<ElementoHTMLYo> hijos;

	public ElementoHTMLYo(String tag) {
		this.tag = tag;
		this.hijos = new ArrayList<ElementoHTMLYo>();
	}

	public String getTag() {
		return this.tag;
	}

	public List<ElementoHTMLYo> getHijos() {
		return this.hijos;
	}

	public void addHijo(ElementoHTMLYo hijo) {
		this.hijos.add(hijo);
	}

	/*
	 * Implemente el método recursivo contarEtiquetas. Este método devuelve un
	 * entero indicando cuántas veces aparece una etiqueta específica (tagBuscado)
	 * dentro del árbol que comienza en elemento.
	 */

	public static int contarEtiquetas(ElementoHTMLYo elemento, String tagBuscado) {
		if (elemento == null) {
			return -1;
		}
		int numEtiquetas = 0;

		if (elemento.getTag() == tagBuscado) {
			numEtiquetas++;
		}

		if (elemento.getHijos() != null) {
			for (ElementoHTMLYo e : elemento.getHijos()) {
				numEtiquetas += contarEtiquetas(e, tagBuscado);
			}
		}

		return numEtiquetas;
	}

	public static void main(String[] args) {
		// Construimos un árbol HTML de prueba:
		// <div>
		// <p>Texto 1</p>
		// <div>
		// <p>Texto 2</p>
		// <p>Texto 3</p>
		// </div>
		// <img>
		// </div>

		ElementoHTMLYo raiz = new ElementoHTMLYo("div");

		ElementoHTMLYo p1 = new ElementoHTMLYo("p");
		ElementoHTMLYo divHijo = new ElementoHTMLYo("div");
		ElementoHTMLYo img = new ElementoHTMLYo("img");

		raiz.addHijo(p1);
		raiz.addHijo(divHijo);
		raiz.addHijo(img);

		divHijo.addHijo(new ElementoHTMLYo("p"));
		divHijo.addHijo(new ElementoHTMLYo("p"));

		// Pruebas de conteo
		String buscar1 = "p";
		int resultadoP = contarEtiquetas(raiz, buscar1);
		System.out.println("Buscando <" + buscar1 + "> (Esperado: 3): " + resultadoP);

		String buscar2 = "div";
		int resultadoDiv = contarEtiquetas(raiz, buscar2);
		System.out.println("Buscando <" + buscar2 + "> (Esperado: 2): " + resultadoDiv);
	}

}
