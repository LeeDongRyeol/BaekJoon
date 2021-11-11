package sort;

/**
 * 	https://www.acmicpc.net/problem/10867
 *  중복 빼고 정렬하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P10867_SortNotWithDuplicate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		Set<Integer> set = new TreeSet<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(N-- > 0) set.add(Integer.parseInt(st.nextToken()));
		for(int n : set) System.out.print(n + " ");
	}
}
