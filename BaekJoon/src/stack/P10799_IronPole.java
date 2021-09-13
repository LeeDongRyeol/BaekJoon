package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author dyl1912
 *
 * 백준 : 10799번 쇠막대기
 * https://www.acmicpc.net/problem/10799
 */

public class P10799_IronPole {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int cnt = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') stack.push(ch);
			else {
				if(!stack.isEmpty()) stack.pop();
				
				if(str.charAt(i-1) == '(') cnt += stack.size();
				else cnt += 1;
			}
		}
		
		System.out.println(cnt);
	}
}
