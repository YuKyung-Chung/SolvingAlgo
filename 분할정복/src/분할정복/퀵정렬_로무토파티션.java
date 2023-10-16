package 분할정복;

import java.util.Arrays;

public class 퀵정렬_로무토파티션 {
	static int[] arr = {2,13,7,4,9,10,1};
	
	public static void main(String[] args) {
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}//main
	
	
	//퀵 정렬
		public static void quickSort(int left, int right) {
			if(left < right) {
				int pivot = LomutoPartition(left, right); //정렬 완료된 pivot
				//위 pivot 값을 기준으로 왼쪽은 pivot보다 작은 값들 부분리스트
				//오른쪽은 pivot보다 큰 값들의 부분리스트
				quickSort(left, pivot-1); //왼쪽 부분 리스트 퀵 정렬
				quickSort(pivot+1, right); //오른쪽 부분 리스트 퀵 정렬
			}
		}
	
	public static int LomutoPartition(int left, int right) {
		int pivot = arr[right]; //맨 오른쪽 인덱스부터 시작
		int i = left - 1; //-1부터 시작
		
		for(int j=left; j<=right-1; j++) {
			//pivot보다 작은 값들은 왼쪽 부분리스트 쪽으로 몰아넣는 과정
			if(arr[j] <= pivot) {
				i++;
				swap(i,j); //arr[i]와 arr[j]를 swap
			}
		}
		//pivot을 정렬 완료된 리스트 가운데에 넣는 과정
		swap(i+1, right); //arr[i+1]와 arr[right]를 swap
		return i+1;
	}
	
	//원소 swap하는 메서드
	public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
