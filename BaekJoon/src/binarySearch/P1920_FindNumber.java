package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author dyl1912
 * https://www.acmicpc.net/problem/1920
 * 백준 1920번 수 찾기(이분탐색)
 */

public class P1920_FindNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arrN = new int[n];
		for (int i = 0; i < n; i++) {
			arrN[i] = sc.nextInt();
		}
		Arrays.sort(arrN);
		
		int m = sc.nextInt();
		int[] arrM = new int[m];
		for (int i = 0; i < m; i++) {
			arrM[i] = sc.nextInt();
		}
		
		for(int k : arrM) {
			int lt = 0;
			int rt = n - 1;
			
			boolean find = false;
			
			while(lt <= rt) {
				int mid = (lt + rt) / 2;
				if(k == arrN[mid]) {
					System.out.println(1);
					find = true;
					break;
				} else if(k > arrN[mid]) {
					lt = mid + 1;
				} else rt = mid - 1;
			}
			
			if(!find) System.out.println(0);
		}
	}
}
