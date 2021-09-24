package twoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author dyl1912
 *  https://www.acmicpc.net/problem/1644
 *  백준 1644번 소수의 연속합
 *  에라스토테네스의 체 + 투포인터 개념
 *  예외처리를 잘해줘야한다.
 *  입력값이 2일때, 1일때 처리를 잘해줘야함
 *  
 *  입력값이 1일때, list.get()을 하면 IndexOutOfBoundsException 뜸
 *  입력값이 2일때, solution 메서드에서 2번째 for문 rt 값이 1부터였는데, 0부터 돌게 해야한다.
 * 	2부터 소수의 시작이라서 n = 2 일때도 answer가 1이라는 결과가 나와야 한다.
 */

public class P1644_PrimeSeriesSum {
	public static void main(String[] args) {
		P1644_PrimeSeriesSum T = new P1644_PrimeSeriesSum();
		Scanner sc = new Scanner(System.in);
		System.out.println(T.solution(sc.nextInt()));
	}
	
	public static int solution(int n) {
		int answer = 0;
		int[] arr = new int[n+1];
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == 0) {
				for (int j = i; j < arr.length; j+=i) {
					arr[j] = 1;
				}
				list.add(i);
			}
		}
		
		int lt = 0, sum = list.size() > 0 ? list.get(lt) : 0;
		for (int rt = 0; rt < list.size(); rt++) {
			if(rt > 0) sum += list.get(rt);
			
			if(sum == n) answer++;
			while(sum >= n) {
				sum -= list.get(lt++);
				if(sum == n) answer++;
			}
		}
		
		return answer;
	}
}
