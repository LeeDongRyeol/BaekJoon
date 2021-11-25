package dfsAndBfs;

/**
 * https://www.acmicpc.net/problem/2573
 * 백준 2573번 빙산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2573_Glacier {
	static int n, m, year, cnt = 1;
	static int[][] map, seas;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		init();

		int cir = 0;
		
		while(true) {
			seas = new int[n][m];
			visit = new boolean[n][m];
			cir = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(!visit[i][j] && map[i][j] != 0) {
						dfs(i, j);
						cir++;
					}
				}
			}
			
			// 빙하 영역을 계산된 영역으로 교체
			map = seas;
			year++;
			
			// 두덩이 이상으로 분리되지 않으면 0으로 출력
			if(cir == 0) {
				year = 0;
				break;
			} else if(cir > 1) {
				year-=1;
				break;
			}
		}

		System.out.println(year);
	}
	
	public static void dfs(int y, int x) {
		if(map[y][x] == 0 || visit[y][x]) return;		
		
		int sea = 0;

		// 방향 조사 후 바다의 갯수 계산
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(checkRange(ny, nx)) continue;
			if(map[ny][nx] == 0) sea++;
		}

		// 빙하가 녹기 전의 값과 바다의 갯수 계산
		int val = map[y][x] - sea;
		seas[y][x] = val >= 0 ? val : 0;
		
		// 다음 영역으로 dfs 탐색을 이용하여 이동한다.
		visit[y][x] = true;
		
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (checkRange(ny, nx) || visit[ny][nx] || map[ny][nx] == 0) continue;
			dfs(ny, nx);
		}
	}

	// 모든 값을 초기화하는 함수
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
	}

	// 유효한 범위 체크하는 함수
	public static boolean checkRange(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}