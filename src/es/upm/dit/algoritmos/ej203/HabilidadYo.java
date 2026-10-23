package es.upm.dit.algoritmos.ej203;

import java.util.ArrayList;
import java.util.List;

public class HabilidadYo {

	private String id;
	private int costePuntos; // Coste para desbloquear esta habilidad
	private List<HabilidadYo> desbloqueables; // Habilidades que dependen de esta

	/*
	 * Un videojuego organiza las habilidades de sus personajes en un árbol de
	 * dependencias, de tal manera que para poder desbloquear una habilidad primero
	 * se deben tener las anteriores, además de una serie de puntos.
	 */
	public HabilidadYo(String id, int costePuntos) {
		this.id = id;
		this.costePuntos = costePuntos;
		this.desbloqueables = new ArrayList<HabilidadYo>();
	}

	public int getCoste() {
		return this.costePuntos;
	}

	public List<HabilidadYo> getDesbloqueables() {
		return this.desbloqueables;
	}

	public void addDesbloqueables(HabilidadYo desbloqueable) {
		this.desbloqueables.add(desbloqueable);
	}

	/*
	 * Implemente el método recursivo costeRamaCompleta, que calcula cuántos puntos
	 * totales hacen falta para desbloquear la habilidad raíz y todas las
	 * habilidades que descienden de ella en el árbol (es decir, la rama completa).
	 */
	public static int costeRamaCompleta(HabilidadYo raiz) {
		if (raiz == null) {
			return -1;
		}
		int costeTotal = raiz.getCoste();
		if (raiz.getDesbloqueables() != null) {
			for (HabilidadYo h : raiz.getDesbloqueables()) {
				costeTotal += costeRamaCompleta(h);
			}
		}
		return costeTotal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
