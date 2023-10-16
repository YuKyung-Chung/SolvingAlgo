package 무선충전;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class AP{
		int x,y,c,p;
		boolean isTrue;
		
		public AP(int x, int y, int c, int p, boolean isTrue) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.isTrue = isTrue;
		}
	}
	
	static List<AP>[] list;
	static int M, cnt;
	static int[] A, B;
	static int[] dx = {0,-1,0,1,0}; //0,상,우,하,좌
	static int[] dy = {0,0,1,0,-1};
	static int[] timeA, timeB;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/무선충전/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); //이동 거리(초)
			cnt = sc.nextInt(); //AP 개수
			
			A = new int[M+1];
			B = new int[M+1];
			timeA = new int[M+1];
			timeB = new int[M+1];
			
			//A의 이동정보 입력받기
			for (int i = 1; i <= M; i++) {
				A[i] = sc.nextInt();
			}
			//B의 이동정보 입력받기
			for (int i = 1; i <= M; i++) {
				B[i] = sc.nextInt();
			}
			
			list = new ArrayList[cnt];
			for (int i = 0; i < cnt; i++) {
				list[i] = new ArrayList<>();
			}
			
			//AP 정보 입력받기
			for (int i = 0; i < cnt; i++) {
				list[i].add(new AP(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),true));
			}
			
			//사용자 위치 초기화
			int Ax = 1;
			int Ay = 1;
			int Bx = 10;
			int By = 10;
			
			//시작
			for (int i = 0; i <= M; i++) {				
				//현 위치에서 접속 가능한 AP 저장
				List<Integer> possibleA = new ArrayList<>();
				List<Integer> possibleB = new ArrayList<>();
				
				//각 AP 별 거리 측정하여 가능한지 확인
				for (int j = 0; j < list.length; j++) {
					AP now = list[i].get(0);
					int distA = Math.abs(Ax - now.x) + Math.abs(Ay - now.y);
					int distB = Math.abs(Bx - now.x) + Math.abs(By - now.y);
					//가능하면 추가
					if(distA <= now.c) {
						possibleA.add(j);
					}
					if(distB <= now.c) {
						possibleB.add(j);
					}
				}
				
				//충전량 측정
				int charge = 0;
				
				
			}
			
			
		}//tc
	}//main
	

}
