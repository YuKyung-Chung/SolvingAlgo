package Baek_2293_동전1;

import java.util.Scanner;

public class Main {
	static int N,K;
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		dp = new int[K+1];
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j >= coins[i]) {
					dp[j] += dp[j - coins[i]];
				}
			}
		}
		System.out.println(dp[K]);
		
	}//main
}
