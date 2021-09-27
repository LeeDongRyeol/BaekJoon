package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author dyl1912
 * https://www.acmicpc.net/problem/3273
 * 백준 3273번: 두 수의 합
 */

public class P3273_TwoNumSum {
	public static void main(String[] args) {
		P3273_TwoNumSum T = new P3273_TwoNumSum();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		System.out.println(T.solution(n, arr, x));
	}
	
	public static int solution(int n, int[] arr, int x) {
		int cnt = 0;
		Arrays.sort(arr);
		int lt = 0;
		int rt = n-1;
		while(lt < rt) {
			if(arr[lt] + arr[rt] == x) {
				cnt++;
				lt++;
			} else if(arr[lt] + arr[rt] > x) {
				rt--;
			} else lt++;
		}
		
		return cnt;
	}
}
