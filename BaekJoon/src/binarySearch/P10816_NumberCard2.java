package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author dyl1912
 * https://www.acmicpc.net/problem/10816
 * 백준 10816 숫자 카드2 이분탐색
 */

public class P10816_NumberCard2 {
	public static void main(String[] args) throws IOException {
		P10816_NumberCard2 T = new P10816_NumberCard2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = stoi(br.readLine());
		int[] card = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			card[i] = stoi(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int m = stoi(br.readLine());
		int[] arr = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			arr[i] = stoi(st.nextToken());
			
			int idx = returnRt(card, arr[i]) - returnLt(card, arr[i]);
			bw.write(idx + " ");
		}
		
		bw.flush();
	}
	
	public static int returnLt(int[] card, int key) {
		int lt = 0;
		int rt = card.length;
		
		while(lt < rt) {
			int mid = (lt + rt) / 2;
			if(key <= card[mid]) {
				rt = mid;
			} else lt = mid + 1;
		}
		
		return lt;
	}
	
	public static int returnRt(int[] card, int key) {
		int lt = 0;
		int rt = card.length;
		
		while(lt < rt) {
			int mid = (lt + rt) / 2;
			if(key < card[mid]) {
				rt = mid;
			} else lt = mid + 1;
		}
		
		return rt;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
