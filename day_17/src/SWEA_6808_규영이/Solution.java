package SWEA_6808_규영이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] gy; //규영이 카드 저장 배열
	static int[] yy; //인영이 카드 저장 배열
	static boolean[] visited; //방문 여부 저장 배열
	static int gyWinCount; //규영이 이긴 횟수 저장 변수
	static int gyLoseCount; //인영이 이긴 횟수 저장 변수
	static int[] cards; //전체 카드 저장 배열
	static int[] yyperm = new int[9];; //인영이 카드 순열로 조합한 후 임시 저장하는 배열
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_6808_규영이/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			cards = new int[19]; //카드 총 개수+1 (카드 번호 1번부터 시작하므로)
			visited = new boolean[9]; //방문 여부 저장할 배열
			
			//규영이가 내는 카드 저장
			gy= new int[9];
			for (int i = 0; i < 9; i++) {
				gy[i] = sc.nextInt();
			}
			
			//전체 카드 배열에 규영이가 받은 카드 저장
			for (int i = 0; i < gy.length; i++) {
				cards[gy[i]]++;
			}
		
			//인영이 카드 저장할 배열
			yy = new int[9];
			
			int idx = 0;
			//인영이가 받은 나머지 9개 카드 저장
			for (int i = 1; i < cards.length; i++) {
				if(cards[i] == 0) {
					yy[idx++] = i;
				}
			}
			
			//테스트 케이스마다 이기고 진 횟수 초기화
			gyWinCount = 0;
			gyLoseCount = 0;
			
			perm(0);
			
			System.out.printf("#%d %d %d\n",tc,gyWinCount,gyLoseCount); //출력
			
		}//tc
	}//main
	
	public static void perm(int idx) {
		int gyWinSum=0; //규영이의 점수 합
		int yyWinSum=0; //인영이의 점수 합
		//인영이 카드 9장 조합이 완료되면
		if(idx == 9) {
			//아홉라운드 게임 진행
			for (int i = 0; i < 9; i++) {
				//규영이가 이기면
				if(gy[i] > yyperm[i]) {
					gyWinSum += (gy[i] + yyperm[i]);
				}
				//인영이가 이기면
				else if(gy[i] < yyperm[i]) {
					yyWinSum += (gy[i] + yyperm[i]);
				}
			}
			//승자 정하기
			//규영이가 승자일때
			if(gyWinSum > yyWinSum) {
				gyWinCount++;
			}
			//인영이가 승자일때
			else if(gyWinSum < yyWinSum) {
				gyLoseCount++;
			}
			return;
		}
		
		//인영이의 카드 조합
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			yyperm[idx] = yy[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
		
	}
}
