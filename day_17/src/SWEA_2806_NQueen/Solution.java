package SWEA_2806_NQueen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int answer;
	static int count; //퀸의 개수
	static int[] record;
	//8방향으로 이동할 좌표
	static int[] dx = {1,-1,0,0,1,-1,1,-1};
	static int[] dy = {0,0,1,-1,1,-1,-1,1};
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_2806_NQueen/input.txt");
		Scanner sc = new Scanner(file);
		
		//퀸을 한군데에 놓은 다음
		//같은 행, 열, 대각선 방문처리
		//방문한 퀸 기록
		//그 다음 퀸을 놓을 때는 방문처리 되지 않은 곳에 놓을 수 있음
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
			answer = 0;
			count = 0;
			record = new int[N];
			
			//N개의 퀸 존재
			dfs(0,0);
					
			System.out.printf("#%d %d\n",tc,answer);
		}//tc
	}//main
	
	public static void dfs(int x, int y) {
		boolean flag = true;
		
		if(x==N) {
			System.out.println(Arrays.toString(record));
			return;
		}
		
		for (int i = 0; i < 8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx <0 || ny <0 || nx >= N || ny >= N ||arr[nx][ny] == 1) continue;
			
			arr[nx][ny] = 1;
			
			for (int j = 0; j < N; j++) {
				visited[nx][j] = true;
				visited[j][ny] = true;
				//같은 대각선상에 위치
				if(Math.abs(arr[nx][ny] - nx)==Math.abs(arr[nx][ny] - ny)) flag = false;
				
				
				
			}
			
		}
		
	}
}
