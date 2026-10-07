package es.upm.dit.algoritmos.ej202;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoYo {
	private String nombre;
	private double salario;
	private List<EmpleadoYo> subordinados; // Lista de empleados a su cargo

	public EmpleadoYo(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
		this.subordinados = new ArrayList<EmpleadoYo>();
	}

	public String getNombre() {
		return nombre;
	}

	public double getSalario() {
		return this.salario;
	}

	public List<EmpleadoYo> getSubordinados() {
		return this.subordinados;
	}

	public void addSubordinado(EmpleadoYo subordinado) {
		this.subordinados.add(subordinado);
	}

	/*
	 * Implemente el método recursivo presupuestoEquipo: Este método debe calcular
	 * el coste total de salarios de un equipo, incluyendo el salario del Empleado
	 * pasado como parámetro y el de todos sus subordinados (directos e indirectos).
	 */

	public static double presupuestoEquipo(EmpleadoYo jefe) {
		if (jefe == null) {
			return 0.0;
		}
		double salarioTotal = jefe.getSalario();
		if (jefe.getSubordinados() != null) {
			for (EmpleadoYo e : jefe.getSubordinados()) {
				salarioTotal += presupuestoEquipo(e);
			}
		}
		return salarioTotal;
	}
}
