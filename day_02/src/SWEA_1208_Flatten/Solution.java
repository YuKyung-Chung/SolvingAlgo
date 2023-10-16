package SWEA_1208_Flatten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1208_Flatten/input.txt");
		Scanner sc = new Scanner(file);
		
		// 테스트 케이스 10번
		for(int T=1; T<=10; T++) {
			int DUMP = sc.nextInt(); //덤프 횟수
			int[] boxes = new int[100];
			for(int i=0; i<100; i++) {
				boxes[i] = sc.nextInt(); //배열에 값 입력받기
			}		
			
			Arrays.sort(boxes);
			for(int i=0; i<DUMP; i++) {
				boxes[99] -= 1;
				boxes[0] += 1;
				Arrays.sort(boxes);	
			}
			int diff = boxes[99]-boxes[0];
			System.out.printf("#%d %d\n",T,diff);
		}
	}
}
