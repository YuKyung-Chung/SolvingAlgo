package SWEA_2817_부분수열의합;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int N,K,count;
	static int[] A;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_2817_부분수열의합/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			count = 0;
			
			A = new int[N];
			//수열에 값 입력받기
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			partSum(0,0);
			
			System.out.printf("#%d %d\n",tc,count);
		}//tc
	}//main
	
	public static void partSum(int idx, int sum) {
		if(idx==N) {
			if(sum == K) {
				count++;
			}
			return;
		}
		
		partSum(idx+1, sum+A[idx]);
		partSum(idx+1, sum);
	}
}
