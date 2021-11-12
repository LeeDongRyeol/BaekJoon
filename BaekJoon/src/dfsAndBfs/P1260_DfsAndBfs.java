package dfsAndBfs;

/**
 *  https://www.acmicpc.net/problem/1260
 *  백준 1260번 DFS와 BFS
 *  이 문제도 인접행렬을 이용하여 풀면 쉽게 풀린다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_DfsAndBfs {
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = stoi(st.nextToken()), m = stoi(st.nextToken()), v = stoi(st.nextToken()) - 1;
		
		map = new int[n][n];
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = stoi(st.nextToken()) - 1;
			int e = stoi(st.nextToken()) - 1;
			
			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		visit = new boolean[n];
		dfs(v);
		System.out.println();
		visit = new boolean[n];
		bfs(v);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static void dfs(int v) {
		visit[v] = true;
		System.out.print((v+1) + " ");
		
		for (int i = 0; i < map[v].length; i++) {
			if(map[v][i] == 1 && !visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visit[v] = true;
		
		String answer = (v + 1) + " ";
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < map[cur].length; i++) {
				if(map[cur][i] == 1 && !visit[i]) {
					answer += (i+1) + " ";
					visit[i] = true;
					q.add(i);
				}
			}
		}
		
		System.out.println(answer);
	}
}
