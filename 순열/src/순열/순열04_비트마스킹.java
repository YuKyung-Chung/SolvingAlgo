package 순열;

import java.util.Arrays;

public class 순열04_비트마스킹 {
	public static int[] nums;
	public static int N;
	public static int[] result; 	 // 결과저장
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		result = new int[N];
		
		perm(0,0);
		
	}//main
	
	public static void perm(int idx, int visited) {
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		//사용할 수 있는 모든 원소 체크
		for (int i = 0; i < N; i++) {
			//해당 원소 썼는지 확인
			if((visited & (1<<i)) > 0) continue;
			result[idx] = nums[i]; //결과저장
			perm(idx+1, visited | (1<<i));
			//visited 변수는 지역변수로서 일회성이므로 원상복구 안해줘도 됨.
		}
	}
}
