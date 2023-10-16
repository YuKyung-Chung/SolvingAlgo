
public class Stack_08_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(fact(4));
		
		
		int ans = 1;
		
		int N = 4;
		for(int i = 1; i<=N ; i++) {
			ans *= i;
		}
		
		System.out.println(ans);
	}
	
	public static int fact(int n) {
		//기본부분
		if(n==1) return 1;
		//재귀부분
		return n * fact(n-1);
	}
	
}
