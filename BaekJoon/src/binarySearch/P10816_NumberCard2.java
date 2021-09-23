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
		}
		
		for(int x : T.solution(card, n, arr, m)) {
			bw.write(x + " ");
		}
		
		bw.flush();
	}
	
	public static int[] solution(int[] card, int n, int[] arr, int m) {
		int[] answer = new int[m];
		
		for (int i = 0; i < m; i++) {
			int lt = 0, rt = n - 1;
			int num = arr[i];
			
			while(lt <= rt) {
				int mid = (lt + rt) / 2;
				if(num == card[mid]) {
					answer[i] = count(card, num);
					break;
				} else if(num > card[mid]) lt = mid + 1;
				else rt = mid - 1;
			}
		}
		
		return answer;
	}
	
	public static int count(int[] card, int num) {
		int cnt = Arrays.asList(card, num).size();
		
//		int cnt = 0;
//		
//		for(int x : card) {
//			if(x == num) cnt++;
//		}
		
		return cnt;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
