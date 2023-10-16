package SWEA_1267_작업순서;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//위상정렬 (Stack 활용)
public class Solution2 {
	static int V,E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1267_작업순서/input.txt");
		Scanner sc = new Scanner(file);
		
		
		for (int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt(); //정점 개수
			E = sc.nextInt(); //간선 개수
			
			//인접행렬
			adjArr = new int[V+1][V+1]; //1번 정점부터 V번까지
			degree = new int[V+1]; //진입차수 저장할 배열 생성
			visited = new boolean[V+1]; //방문 여부 체크 배열 생성
			
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				//유향그래프 A -> B
				adjArr[A][B] = 1; //가중치 따로 주어지지 않았기 때문에
				//진입차수 증가
				degree[B]++;
			}//입력 완료
		
			stack = new Stack<>();
			List<Integer> list = new ArrayList<>();
			
			//진입차수가 0인 것부터 DFS 시작
			for (int i = 1; i <= V; i++) {
				if(degree[i] == 0)
					DFS(i);
			}
			
			while(!stack.isEmpty()) {
				list.add(stack.pop());
			}
			
			//출력부
			System.out.print("#"+tc+" ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}//tc
	}//main
	
	public static void DFS(int v) {
		visited[v] = true; //현재 정점 방문 체크
		
		for (int i = 1; i <= V; i++) {
			//인접하지만 방문하지 않은 정점들 방문
			if(adjArr[v][i] == 1 && !visited[i])
				DFS(i);
		}
		
		stack.add(v);
	}//DFS
}
