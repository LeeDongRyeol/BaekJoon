package backTracking;
/**
 *  https://www.acmicpc.net/problem/1759
 *  백준 1759번 암호 만들기
 */

import java.util.Arrays;
import java.util.Scanner;

public class P1759_MakePassword {
	static int l, c;
	static char[] arr, chArr, moum = {'a', 'e', 'i', 'o', 'u'};
	static boolean[] check;
	
	public static void dfs(int cir) {
		if(cir == l) {
			String temp = "";
			boolean find = false;
			for(char ch : chArr) temp += ch;
			
			for (int i = 0; i < 5; i++) {
				String str = moum[i] + "";
				if(temp.contains(str)) find = true;
				temp = temp.replace(str, "");
			}
			
			if(!find || temp.length() < 2) return;
			
			for(char ch : chArr) System.out.print(ch);
			
			System.out.println();
		} else {
			for (int i = 0; i < c; i++) {
				if(!check[i]) {
					if(cir > 0 && chArr[cir-1] > arr[i]) continue;
					check[i] = true;
					chArr[cir] = arr[i];
					dfs(cir + 1);
					check[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt(); c = sc.nextInt();
		arr = new char[c]; check = new boolean[c]; chArr = new char[l];
		
		for (int i = 0; i < c; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0);
		sc.close();
	}
}
