package com.backjoon.code;

import java.util.ArrayList;

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
	
	public static void print(ArrayList[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.printf("[%2d] ", i);
			for (int j = 0; j < list[i].size(); j++) {
				if (j == 0) {
					System.out.printf("%2d", list[i].get(j));
				}
				else {
					System.out.printf(", %2d", list[i].get(j));
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}