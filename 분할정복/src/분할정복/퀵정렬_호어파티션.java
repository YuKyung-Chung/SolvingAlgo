package 분할정복;

import java.util.Arrays;

public class 퀵정렬_호어파티션 {
	static int[] arr = {2,13,7,4,9,10,1};
	
	public static void main(String[] args) {
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}//main
	
	//퀵 정렬
	public static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = HoarePartition(left, right); //정렬 완료된  pivot
			quickSort(left, pivot-1); 	//pivot 기준 왼쪽 부분리스트 퀵 정렬 재귀
			quickSort(pivot+1, right); //pivot 기준 오른쪽 부분리스트 퀵 정렬 재귀
		}
	}
	
	//호어 파티션 알고리즘
	public static int HoarePartition(int left, int right) {
		int pivot = arr[left]; //제일 왼쪽 값 pivot
		int L = left+1; //왼쪽 시작 인덱스
		int R = right;	//오른쪽 시작 인덱스
		
		while(L <= R) {
			//인덱스가 크로스오버 되지 않고 
			//왼쪽에 있는 값이 pivot보다 작으면 범위 줄이면서 그대로 진행
			while(L<=R && arr[L] <= pivot) L++;
			//오른쪽 부분에 있는 값이 pivot보다 크면 범위 줄이면서 그대로 진행
			while(arr[R] > pivot) R--;
			
			//L과 R을 다 움직였는데도 겹치지 않았다면
			if(L < R) {
				//원소끼리 swap해서 왼쪽은 pivot보다 작은 값, 오른쪽은 pivot보다 큰 값 유지
				swap(L,R);
			}
		}
		//정렬 완료된 리스트의 R자리와 pivot값 swap
		swap(left,R);
		return R;
	}
	
	//원소 swap하는 메서드
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
