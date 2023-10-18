package Baek_2839_설탕배달;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[5001];
		//dp 초기화
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 6; i <= N; i++) {
			if(dp[i-3] == -1 && dp[i-5] == -1) {
				dp[i] = -1;
			}
			else if(dp[i-3] == -1) {
				dp[i] = dp[i-5] + 1;
			}
			else if(dp[i-5] == -1) {
				dp[i] = dp[i-3] +1;
			}
			else {
				dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
			}
		}
		
		System.out.println(dp[N]);
		
		
	}//main
}
