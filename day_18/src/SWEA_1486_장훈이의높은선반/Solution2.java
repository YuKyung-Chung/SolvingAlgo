package SWEA_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution2 {
	static int N,B,ans;
	static int[] H; //점원들의 키 배열
	static boolean[] sel;
	public static void main(String[] args) {
		//재귀를 활용하여 부분집합 구하기
		
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
			powerset(0);
			
			System.out.println("#"+tc+" "+(ans-B));
		}
	}//main
	
	public static void powerset(int idx) {
		//기저 부분
		if(idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(sel[i]) {
					sum += H[i];
				}
			}
			if(sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		
		//재귀 부분
		sel[idx] = true; //쌓고
		powerset(idx+1);
		sel[idx] = false; //안쌓고
		powerset(idx+1);
		
	}
}
