package SWEA_16504_Gravity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_16504_Gravity/in.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for(int j=1; j<=T; j++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			//배열에 값 입력받기
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			int answer = 0; //정답 변수
			int max = 0;
			for(int i=0; i<nums.length; i++) {
				max = Math.max(max, nums[i]);
				if(max > nums[i]) {
					answer++;
				}
			}
			System.out.printf("#%d %d\n", j, answer);
		}
	}
}
