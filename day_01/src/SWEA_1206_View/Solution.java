package SWEA_1206_View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/SWEA_1206_View/input.txt");
		Scanner sc = new Scanner(file);
		
		for(int T=1; T<=10; T++) {
			int N = sc.nextInt();
			
			int[] nums = new int[N];
			int answer = 0;
			//배열에 값 채우기
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			int max = 0;
			for(int i=2; i<N-2; i++) {
				
				if((nums[i-2] < nums[i]) && (nums[i-1] < nums[i]) && (nums[i] > nums[i+1]) && (nums[i] > nums[i+2])) {
					max = Math.max(Math.max(nums[i-2], nums[i-1]), Math.max(nums[i+1], nums[i+2]));
					answer += nums[i] - max;
				}
				
			}
			System.out.printf("#%d %d\n", T, answer);
		}
	}
}
