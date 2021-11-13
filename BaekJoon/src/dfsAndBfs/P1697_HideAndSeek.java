package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author dr854
 *  https://www.acmicpc.net/problem/1697
 *  백준 1697번 숨바꼭질
 *  
 *  if(cur.loc < sister && moveVal < cur.loc) continue;
	if(cur.loc > sister && moveVal > cur.loc) continue;
	
	위의 로직을 제거하니 제대로 동작하였다.
 */

public class P1697_HideAndSeek {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pos subin = new Pos(sc.nextInt());
		int sister = sc.nextInt();
		boolean[] visit = new boolean[100001];
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(subin);
		visit[subin.loc] = true;
		
		int answer = 0;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			if(cur.loc == sister) {
				answer = cur.cnt;
				break;
			}
			
			for (int i = 1; i <= 3; i++) {
				int moveVal = move(cur.loc, i);
				
				if(moveVal > 100000 || moveVal < 0) continue;
				
				if(visit[moveVal]) continue;
				
				Pos temp = new Pos(moveVal, cur.cnt + 1);
				
//				System.out.println("출발 위치 : " + cur.loc + ", 옮긴 위치 : " + temp.loc + ", 카운트 : " + temp.cnt);
				
				visit[temp.loc] = true;
				
				q.add(temp);
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	public static int move(int pos, int idx) {
		int loc = pos;
		
		switch(idx) {
			case 1 : loc+=1; break;
			case 2 : loc-=1; break;
			case 3 : loc*=2; break;
		}
		
		return loc;
	}
	
	static class Pos {
		int loc, cnt;
		
		public Pos(int loc) {
			this.loc = loc;
			this.cnt = 0;
		}
		
		public Pos(int loc, int cnt) {
			this.loc = loc;
			this.cnt = cnt;
		}
	}
}


