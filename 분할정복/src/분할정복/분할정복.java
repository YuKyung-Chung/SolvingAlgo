package 분할정복;

public class 분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 3;
		
//		System.out.println(pow(C,N));
	}
	
	//비효율적인 코드
	public static int pow(int C, int N) {
		//기저조건
		if(N==1) return C;
		
		//재귀조건
		//짝수일때
		if(N%2==0){
			return pow(C, N/2) * pow(C, N/2);
		}
		//홀수일때
		else {
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
		}
	}
	
	
}
