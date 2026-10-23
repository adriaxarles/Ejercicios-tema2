package es.upm.dit.algoritmos.ej206;

public class PalindromoYo {

	/*
	 * Escriba un método recursivo esPalindromo(String texto) que devuelva true si
	 * la cadena texto es un palíndromo (se lee igual al derecho y al revés) y false
	 * en caso contrario. Asuma que el texto no contiene espacios en blanco y que
	 * todos los caracteres están en minúsculas.
	 * 
	 * Si necesita ayuda: El caso base es una cadena de longitud 0 o 1. El caso
	 * recursivo compara el primer y último carácter y llama a la función con la
	 * subcadena interior.
	 */
	public static boolean esPalindromoYo(String texto) {
		if (texto == null) {
			return false;
		}
		if (texto.length() == 1 || texto.length() == 0) {
			return true;
		}
		if (texto.charAt(0) != texto.charAt(texto.length() - 1)) {
			return false;
		}

		return esPalindromoYo(texto.substring(1, texto.length() - 1));
	}

	public static void main(String[] args) {
		boolean palindromo = esPalindromoYo("holaaloh");
		System.out.println(palindromo);
	}

}
