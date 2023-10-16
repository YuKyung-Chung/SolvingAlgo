package Baek_10282_해킹;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int ed, w;
		
		public Node(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	private static final int INF = Integer.MAX_VALUE;
	
	static int n, d, c;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt(); //컴퓨터 개수
			d = sc.nextInt(); //의존성 개수
			c = sc.nextInt(); //해킹당한 컴퓨터 번호
			
			list = new ArrayList[n+1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int s = sc.nextInt();
				
				list[a].add(new Node(b,s));
			}//입력 끝
			
			dist = new int[n+1];
			Arrays.fill(dist, INF);
			
			
			dijkstra(c); //해킹당한 컴퓨터부터 시작
			
			System.out.println(Arrays.toString(dist));
		}//tc
		
		
	}//main
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		
		boolean[] visited = new boolean[n+1];
		dist[start] = 0;
		
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.ed;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : list[cur]) {
				if(dist[node.ed] > dist[cur] + node.w) {
					dist[node.ed] = dist[cur] + node.w;
					q.add(new Node(node.ed, dist[node.ed]));
				}
			}
			
		}
		
	}//다익스트라
}
