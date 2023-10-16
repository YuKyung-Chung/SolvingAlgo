package SWEA_2105_디저트카페;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, max, row, col;
	static int[][] arr;
	static int[] dx = {1,1,-1,-1}; //대각선으로만 4방향 이동
	static int[] dy = {1,-1,-1,1};
	static boolean[][] visited;
	static List<Integer> num;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_2105_디저트카페/input.txt");
		Scanner sc = new Scanner(file);
		
		//대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아오기
		//같은 숫자의 디저트 팔고 있는 카페 있으면 안됨
		//하나의 카페에서 디저트 먹는거 안됨
		//왔던 길 되돌아가는 거 안됨
		
		//디저트 가장 많이 먹을 수 있는 경로 찾기
		//못찾으면 -1 출력
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			//배열에 값 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					num = new ArrayList<Integer>();
					row = i;
					col = j;
					
					max = Math.max(max, DFS(i,j));
					
					Collections.sort(num);
					//중복체크
					for(int j2 = 0; j2 < num.size()-1; j2++) {
						System.out.print(num.get(j2)+" ");
					}
					System.out.println();
				}
			}
			System.out.printf("#%d %d\n",tc,max);
			
		}//tc
	}//main
	
	public static int DFS(int x, int y) {
		int cnt = 1;
		
		//디저트 못먹는 경우 -1출력
//		if(cnt<1) {
//			cnt = -1;
//			return cnt;
//		}
		num.add(arr[x][y]);
		visited[x][y] = true;
		
		//제자리로 돌아왔을 때 return;
		
		//대각선 방향으로 순회
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx == x && ny == y) return cnt;
				
			//범위 벗어나거나 이미 방문했는지 체크
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
			
			//같은 디저트면 continue
			visited[nx][ny] = true;
			cnt++;
			num.add(arr[nx][ny]);
			DFS(nx,ny);
				
		}
		return cnt;
	}//DFS
	
	
	
	
	
	
	
	
	
	
	
	
}
