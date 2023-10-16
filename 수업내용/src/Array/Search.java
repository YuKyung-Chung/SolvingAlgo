package Array;

public class Search {
	public static int[] arr = {4,9,11,23,2,19,7};
	
	public static void main(String[] args) {
		System.out.println(searchForNoSort(2));
		System.out.println(searchWhileNoSort(2));
		
	}
	
	// 인덱스를 반환할 수도 있고 찾았다 못찾았다의 boolean을 반환할 수도 있고
	// 인덱스는 직접해볼 것
	// 중복된 원소가 있을 때나 기타 상황을 고려친 않았고 무조건 있는지 없는지만 체크
	public static boolean searchForNoSort(int key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key)
				return true;
		}
		return false;
	}
	
	public static boolean searchWhileNoSort(int key) {
		int idx = 0;
		while(idx <arr.length) {
			if(arr[idx] == key)
				return true;
			idx++;
		}
		return false;
	}
	
	public static boolean searchForSort(int key) {
		
		
		return false;
	}
	
public static boolean searchWhileSort(int key) {
		
	
	return false;
	}
}
