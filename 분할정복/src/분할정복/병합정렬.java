package 분할정복;

import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = {2,13,7,4,9,10,1};
	static int[] sortedArr = new int[arr.length];
	
	public static void main(String[] args) {
		mergeSort(0, arr.length-1);
		System.out.println(Arrays.toString(sortedArr));
	}//main
	
	// 분할 과정
	public static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right)/2; //절반위치
			mergeSort(left, mid); 		//절반 중 왼쪽 부분리스트
			mergeSort(mid+1, right); 	//절반 중 오른쪽 부분리스트
			
			merge(left, mid, right);	//병합작업
		}
	} //mergeSort
	
	
	// 병합 과정
	public static void merge(int left, int mid, int right) {
		int L = left; //왼쪽 부분리스트 시작점
		int R = mid + 1; //오른쪽 부분리스트 시작점
		int idx = left; //채워넣을 배열의 인덱스
		
		while(L <= mid && R <= right) {
			//왼쪽 부분리스트 1번째 원소가 오른쪽 부분리스트 R번째 원소보다 작거나 같을 경우
			//왼쪽의 1번째 원소를 새 배열에 넣고 1과 idx를 1 증가시킨다.
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			}
			//오른쪽 부분리스트 R번째 원소가 왼쪽 부분리스트 1번째 원소보다 작거나 같은 경우
			//오른쪽의 R번째 원소를 새 배열에 넣고 R과 idx를 1 증가시킨다.
			else {
				sortedArr[idx++] = arr[R++];
			}
		}
		//왼쪽 부분리스트 원소가 아직 남아있을 경우
		//나머지 원소들을 새 배열에 채워준다.
		if(L <= mid) {
			for(int i = L; i<=mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		//오른쪽 부분리스트 원소가 아직 남아있을 경우
		//나머지 원소들을 새 배열에 채워준다.
		else {
			for(int j=R; j<=right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		//정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
		for(int i=left; i<=right; i++) {
			arr[i] = sortedArr[i];
		}
		
	}//merge
	
}
