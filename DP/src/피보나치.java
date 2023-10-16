import java.util.Scanner;

public class 피보나치 {
	static int[] memo;
	static int callFibo1, callFibo2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1]; //메모이제이션 할 배열
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibo(N));
		System.out.println(callFibo1); //재귀 연산 횟수
		System.out.println("---------------");
		System.out.println(fibo2(N));
		System.out.println(callFibo2); //메모이제이션 활용했을 때 연산 횟수
	}//main
	
	public static int fibo2(int n) {
		callFibo2++;
		if(n>=2 && memo[n] == 0) {
			memo[n] = fibo2(n-1)+ fibo2(n-2);
		}
		
		return memo[n];
		
	}
	
	public static int fibo(int n) {
		callFibo1++;
		// 기저조건
//		if(n==0) return 0;
//		if(n==1) return 1;
		if(n < 2)
			return n;
		
		// 재귀조건
		return fibo(n-1) + fibo(n-2);	
		
	}//fibo
	
}
