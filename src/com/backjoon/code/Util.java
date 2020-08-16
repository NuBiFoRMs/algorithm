package com.backjoon.code;

public class Util {
	public static void print(int[] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i] + "\t");
		}
		System.out.println();
	}
	
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}