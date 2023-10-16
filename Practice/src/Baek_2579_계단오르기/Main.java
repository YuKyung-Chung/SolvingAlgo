package Baek_2579_계단오르기;

import java.util.Scanner;

public class Main {
	static int N, max;
	static int[] stairs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //계단 개수
		max = -1; //점수 최대값 저장 변수 초기화
		stairs = new int[N];
		//계단 정보 입력
		for (int i = 0; i < N; i++) {
			stairs[i] = sc.nextInt();
		}
		
		
		
	}
}
