package com.hkg.test;

public class Main {

	public static void main(String[] args) {
		System.out.println(substringFunc("ABC"));
	}
	public static String substringFunc(String inputStri) {

		try{
			return inputStri.substring(1);
			
		}
		finally{
			return inputStri.substring(2); 
		}
	}


}
