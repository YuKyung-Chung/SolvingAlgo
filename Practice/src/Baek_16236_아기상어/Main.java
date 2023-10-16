package Baek_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,cnt,size,eat;
	static int[][] arr;
	static int[] dx = {-1,0,0,1};//위,왼쪽,오른쪽,아래
	static int[] dy = {0,-1,1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		eat = 0; //물고기 먹은 횟수
		cnt = 0; //상어가 이동한 횟수
		size = 2; //상어 초기 사이즈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 9) {
					BFS(i,j);
				}
			}
		}
		
		System.out.println(cnt);
	}//main
	
	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		int eat = 0;
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int[] cur = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + cur[0];
					int ny = dy[i] + cur[1];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] >= size) continue;
					
					
					//잡아먹을 수 있는 물고기일 경우
					if(arr[nx][ny] != 0 && arr[nx][ny] < size) {
						 //잡아먹고 크기 1증가
						arr[nx][ny] = 0;
						eat++;
						System.out.println(eat);
						if(eat == size) {
							size++; //상어 크기 증가
							eat = 0; //카운트 변수 초기화
						}
						q.add(new int[] {nx,ny});
						
					}
					cnt++;
					
				}
				
				
			}//한 사이클
//			cnt++;
		}
		
	}//BFS
}
