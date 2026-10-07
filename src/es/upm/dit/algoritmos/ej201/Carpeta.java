package es.upm.dit.algoritmos.ej201;

import java.util.ArrayList;
import java.util.List;

//Representa una carpeta que puede contener archivos y otras subcarpetas
public class Carpeta {
	private String nombre;
	private List<Archivo> archivos; // Archivos directos en esta carpeta
	private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta

	public Carpeta (String nombre) {
		this.nombre = nombre;
		this.archivos = new ArrayList<Archivo>();
		this.subcarpetas = new ArrayList<Carpeta>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Archivo> getArchivos() {
		return this.archivos;
	}

	public List<Carpeta> getSubcarpetas() {
		return this.subcarpetas;
	}

	public void addArchivo(Archivo archivo) {
		this.archivos.add(archivo);
	}

	public void addSubcarpeta(Carpeta subcarpeta) {
		this.subcarpetas.add(subcarpeta);
	}
	
	public double calcularPesoTotal() {
		double pesoTotal = 0;
		for (Archivo a : this.getArchivos()) {
			pesoTotal += a.getPesoMB();
		}
		for (Carpeta c : this.getSubcarpetas()) {
			pesoTotal += c.calcularPesoTotal();
		}
		return pesoTotal;
	}

	
}