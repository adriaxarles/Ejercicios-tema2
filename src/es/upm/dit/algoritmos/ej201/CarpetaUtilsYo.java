package es.upm.dit.algoritmos.ej201;

public class CarpetaUtilsYo {
	/*
	 * Implemente el método recursivo calcularPesoTotal: Este método debe devolver
	 * la suma total del peso (en MB) de una Carpeta y todo su contenido (archivos
	 * directos y archivos dentro de subcarpetas, recursivamente).
	 */

	public static double calcularPesoTotal(Carpeta inicio) {
		double pesoTotal = 0;
		for (Archivo a : inicio.getArchivos()) {
			pesoTotal += a.getPesoMB();
		}
		for (Carpeta c : inicio.getSubcarpetas()) {
			pesoTotal += calcularPesoTotal(c);
		}
		return pesoTotal;
	}

	// no tiene ningun sentido hacerlo asi
	// al no acceder a ningun atributo de la clase
	// mucho mejor hacerlo static
	public double calcularPesoTotal2(Carpeta inicio) { 
		double pesoTotal = 0;

		for (Archivo a : inicio.getArchivos()) {
			pesoTotal += a.getPesoMB();
		}
		for (Carpeta c : inicio.getSubcarpetas()) {
			pesoTotal += (new CarpetaUtilsYo()).calcularPesoTotal2(c);
		}
		return pesoTotal;
	}

	public static void main(String[] args) {
		Carpeta a = new Carpeta("A");
		a.addArchivo(new Archivo("A1", 5.0));
		a.addArchivo(new Archivo("A2", 1.0));
		Carpeta b = new Carpeta("B");
		b.addArchivo(new Archivo("B1", 2.0));
		b.addArchivo(new Archivo("B2", 3.0));
		b.addArchivo(new Archivo("B3", 4.0));
		Carpeta c = new Carpeta("C");
		c.addArchivo(new Archivo("C1", 2.0));
		Carpeta d = new Carpeta("D");
		d.addArchivo(new Archivo("D1", 5.0));
		d.addArchivo(new Archivo("D2", 2.0));

		b.addSubcarpeta(c);
		a.addSubcarpeta(b);
		a.addSubcarpeta(d);

		System.out.println("El tamaño de c es: " + calcularPesoTotal(c));
		System.out.println("El tamaño de a es: " + calcularPesoTotal(a));
		System.out.println("El tamaño de b es: " + calcularPesoTotal(b));
		System.out.println("El tamaño de d es: " + calcularPesoTotal(d));
	}
}
