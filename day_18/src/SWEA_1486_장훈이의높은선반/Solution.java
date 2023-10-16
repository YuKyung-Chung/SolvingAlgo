package SWEA_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {
	static int N,B,ans;
	static int[] H; //점원들의 키 배열
	public static void main(String[] args) {
		//비트마스킹을 활용하여 부분집합 구하기
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			
			ans = Integer.MAX_VALUE;
			
			//1.forans(모든 부분집합 돌아볼때)
			for (int i = 0; i < (1<<N); i++) {
				//2. for -> i는 부분집합인데 어떤 점원을 가진 부분집합인지 모르니까 검사
				int sum = 0; //중간합
				for (int j = 0; j < N; j++) {
					//이게 참이라면 j번째 점원이 이번 탑에 포함됐다는 것
					if((i & (1<<j)) != 0) {
						sum += H[j];
					}
				}//탑 다 쌓음
				//적어도 선반의 키는 넘어야 하므로
				if(sum >= B) {
					ans = Math.min(ans, sum);
				}
			}
			System.out.println("#"+tc+" "+(ans-B));
		}
	}
}
