package dfsAndBfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P6539_SangBumBuilding {
	
	static char[][][] map;
	static boolean[][][] visit;
	static int l = 0, r = 0, c = 0, min = Integer.MAX_VALUE;
	static int[] dy = {1, 0, -1, 0, 0, 0};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static Queue<Pos> q;
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			l = stoi(st.nextToken()); 
			r = stoi(st.nextToken()); 
			c = stoi(st.nextToken());
			
			if(l == 0 && r == 0 && c == 0) break;
			
			map = new char[l][r][c];
			visit = new boolean[l][r][c];
			q = new LinkedList<Pos>();
			min = 0;
			
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					
					for (int k = 0; k < c; k++) {
						map[i][j][k] = str.charAt(k);
						if(str.charAt(k) == 'S') {
							q.add(new Pos(i, j, k, 0));
							visit[i][j][k] = true;
						}
					}
					
				}
				
				br.readLine();
			}
			
			if(isFind()) bw.write("Escaped in " + min + " minute(s).\n");
			else bw.write("Trapped!\n");
		}
		
		bw.flush();
	}
	
	public static boolean isFind() {
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nh = dh[i] + cur.h;
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;
				
				if(checkRange(ny, nx, nh) || visit[nh][ny][nx] || map[nh][ny][nx] == '#') continue;
				
				visit[nh][ny][nx] = true;
				int cnt = cur.cnt + 1;
				
				if(map[nh][ny][nx] == 'E') {
					min = cnt;
					return true;
				}
				
				q.add(new Pos(nh, ny, nx, cnt));
			}
		}
		
		return false;
	}
	
	public static boolean checkRange(int y, int x, int h) {
		return y < 0 || y >= r || x < 0 || x >= c || h < 0 || h >= l;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	static class Pos {
		int y, x, h, cnt;
		
		public Pos(int h, int y, int x, int cnt) {
			this.h = h;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}