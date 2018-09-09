package br.com.same.dao.utils;

public class Like {
	
	private Like() {}
	
	public static String endswith(String param) {
		return "%" + param;
	}

	public static String startswith(Object param) {
		return param +"%";
	}

	public static String anywhere(String param) {
		return "%" + param +"%";
	}

}
