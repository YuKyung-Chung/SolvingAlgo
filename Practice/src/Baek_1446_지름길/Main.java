package Baek_1446_지름길;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int st, ed, w;
		
		public Node(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	private static final int INF = Integer.MAX_VALUE;
	
	static int N,D, sum;
	static Node[] list;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //지름길 개수
		D = sc.nextInt(); //고속도로 길이
		
		list = new Node[N];
		
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt(); //시작 위치
			int B = sc.nextInt(); //도착 위치
			int D = sc.nextInt(); //지름길 위치
			
			if((B-A) < D) continue; //지름길이 아님
			list[i] = new Node(A,B,D);
		}//입력 끝
		
		dist = new int[D+1];
		for (int i = 0; i <= D; i++) {
			dist[i] = i;
		}
		
		dijkstra(0);
		
		System.out.println(dist[D]);
		
	}//main
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.ed;
			boolean chk = false;
			
			for (Node node : list) {
				//그 다음 노드일 경우
				if(node.st >= cur) {
					if(node.ed > D) continue;
					int tmp = node.st - cur;
					chk = true;
					
					if(dist[node.ed] > dist[cur] + node.w +tmp) {
						dist[node.ed] = dist[cur] + node.w +tmp;
						q.add(new Node(cur, node.ed, dist[node.ed]));
					}
				}
				
			}
			
			//큐가 비어있을 때
			dist[D] = Math.min(dist[cur] + D - cur, dist[D]);
			
		}
	}
}
