import java.util.Arrays;

public class Array2_02_BinarySearch {
	public static int[] arr = { 2, 4, 7, 9, 11, 19, 23 };

	public static void main(String[] args) {
		System.out.println(binarySearch(7));
		System.out.println(binarySearch(20));
		
		//이미 만들어진게 있음.
		System.out.println(Arrays.binarySearch(arr, 7));
		System.out.println(Arrays.binarySearch(arr, 20));
	}

	// 이진검색 : 자료가 정렬된 상태 여야만 하고 / 검색 범위를 절반씩 (logN 관련있어보임) 줄여나간다.
	public static boolean binarySearch(int key) {
		int st = 0;
		int ed = arr.length - 1;
		// 언제 끝내야 하나
		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key) {
				// 왼쪽구간으로 이도옹
				ed = mid - 1;
			} else {
				// 오른쪽구간으로 이도옹
				st = mid + 1;
			}

		}

		return false;
	}
}
