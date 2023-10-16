package Baek_24447_BFS04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R, idx;
	static ArrayList<Integer>[] arr;
	static long[] depth, order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		depth = new long[N+1];
		order = new long[N+1];
		
		//초기화
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		//간선 정보 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
		}
		
		//정점 번호 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		
		for (int i = 0; i <= N; i++) {
			depth[i] = -1;
			order[i] = 0;
		}
		
		idx = 1;
		BFS(R,0);
		
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += order[i] * depth[i];
		}
		System.out.println(sum);
		
	}//main
	
	public static void BFS(int cur, int d) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(cur);
		
		order[cur] = idx;
		depth[cur] = d;
		
		while(!q.isEmpty()) {
			for (int i = q.size(); i>0; i--) {
				int a = q.poll();
				
				depth[a] = d;
				for (int next : arr[a]) {
					if(order[next] != 0) continue;
					
					q.offer(next);
					order[next] = ++idx;
				}
			}
			d++;
		}
	}//BFS
}
