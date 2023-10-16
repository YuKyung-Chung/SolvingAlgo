package SWEA_1209_Sum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1209_Sum/input.txt");
		Scanner sc = new Scanner(file);
		
		for(int k=1; k<=10; k++) {
			int N = sc.nextInt();
			int[][] arr = new int[100][100];
			//배열 입력받음
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0; //최대값 저장 변수
			//각 행의 합
			for(int i=0; i<100; i++) {
				int rowSum = 0;
				for(int j=0; j<100; j++) {
					rowSum += arr[i][j];
				}
				max = Math.max(max, rowSum);
			}
			//각 열의 합
			for (int i = 0; i < 100; i++) {
				int colSum = 0;
				for (int j = 0; j < 100; j++) {
					colSum += arr[j][i];
				}
				max = Math.max(max, colSum);
			}
			
			//우하향 대각선의 합
			int rightDiagonalSum = 0;
			for (int i = 0; i < 100; i++) {
				rightDiagonalSum += arr[i][i];
			}
			max = Math.max(max, rightDiagonalSum);
			
			//좌하향 대각선의 합
			int leftDiagonalSum = 0;
			for (int i = 0; i < 100; i++) {
				leftDiagonalSum += arr[i][99-i];
			}
			max = Math.max(max, leftDiagonalSum);
			
			System.out.printf("#%d %d\n", k, max);
		}
	}
}
