package Baek_9205_맥주마시면서걸어가기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int beer;
	static Node home, festival;
	static Node[] cv;
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt();
		 for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //편의점 개수
			
			home = new Node(sc.nextInt(), sc.nextInt());
			cv = new Node[N];
			for (int i = 0; i < N; i++) {
				cv[i] = new Node(sc.nextInt(), sc.nextInt()); 
			}
			festival = new Node(sc.nextInt(), sc.nextInt());
			
			beer = 20;
			BFS(home);
			 
		}//tc
	}//main
	
	public static void BFS(Node cur) {
		 Queue<Node> q = new LinkedList<>();
		 q.add(new Node(cur.x, cur.y));
		 
		 while(!q.isEmpty()) {
			 Node now = q.poll();
			 
			 if(beer * 50 <= dist(now.x, now.y, festival.x, festival.y)) {
				 q.add(now);
			 }
			 
			 
		 }
		
	}//BFS
	
	public static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
