package Baek_17142_연구소3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M, cnt, min;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][N];
		//바이러스 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[N][N];
		q = new LinkedList<>();
		cnt  = 0;
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int m = 0; m < M; m++) {
					if(arr[i][j] == 2 && !visited[i][j]) {
//						BFS(i,j,m);
						q.add(new int[] {i,j});
					}
				}
				
			}
		}
		
		BFS();
		min = Math.min(min, cnt);
		System.out.println(min);
		
	}//main
	
	public static void BFS() {
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int[] cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] == 1) continue;
					
					if(arr[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
				}
				
			}
			cnt++;
			
		}
	}//BFS
}
