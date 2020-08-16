package com.backjoon.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3584 가장 가까운 공통 조상
public class Main3584 {
	
	static int T;
	static int N; // 2 <= N <= 10,000
	
	static int K;
	static int P[][];
	static int D[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new java.io.FileInputStream(new java.io.File("input/3584.txt"))));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			K = getOverDegree(N - 1);
			P = new int[K + 1][N + 1];
			D = new int[N + 1];
			
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				P[0][child] = parent;
			}
			
			for (int i = 0; i <= N; i++) {
				D[i] = -1;
			}
			
			makeDP(P);
			
			//Util.print(P);
			
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			
			System.out.println(getLCA(nodeA, nodeB));
		}
		
		br.close();
	}
	
	static int getLCA(int nodeA, int nodeB) {
		int depthNodeA = getDepth(nodeA);
		int depthNodeB = getDepth(nodeB);
		int diff = depthNodeA - depthNodeB;
		
		if (diff > 0)
			nodeA = getParent(nodeA, Math.abs(diff));
		else if (diff < 0)
			nodeB = getParent(nodeB, Math.abs(diff));
		
		while (nodeA != nodeB) {
			for (int i = 0; i < P.length - 1; i++) {
				if (P[i + 1][nodeA] == 0) {
					nodeA = P[i][nodeA];
					nodeB = P[i][nodeB];
					break;
				}
				else if (P[i + 1][nodeA] == P[i + 1][nodeB]) {
					nodeA = P[i][nodeA];
					nodeB = P[i][nodeB];
					break;
				}
			}
		}
		
		return nodeA;
	}
	
	static int getParent(int node, int depth) {
		//System.out.println("getParent(" + node + ", " + depth + ")");
		if (depth == 0) return node;
		
		int degree = getUnderDegree(depth);
		return getParent(P[degree][node], depth - (1 << degree));
	}
	
	static int getDepth(int node) {
		//System.out.println("getDepth(" + node + ")");
		if (node == 0) return 0;
		
		if (D[node] != -1) return D[node];
		
		int degree = 0;
		for (int i = 0; i < P.length - 1; i++) {
			if (P[i + 1][node] == 0) {
				degree = i;
				break;
			}
		}
		
		int depth = 1 << degree;
		return D[node] = depth + getDepth(P[degree][node]);
	}
	
	static void makeDP(int[][] p) {
		for (int i = 1; i < p.length; i++) {
			for (int j = 1; j < p[i].length; j++) {
				p[i][j] = p[i - 1][p[i - 1][j]];
			}
		}
	}
	
	static int getOverDegree(int value) {
		int degree = 0;
		int overValue = 1 << degree;
		while (value >= overValue) {
			degree++;
			overValue = 1 << degree;
		}
		return degree;
	}
	
	static int getUnderDegree(int value) {
		return getOverDegree(value) - 1;
	}
	
}