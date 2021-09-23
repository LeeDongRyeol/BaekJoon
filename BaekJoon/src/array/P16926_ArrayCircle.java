package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16926_ArrayCircle {
	public static void main(String[] args) throws IOException {
		Solution T = new Solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = stoi(st.nextToken()), m = stoi(st.nextToken()), r = stoi(st.nextToken());
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		int[][] sol = T.solution(n, m, r, arr);
		
		for (int i = 0; i < n; i++) {
			for(int j : sol[i]) bw.write(j + " ");
			bw.write("\n");
		}
		
		bw.flush();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}

class Solution {
	public int[][] solution(int n, int m, int r, int[][] arr) {
		
		// 기준 : 행인지 열인지
		// 둘중 하나 짝수인 것으로 
		
		int n_2 = n / 2, m_2 = m / 2;
		
		boolean tf = false;	// n이 짝수 일때, 행기준 : true, m이 짝수일 때, 열기준 : false 
		if(n == n_2 *2) tf = true;
		else if(m == m_2 * 2) tf = false;
		
		for (int i = 0; i < r; i++) {
			arr = circulate(tf, n, m, arr);
		}
		
		return arr;
	}
	
	public int[][] circulate(boolean tf, int n, int m, int[][] arr) {
		int[][] temp = new int[n][m];
		
		
		
		return arr;
	}
	
	
}
