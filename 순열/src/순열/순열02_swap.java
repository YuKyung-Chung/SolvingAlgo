package 순열;

import java.util.Arrays;

public class 순열02_swap {
	public static int[] nums; //배열
	public static int N; 	  //원소 수
	
	
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		N = nums.length;
		
		perm(0);

	} //main
	
	//idx : 현재 판단 위치
	public static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		//재귀조건
		for(int i = idx; i < N; i++) {
			swap(i,idx);
			perm(idx+1);
			swap(i,idx);
			
		}
	} //perm
	
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
