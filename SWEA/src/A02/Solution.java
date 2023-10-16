package A02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static class Node{
		int x,y,val;
		
		public Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int N,answer;
	static Node[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/A02/input.txt");
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MAX_VALUE;
			N = sc.nextInt();
			arr = new Node[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = new Node(i,j,sc.nextInt());
				}
			}
			
			visited = new boolean[N][N];
			visited[0][0] = true;
			DFS(0,0,0,visited);
			
			System.out.printf("#%d %d\n",tc,answer);
		}//tc
		
	}//main
	
	public static void DFS(int x, int y, int val,boolean[][] visited) {
		if(x == N-1 && y == N-1) {
			answer = Math.min(answer, val);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			//경계조건 확인
			if(nx >=0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
				//그 다음 칸이 높이가 더 낮을 경우 : 0
				if(arr[x][y].val > arr[nx][ny].val) {
					visited[nx][ny] = true;
					DFS(nx,ny,val,visited);
				}
				//그 다음 칸과 높이가 같을 경우 : +1
				else if(arr[x][y].val == arr[nx][ny].val) {
					visited[nx][ny] = true;
					DFS(nx,ny,val+1,visited);
				}
				//그 다음 칸이 높이가 더 높을 경우: 차이의 2배
				else if(arr[x][y].val < arr[nx][ny].val) {
					visited[nx][ny] = true;
					int m = Math.abs(arr[x][y].val - arr[nx][ny].val) * 2;
					DFS(nx,ny,val+m,visited);
				}
				visited[nx][ny] = false;
				
			}
		}
		
	}
}
