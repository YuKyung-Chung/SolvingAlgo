package SWEA_1966_숫자를정렬하자;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1966_숫자를정렬하자/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//삽입정렬
			for(int i=1; i<nums.length; i++) {
				//정렬할 값
				int key = nums[i];
				int j;
				//key 값을 넣을 위치 찾고 뒤로 미는 for문
				for(j=i-1; j>=0 && key < nums[j]; j--) {
					nums[j+1] = nums[j];
				}
				nums[j+1] = key;
			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			
		}//tc
	}//main
	
	//버블 정렬
	public static void BubbleSort() {
		
	}
	
	//선택 정렬
	public static void SelectionSort() {
		
	}
	
	
	//카운팅 정렬
	public static void CountingSort() {
		
	}
	
	//삽입 정렬
	public static void InsertionSort() {
		
	}
}
