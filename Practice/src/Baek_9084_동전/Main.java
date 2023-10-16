package Baek_9084_동전;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(); //동전 가짓수
			Queue<Integer> money = new LinkedList<Integer>();
			for (int i = 0; i < N; i++) {
				money.add(sc.nextInt());
			}
			
			int M = sc.nextInt(); //만들어야 할 금액
			int cnt = 0;
			int[] dp = new int[10001];
			
			for (int i = money.peek()+1; i <= M; i++) {
				dp[i] = Integer.MAX_VALUE;
			}
			for (int i = 1; i <= money.peek(); i++) {
				if(money.peek() == i) {
					dp[i] = 1;
				}else {
					dp[i] = -1;
				}
			}
			
			
			
			System.out.println(cnt);
		}//tc
		
	}//main
}
