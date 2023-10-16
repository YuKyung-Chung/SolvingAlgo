package Baek_2206_벽부수고이동하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,cnt;
	static int[][] arr;
	static boolean[][][] visited;
	static int hammer;
	static boolean isTrue;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //행
		M = sc.nextInt(); //열
		dist = new int[N][M]; //거리 저장 배열
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j,j+1));
			}
		}
		
		visited = new boolean[N][M][2];
		isTrue = false;
		hammer = 0;
		cnt = 1;
		dist[0][0] = cnt;
		BFS(0,0);
		
//		if(!isTrue && dist[N-1][M-1] == 0) System.out.println(-1);
//		else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(dist[i][j]+ " ");
				}
				System.out.println();
			}
			
//			System.out.println(dist[N-1][M-1]);
//		}
	}//main
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
//		visited[x][y][0] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int[] cur = q.poll();
				
				dir: for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					
					//벽이 아니면
					if(arr[nx][ny] == 0) {
						//한번도 부순적이 없다면
						if(!visited[nx][ny][0] && !isTrue) {
							visited[nx][ny][0] = true;
							
							dist[nx][ny] = cnt;
							q.add(new int[] {nx,ny});
							
						}
						//이미 부순 적이 있다면
						else if(!visited[nx][ny][1] && isTrue) {
							visited[nx][ny][1] = true;
							dist[nx][ny] = cnt;
							q.add(new int[] {nx,ny});
							
						}
					} 
					//벽이면
					else if(arr[nx][ny] == 1) {
						//한번도 부순적이 없다면
						if(!visited[nx][ny][1] && !isTrue) {
							visited[nx][ny][1] = true;
							q.add(new int[] {nx,ny});
						}
					}

				}
				
				
			}//cycle
			
			cnt++;
			
		}
	}
}
