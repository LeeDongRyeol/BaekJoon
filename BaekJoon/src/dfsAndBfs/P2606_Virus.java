package dfsAndBfs;

/***
 * 	https://www.acmicpc.net/problem/2606
 *  백준 2606번 바이러스
 *  
 *  1. 인접행렬을 이용한다.
 *  입력이
 *  1 2
	2 3
	1 5
	5 2
	5 6
	4 7  
	
	이라면,
	
	0 1 0 0 1 0 0
	1 0 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 0 1
	1 1 0 0 0 1 0
	0 0 0 0 1 0 0
	0 0 0 1 0 0 0
	와 같은 방식으로 인접행렬을 만들 수 있다
	
	2. 큐를 이용해서 BFS 탐색을 한다.
	 - 행렬의 값이 1이고, 방문하지 않은 노드라면 cnt의 값을 증가시킨다.
	
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2606_Virus {
	static int[][] map;			// 인접행렬을 만들기 위한 변수
	static boolean[] visit;		// 방문한 컴퓨터를 체크하기 위한 로직
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = stoi(br.readLine());
		int line = stoi(br.readLine());
		
		map = new int[com][com];
		visit = new boolean[com];
		
		while(line-- > 0) {
			String[] spots = br.readLine().split(" ");
			int first = stoi(spots[0]) - 1;
			int second = stoi(spots[1]) - 1;
			
			map[first][second] = 1;
			map[second][first] = 1;
		}
		
		int idx = 0, cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(idx);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < map[cur].length; i++) {
				if(map[cur][i] == 1 && !visit[i]) {
					if(i != 0) cnt++;
					visit[i] = true;
					q.add(i);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
