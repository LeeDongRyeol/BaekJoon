package dfsAndBfs;

/**
 *  https://www.acmicpc.net/problem/2644
 *  백준 2644번 촌수계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2644_CalculateDegreeOfKinship {
	static int[][] family;
	static boolean[] check;
	static int answer, n, m;
	static boolean find;
	
	public static void dfs(int man1, int man2, int cnt) {
		check[man1] = true; 
		
		if(man1 == man2) {
			find = true;
			answer = cnt;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!check[i] && family[man1][i] == 1) {
				check[i] = true;
				dfs(i, man2, cnt+1);
				check[i] = false;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		
		family = new int[n][n];
		check = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int man1 = stoi(st.nextToken())-1, man2 = stoi(st.nextToken())-1;
		
		m = stoi(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = stoi(st.nextToken()) - 1;
			int second = stoi(st.nextToken()) - 1;
			
			family[first][second] = 1;
			family[second][first] = 1;
		}
		
		dfs(man1, man2, 0);
		
		if(!find) answer = -1;
		System.out.println(answer);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
