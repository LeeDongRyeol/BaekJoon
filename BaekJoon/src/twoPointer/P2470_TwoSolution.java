package twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @author dyl1912
 *
 *  https://www.acmicpc.net/problem/2470
 *  백준 2470반 두 용액
 * 
 *  Arrays.sort()를 안쓰고 Collections.sort()를 쓴 이유는
 *  Arrays.sort()는 퀵소트 기반으로 정렬을 하는데 최악의 경우 O(n^2)으로 정렬을 하고
 *  Collections.sort()의 경우는 O(NlogN)을 보장하기 때문이다.
 *  
 *  그리고 sum이 0보다 작거나 클때 비교 외에도 sum 값이 0이면 break를 해주어야 한다.
 */

public class P2470_TwoSolution {
	public static void main(String[] args) throws IOException {
		P2470_TwoSolution T = new P2470_TwoSolution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = stoi(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(stoi(st.nextToken()));
		}
		
		int[] answer = T.solution(list, n);
		bw.write(answer[0] + " " + answer[1]);
		bw.flush();
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static int[] solution(ArrayList<Integer> list, int n) {
		int[] answer = new int[2];
		
		Collections.sort(list);
		
		int num = Integer.MAX_VALUE;
		int lt = 0, rt = n-1;
		while(lt < rt) {
			int sum = list.get(lt) + list.get(rt);
			
			if(num > Math.abs(sum)) {
				num = Math.abs(sum);
				answer[0] = list.get(lt);
				answer[1] = list.get(rt);
			}
			
			if(sum > 0) rt--;
			else if(sum < 0) lt++;
			else break;
		}
		
		return answer;
	}
}
