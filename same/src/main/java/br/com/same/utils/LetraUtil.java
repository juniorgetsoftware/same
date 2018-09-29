package br.com.same.utils;

public class LetraUtil {

	private static char[] alfabeto = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static char letraPorIndice(int indice) {
		return alfabeto[indice];
	}
}
