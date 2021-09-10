package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author dyl1912
 *
 * 백준 : 1806번 부분합
 * https://www.acmicpc.net/problem/1806
 */

public class PartSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = stoi(st.nextToken());
		int S = stoi(st.nextToken());
		int min = Integer.MAX_VALUE;

		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		int lt = 0, sum = 0, len = 0;
		for (int rt = 0; rt < N; rt++) {
			sum += arr[rt];
			len++;
			if(len > 1) {
				while(sum >= S) {
					min = Math.min(min, len);
					sum -= arr[lt++];
					len--;
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) min = 0;
		System.out.println(min);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
