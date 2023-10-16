package 분할정복;

public class 이진검색_재귀 {
	public static int[] arr;
	public static int key;
	public static int mid;
	
	public static void main(String[] args) {
		arr = new int[] {2,4,7,9,11,19,23};
		key = 7;
		
		System.out.println(binarySearch(0, arr.length-1));
	}
	
	public static int binarySearch(int low, int high) {
		if (low > high)
			return -1;
		else {
			mid = (low+high)/2;
			if(key == arr[mid]) {
				return mid;
			}
			else if(key < arr[mid]) {
				return binarySearch(low, mid-1); // 왼쪽 구간으로
			}
			else{
				return binarySearch(mid+1, high); // 오른쪽 구간으로
			}
		}
	}
}
