package queue;

/**
 *  https://www.acmicpc.net/problem/10845
 *  큐
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class P10845_Queue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cir = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<Integer>();
		while(cir-- > 0) {
			String cmd = br.readLine();
			
			if(cmd.contains("push")) {
				q.add(Integer.parseInt(cmd.split(" ")[1]));
			} else if(cmd.contains("front")) {
				bw.write((!q.isEmpty() ? q.peekFirst() : -1) + "\n");
			} else if(cmd.contains("back")) {
				bw.write((!q.isEmpty() ? q.peekLast() : -1) + "\n");
			} else if(cmd.contains("empty")) {
				bw.write((q.isEmpty() ? 1 : 0) + "\n");
			} else if(cmd.contains("pop")) {
				int answer = q.isEmpty() ? -1 : q.poll();
				bw.write(answer+ "\n");
			} else if(cmd.contains("size")) {
				bw.write(q.size() + "\n");
			}
		}
		
		bw.flush();
	}
}
