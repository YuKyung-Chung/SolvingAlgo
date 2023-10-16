package SWEA_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution3 {
	static int N,B,ans;
	static int[] H; //점원들의 키 배열
	static boolean[] sel;
	public static void main(String[] args) {
		//재귀를 활용하여 부분집합 구하기(중간합 이용)
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			sel = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			
			ans = Integer.MAX_VALUE;
			powerset(0,0);
			
			System.out.println("#"+tc+" "+(ans-B));
		}
	}//main
	
	public static void powerset(int idx, int sum) {
		if(sum > ans) return; //중간결과가 벗어날 경우 쳐내기
		
		//기저 부분
		if(idx == N) {
			if(sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		
		//재귀 부분
		sel[idx] = true; //쌓고
		powerset(idx+1, sum + H[idx]);
		sel[idx] = false; //안쌓고
		powerset(idx+1, sum);
		
	}
}
