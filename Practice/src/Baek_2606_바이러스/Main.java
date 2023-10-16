package Baek_2606_바이러스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,cnt;
	static ArrayList<Integer>[] arr; 
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //컴퓨터 수
		M = sc.nextInt(); //연결되어 있는 컴퓨터 쌍의 수
		arr = new ArrayList[N+1]; //연결정보 저장할 인접리스트
		
		//인접리스트 초기화
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		//연결정보 저장
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			//무방향 그래프이므로 양방향 연결
			arr[u].add(v);
			arr[v].add(u);
		}
		cnt = 0;
		visited = new boolean[N+1];
		
		BFS(1); //1번 컴퓨터부터 시작
		System.out.println(cnt);
	} //main
	
	public static void BFS(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for (int i : arr[a]) {
				if(!visited[i]) {
					visited[i] = true;
					cnt++;
					q.add(i);
				}
			}
		}
	}//BFS
}
