package Baek_1003_피보나치;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int zero = 0;
			int one = 0;
			dp = new int[N+1];
			
			if(N == 0) {
				dp[0] = 0;
				zero++;
			}else if(N==1) {
				dp[1] = 1;
				one++;
			}else {
				for (int i = 2; i < dp.length; i++) {
					dp[i] = dp[i-1] + dp[i-2];
					if(dp[i] == 0) {
						zero++;
					}else if(dp[i] == 1) {
						one++;
					}
				}
			}
			
			System.out.println(zero + " " + one);
		}
		
		
	}//main
}
