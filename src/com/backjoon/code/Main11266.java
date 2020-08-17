package com.backjoon.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11266 단절점
public class Main11266 {
	
	static int V; // 1 <= V <= 10,000
	static int E; // 1 <= E <= 100,000
	
	static ArrayList[] GRAPH;
	static boolean VISITED[];
	static int COUNT;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new java.io.FileInputStream(new java.io.File("input/11266.txt"))));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		GRAPH = new ArrayList[V + 1];
		VISITED = new boolean[V + 1];
		COUNT = 0;
		
		for (int i = 0; i < GRAPH.length; i++) {
			GRAPH[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < E; i ++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			
			GRAPH[nodeA].add(nodeB);
			GRAPH[nodeB].add(nodeA);
		}
		
		Util.print(GRAPH);
		
		seek(1, 0);
		
		br.close();
	}
	
	static int seek(int node, int parent) {
		System.out.printf("seek(%d, %d)\n", node, parent);
		VISITED[node] = true;
		COUNT++;
		
		for (int i = 0; i < GRAPH[node].size(); i++) {
			int nextNode = (int)GRAPH[node].get(i);
			if (VISITED[nextNode] == false) {
				seek(nextNode, node);
			}
		}
		
		return COUNT;
	}
	
}