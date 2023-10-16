package Array;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		//양수를 가정
		int[] arr = {8,8,24,12,19,3,45,60};
		int N = arr.length;
		
		//1. 데이터 중 가장 큰 값을 알고 있어야 한다.
		int K = -1; //초기화
		for(int i=0; i<N; i++) {
			if(K < arr[i]) {
				K = arr[i];
			} //가장 최대값을 찾는 for문
		}
		
		int[] count = new int[K+1]; // 0~60 : 61칸짜리 만들어진다
		
		//2. 개수 카운팅
		for(int i=0; i<N; i++) {
			// arr[i] -> 해당 값을 인덱스로 하여 카운트를 증가시킴
			count[arr[i]]++;
		}
		
		//3. 누적합을 구한다 (들어갈 수 있는 위치 결정되고 안정정렬 가능하게 만들어줌)
		for(int i=1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
		//4. 원본배열의 뒤에서부터 순회하며 정렬된 배열에 차곡차곡 저장한다
		int[] sortArr = new int[N];
		for(int i=N-1; i>=0; i--) {
			//지금 저장하고 싶은 값: arr[i]
			//저장하고 싶은 위치는 : count[arr[i]]-1 -> 하고나서 한번 더 count[arr[i]]--;
			// --count[arr[i]] -> 이거 한방으로 처리 가능
			
			sortArr[--count[arr[i]]] = arr[i];
		}
		System.out.println(Arrays.toString(sortArr));
	}
}
