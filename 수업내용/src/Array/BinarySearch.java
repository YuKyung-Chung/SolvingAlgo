package Array;

public class BinarySearch {
	public static int[] arr = {2,4,7,9,11,19,23};
	
	public static void main(String[] args) {
		System.out.println(binarySearch(7));
	}
	
	//이진검색 : 항상 자료가 정렬된 상태여야 하고 검색 범위를 절반씩 (logN 관련) 줄여나간다.
	public static boolean binarySearch(int key) {
		int st = 0;
		int ed = arr.length-1;
		
		//언제 끝내야 하나?
		while(st <= ed) {
			int mid = (st + ed) / 2;
			if(arr[mid] == key) {
				return true;
			} else if(arr[mid] > key) {
				ed = mid -1;
			} else {
				st = mid + 1;
			}
		}
		
		
		return false;
	}
}
