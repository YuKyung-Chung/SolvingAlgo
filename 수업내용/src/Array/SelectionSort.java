package Array;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] nums = {64, 25, 10, 22, 11};
		int N = nums.length;
		
		//몇 사이클을 돌아야 하는가 한 사이클이 종료가 될때마다 하나씩 정렬이 되므로 N-1번
		//i번째의 자리를 정렬하고자함
		for(int i=0; i<N-1; i++) {
			int minIdx = i; //i번쩨 자리가 가장 작은 값이라고 초기화 시켜둔 상태
			
			//i 이후에 등장하는 친구들고 비교하여 갱신해야 함	
			//minIdx찾는 for문
			for(int j = i+1; j<N; j++) {
				//현재 내가 보고있는 j번째 값이 minIdx 값보다 작다면
				if(nums[j] < nums[minIdx]) {
					minIdx = j;
				}
			}
			//여기까지 왔다면 최소값을 가리키는 idx는 확보한 상태
			int temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
