package com.backjoon.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11266 단절점
public class Main11266 {
	
	static int V; // 1 <= V <= 10,000
	static int E; // 1 <= E <= 100,000
	
	static ArrayList[] GRAPH;
	static int ORDER[];
	static int COUNT;
	
	static boolean RESULT[];
	static int RESULT_COUNT;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new java.io.FileInputStream(new java.io.File("input/11266.txt"))));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		GRAPH = new ArrayList[V + 1];
		ORDER = new int[V + 1];
		COUNT = 0;
		RESULT = new boolean[V + 1];
		RESULT_COUNT = 0;
		
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
		
		//Util.print(GRAPH);
		
		getOrder(1, 0);
		
		bw.write(RESULT_COUNT + "\n");
		for (int i = 0; i < RESULT.length; i++) {
			if (RESULT[i]) {
				bw.write(i + " ");
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	static int getOrder(int node, int parent) {
		//System.out.printf("seek(%d, %d)\n", node, parent);
		COUNT++;
		ORDER[node] = COUNT;
		
		int childCount = 0;
		int result = COUNT;
		for (int i = 0; i < GRAPH[node].size(); i++) {
			int nextNode = (int)GRAPH[node].get(i);
			if (ORDER[nextNode] == 0) {
				childCount++;
				int returnValue = getOrder(nextNode, node);
				if (node != 1 && ORDER[node] <= returnValue && RESULT[node] == false) {
					RESULT[node] = true;
					RESULT_COUNT++;
				}
				result = Math.min(result, returnValue);
			}
			else if (nextNode != parent) {
				result = Math.min(result, ORDER[nextNode]);
			}
		}
		
		if (node == 1 && childCount > 1) {
			RESULT[node] = true;
			RESULT_COUNT++;
		}
		
		//`System.out.printf("seek(%d, %d) = %d, %d\n", node, parent, ORDER[node], result);
		return result;
	}
	
}