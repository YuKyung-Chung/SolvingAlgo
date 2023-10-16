import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 다잌스트라_02_우선순위큐 {

	static class Node implements Comparable<Node>{
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	private static final int INF = 1234567;
		
	static int V,E,K;
	static List<Node>[] adjList;
	static int[] dist;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt(); //시작 정점의 번호
		adjList = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V+1];
		Arrays.fill(dist, INF);
			
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
				
			adjList[u].add(new Node(v,w));
		}
			
		dijkstra(K);
			
		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
			
	}//main
		
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		boolean[] visited = new boolean[V+1];
		q.add(new Node(start,0));
		dist[start] = 0;
			
			
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
				
			if(visited[cur]) continue;
			visited[cur] = true;
				
				
			for(Node node : adjList[cur]) {
				if(dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					q.add(new Node(node.end, dist[node.end]));
				}	
			}
		}
	}//다익스트라
	
	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";

}
