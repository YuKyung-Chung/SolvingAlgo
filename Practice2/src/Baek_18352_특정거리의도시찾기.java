import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baek_18352_특정거리의도시찾기 {
	static int N,M,K,X;
	static List<Integer>[] list;
	static int[] dist;
	
	static class Node{
		int v,w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //도시의 개수
		M = sc.nextInt(); //도로의 개수
		K = sc.nextInt(); //거리 정보
		X = sc.nextInt(); //출발 도시의 번호
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dist = new int[N+1]; //최단거리 저장할 배열
		
		//최소거리 저장할 배열 매우 큰 값으로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		BFS(X);
		
//		dijkstra(X);
		
		System.out.println(Arrays.toString(dist));
		
	}//main
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			
		}
		
		
		
	}
	
	static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		
		dist[start] = 0; //출발 지점의 비용은 0으로 초기화
		
		//다익스트라 알고리즘
		//노드 개수만큼 반복 진행
		for (int i = 0; i < N-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			//선택하지 않은 정점 중 dist가 가장 작은 값을 고르기
			for (int j = 0; j < N; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break; //선택할 것 없음
			visited[idx] = true; //선택
			
			for (int j = 0; j < list[idx].size(); j++) {
				for (int val : list[idx]) {
					if(!visited[val] && dist[val] > dist[idx] + 1) {
						dist[val] = dist[idx] + 1;
					}
				}
				
			}
			
		}
		
	}
}
