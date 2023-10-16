import java.util.Scanner;

public class 배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //물건의 개수
		int W = sc.nextInt(); //가방의 무게
		
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][W+1];
		
		//물건 하나씩 고려해서 처리하기
		for (int i = 1; i <= N; i++) {
			//i번째 물건까지 고려한 경우
			//w: 임시 배낭의 크기
			for (int w = 0; w <= W; w++) {
				if(weights[i] <= w) {
					//해당 물건을 이제 판단해보겠다.
					//현재 해당 무게에서의 최적 해는 dp[i-1][w]
					//이번에 물건을 고려한 최적해는  dp[i-1][w-weights[i]] + cost[i]
					//위의 두가지 경우 중 베스트 값을 현재 저장
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
				}else {
					dp[i][w] = dp[i-1][w]; //현재 물건의 무게가 임시 무게를 넘어서 고려할 수 없을 때
				}
			}
		}//물건 하나씩 고려
		System.out.println(dp[N][W]);
		
		
	}
}
