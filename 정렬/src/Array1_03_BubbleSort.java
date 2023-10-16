import java.util.Arrays;

public class Array1_03_BubbleSort {
	public static void main(String[] args) {
		// 오름 차순 기준으로 정렬을 하고 싶다.

		int[] nums = { 24, 99999, 99, 31, 213124, 7, 35 };
		int N = nums.length; // 7
		// 사이클 횟수를 위한 반복문
		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N - i; j++) {
				// 오름차순이니까~~
				if (nums[j - 1] > nums[j]) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}

			} // 뽀글 뽀글 비교하는 반복문
		} // 사이클 횟수를 위한 반복문

		System.out.println(Arrays.toString(nums));
		
		//교재에 있는 의사코드를 직접 코드로 작성해보고 그림도 그려보면서 의미를 곱씹어볼것!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}