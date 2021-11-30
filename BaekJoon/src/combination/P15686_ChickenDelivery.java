package combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15686_ChickenDelivery {
	static int[][] map;
	static int[] check;
	static int n, m, len, answer = Integer.MAX_VALUE;
	static List<Point> chicken = new ArrayList<Point>();
	static List<Point> home = new ArrayList<Point>();
	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) {
		init();
		combi(0,0);
		System.out.println(answer);
	}
	
	public static void combi(int L, int s) {
		if(L == m) {
			int sum = 0;
			for(Point p : home) {
				int dis = Integer.MAX_VALUE;
				for (int x : check) {
					dis = Math.min(dis, Math.abs(p.x - chicken.get(x).x) + Math.abs(p.y - chicken.get(x).y));
				}
				
				sum += dis;
			}
			
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				check[L] = i;
				combi(L+1, i+1);
			}
		}
	}
	
	public static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][n];
		check = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt(); 
				map[i][j] = tmp;
				if(tmp == 1) home.add(new Point(i,j));
				else if(tmp == 2) chicken.add(new Point(i,j));
			}
		}
		
		len = chicken.size();
	}
}
