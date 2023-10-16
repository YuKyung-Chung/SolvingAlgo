package 순열;

import java.util.Arrays;

public class 순열03_visited {
	public static int[] nums;
	public static int N;
	public static int[] result; 	 // 결과저장
	public static boolean[] visited; // 해당 원소 사용 유무
	
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2,3};
		N = 3;
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
		
	}//main
	
	//idx 현재 내가 판단하는 위치
	public static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 사용할 수 있는 모든 원소 체크
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue; //이미 사용한 원소라면 처내
			
			result[idx] = nums[i]; //해당 i번째 원소 저장
			visited[i] = true; //i번째 원소 사용했다고 표시
			perm(idx+1); 
			visited[i] = false; //i번째 원상복구
		}
	}
}
