package Baek_17406_배열돌리기4;

import java.util.Scanner;

public class Main {
	static int N,M,K,min;
	static int[][] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt(); //회전 연산의 개수
		min = Integer.MAX_VALUE;
		
		A = new int[N][M];
		//배열 입력받기
		for (int i = 0; i < N; i++) { //행
			for (int j = 0; j < M; j++) { //열
				A[i][j] = sc.nextInt();
			}
		}
		
		//연산정보 입력받기
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			
			//가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)
			//시계 방향으로 한 칸씩 돌린다
			
			
			//회전한 후, 배열 A의 최솟값 갱신
//			min = Math.min(min, b);
		}
		
		System.out.println(min);
		
	}//main
	
}
