package 부분집합_조합;

public class 부분집합02 {
	public static String[] 재료 = {"오이","참치","햄","우엉"};
	
	public static void main(String[] args) {
		int N = 재료.length;
		int[] sel = new int[N];
		
		//i는 모든 부분 집합
		for (int i = 0; i < (1<<N); i++) {
			System.out.println(i);
			//재료검사
			for (int j = 0; j < N; j++) {
				if((i & (1<<j)) > 0) {
					//i는 모든 부분집합 중 하나
					//j를 하나씩 밀면서 i와 &으로 연산하여 해당 재료가 들어있는지 확인
					System.out.print(재료[j]);
				}
			}
			System.out.println(":김밥");
		}
		
	}//main
}
