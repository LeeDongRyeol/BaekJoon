package dfsAndBfs;

/**
 * https://www.acmicpc.net/problem/5014
 * 백준 5014번 스타트링크
 * 
 * 범위 확인하는 과정에서 
 * floor < 1 대신
 * floor < 0을 써서 삽질한 문제
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5014_StartLink {
	static int f, s, g, u, d, num;
	static boolean[] check;
	static int[] arr = new int[2];
	static boolean find;
	
	public static void bfs(int floor, int cnt) {
		Floor F = new Floor(floor, cnt);
		Queue<Floor> q = new LinkedList<Floor>();
		q.add(F);
		check[floor] = true;
		
		while(!q.isEmpty()) {
			Floor cur = q.poll();
			
			if(cur.floor == g) {
				find = true;
				num = cur.cnt;
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int df = cur.floor + arr[i];
				if(checkFloor(df) || check[df]) continue;

				check[df] = true;
				q.add(new Floor(df, cur.cnt + 1));
			}
			
		}
	}
	
	static class Floor {
		int floor, cnt;
		
		public Floor(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt(); s = sc.nextInt(); g = sc.nextInt(); u = sc.nextInt(); d = sc.nextInt();
		check = new boolean[f+1];	
		String answer = "";
		arr[0] = u; arr[1] = d*-1;
		
		bfs(s, 0);
		answer += find ? num : "use the stairs";
		System.out.println(answer);
		sc.close();
	}
	
	public static boolean checkFloor(int floor) {
		return floor < 1 || floor > f;
	}
}
