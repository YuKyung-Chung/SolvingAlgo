import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
	static class Edge {
		int st, ed;

		public Edge(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 최대한 심플하게 배열을 이용해서 저장이 가넝하다.
		int[][] edges1 = new int[E][3]; // [i][0] : 시작정점, [i][1] : 끝정점, [i][2] : 가중치

		Edge[] edges2 = new Edge[E];
		List<Edge> edges3 = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int w = sc.nextInt();

			edges2[i] = new Edge(A, B); // 간선 정보자체를 배열로 저장할꺼니까 유향/무향 따지지 말기
			edges3.add(new Edge(A, B)); // 리스트를 이용했을 때 이런식으로 저장도 가넝
		}

	}
}
