package Baek_12851_숨바꼭질2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,K,cnt,sol;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //수빈이가 있는 위치 
		K = sc.nextInt(); //동생이 있는 위치
		visited = new boolean[300000];
		
		BFS(N);
		System.out.println(cnt);
		System.out.println(sol);
	}//main
	
	public static void BFS(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int i = 0; i < a; i++) {
				int now = q.poll();
				System.out.println(cnt+"번째 사이클 "+now);
				if(now == K) sol++;
				
				if(!visited[now*2]) {
					visited[now*2] = true;
					q.add(now*2);
				}
				if(!visited[now+1]) {
					visited[now+1] = true;
					q.add(now+1);
				}
				if(now-1 > 0 && !visited[now-1]) {
					visited[now-1] = true;
					q.add(now-1);
				}
				
			}//한 사이클
			cnt++;
		}//while문
	}//BFS
}
