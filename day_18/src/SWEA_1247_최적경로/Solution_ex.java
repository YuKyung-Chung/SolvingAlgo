package SWEA_1247_최적경로;

import java.util.Scanner;

public class Solution_ex {
	static class Pos{
		int x,y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N; //고객 수
	static Pos comp, home;
	static Pos[] custPos;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			comp = new Pos(sc.nextInt(), sc.nextInt()); //회사 좌표 입력
			home = new Pos(sc.nextInt(), sc.nextInt()); //집 좌표 입력
			
			custPos = new Pos[N];
			
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				custPos[i] = new Pos(sc.nextInt(), sc.nextInt());
				
			}//입력 및 초기화 완료
			
			perm(0,0,0,comp);
			
		}//tc
	} //main
	
	//idx  : 몇번 째 자리인지
	//sel  : 방문 체크(visited boolean 배열을 만들지 않고 비트마스킹 하려고)
	//dist : 중간 결과 저장
	//curr : 현재 나의 좌표
	static void perm(int idx, int sel, int dist, Pos curr) {
		if(dist >= ans)
			return;
		
		//모든 고객 방문 완료했을 때
		if(idx == N) { //집으로 귀가
			//curr에는 마지막 고객의 집 좌표 들어있음
			ans = Math.min(ans, dist+Math.abs(curr.x - home.x) + Math.abs(curr.y-home.y));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			//고객체크(방문하지 않았다면)
			if((sel & (1<<i)) == 0) {
				perm(idx+1, sel | (1<<i), dist+Math.abs(curr.x - custPos[i].x) + Math.abs(curr.y-custPos[i].y), custPos[i]);
			}
			
			
		}
	}
}
