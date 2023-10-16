package Baek_17143_낚시왕;

import java.util.Scanner;

public class Main {
	static int R,C,M,sum;
	static Shark[][] arr;
	
	static class Shark{
		int r,c,s,d,z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt(); //행
		C = sc.nextInt(); //열
		M = sc.nextInt(); //상어의 수
		sum = 0;
		
		//상어 배열 입력 받기
		arr = new Shark[R+1][C+1];
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt(); //행
			int c = sc.nextInt(); //열
			int s = sc.nextInt(); //속력
			int d = sc.nextInt(); //이동방향: 1위, 2아래, 3오른쪽, 4왼쪽
			int z = sc.nextInt(); //크기
			
			arr[r][c] = new Shark(r,c,s,d,z); //상어크기 저장
 		}
		
		//낚시왕은 1열부터 C열까지 이동
		Fishing(1);
		
		
		
		
	}//main
	

	public static void Fishing(int c) {
		//마지막 열에 도달했다면 끝
		if(c==C) {
			
			return;
		}
		
		//현재 열에서 땅에 제일 가까운 상어 잡기
		for (int i = 0; i < R; i++) {
			//상어가 있으면 잡기
			if(arr[i][c].z != 0) {
				sum += arr[i][c].z;
				arr[i][c] = new Shark(i,c,0,0,0); //상어 잡았으므로 배열에서 제거
				Move(); //상어 이동
				Fishing(c+1); //다음 열 탐색
			}
		}
		
	}
	
	//상어 이동하는 메서드
	public static void Move() {
		
	}
}
