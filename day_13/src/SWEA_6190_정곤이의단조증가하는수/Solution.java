package SWEA_6190_정곤이의단조증가하는수;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_6190_정곤이의단조증가하는수/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			//배열에 값 입력받음
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			long answer = -1;
			
			//단조 증가하는 수인지 여부 체크
			for (int i = 0; i < nums.length-1; i++) {
				//단조 증가하는 수가 아니면 -1 출력
				if(nums[i] > nums[i+1]) {
					answer = -1;
					break;
				}
				
				for (int j = i+1; j < nums.length; j++) {
					//단조 증가하는 수일 때, 곱의 최대값 찾아서 answer 갱신
					long multiple = nums[i] * nums[j];
					System.out.println(multiple);
					if(answer <= multiple) {
						answer = multiple;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}//tc
	}//main
}
