import java.util.Arrays;

public class Array2_01_SequentailSearch {
	public static int[] arr = { 4, 9, 11, 23, 2, 19, 7 };

	public static void main(String[] args) {
		System.out.println(searchForNoSort(2));
		System.out.println(searchWhileNoSort(2));
		
		Arrays.sort(arr);
		//아래에서 호출 할것
	}

	// 인덱스를 반환할 수도 있고 찾았다 못찾았다의 boolean을 반환할 수도 있고
	// 인덱스는 직접해볼것
	// 중복된 원소가 있을 때나 기타 상황을 고려친 않았고 무조건 있는지 없는지만 쳌
	public static boolean searchForNoSort(int key) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == key)
				return true;
		}
		return false;
	}
	
	public static boolean searchWhileNoSort(int key) {
		int idx = 0;
		while (idx < arr.length){
			if(arr[idx] == key) {
				return true;
			}
			idx++;
		}
		return false;
	}
	
	public static boolean searchWhileNoSort2(int key) {
		int idx = 0;
		while (idx < arr.length && arr[idx] != key){
			idx++;
		}
		if(idx < arr.length) return true;
		return false;
	}
	
	//직접 작성해볼것
	public static boolean searchForSort(int key) {
		return false;
	}
	
	public static boolean searchWhileSort(int key) {
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
