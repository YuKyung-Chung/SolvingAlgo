package SWEA_6808_규영이와인영이의카드게임;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int gyWin, gyLose;
	static int[] gy; //규영이 카드
	static boolean[] gVisited;
	static int[] yy; //인영이 카드
	static int[] temp; //인영이 카드 조합 임시 저장할 배열
	static boolean[] yVisited;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_6808_규영이와인영이의카드게임/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			gVisited = new boolean[19];
			yVisited = new boolean[9];
			gy = new int[9];
			yy = new int[9];
			temp = new int[9];
			gyWin = 0;
			gyLose = 0;
			
			//규영이 카드 입력받기
			for (int i = 0; i < 9; i++) {
				gy[i] = sc.nextInt();
				gVisited[gy[i]] = true;
			}
			
			int idx = 0;
			//규영이가 받은 카드 제외하고 나머지 인영이한테 나눠주기
			for (int i = 1; i < 19; i++) {
				if(gVisited[i] == false) {
					yy[idx++] = i;
				}
			}
			
			combination(0);
			System.out.printf("#%d %d %d\n",tc, gyWin, gyLose);
			
		}//tc
	}//main
	
	public static void combination(int sidx) {
		int gySum = 0;
		int yySum = 0;
		//9장 뽑으면 종료
		if(sidx == 9) {
			//아홉라운드 게임 진행
			for (int i = 0; i < 9; i++) {
				//규영이가 이기면
				if(gy[i] > temp[i]) {
					gySum = gySum + (gy[i]+temp[i]);
				}
				//인영이가 이기면
				else if(gy[i] < temp[i]) {
					yySum = yySum + (gy[i]+temp[i]);
				}
			}
			//규영이가 승자일 때
			if(gySum > yySum) gyWin++;
			//인영이가 승자일 때
			else if(gySum < yySum) gyLose++;
			return;
		}
		
		//인영이의 카드 순열로 순서 정하기
		for (int i = 0; i < yy.length; i++) {
			if(yVisited[i]) continue;
			
			temp[sidx] = yy[i];
			yVisited[i] = true;
			combination(sidx+1);
			yVisited[i] = false;
			
		}
	}
}
