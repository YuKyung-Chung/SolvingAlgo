package SWEA_1954;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1954/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트케이스 개수
		for(int f=1; f<=T; f++) {
			int N = sc.nextInt();
			
			System.out.printf("#%d\n",f);
			
			int[][] nums = new int[N][N];

			int num = N;
			int a = 1;
			int right = 0;
			int bottom = -1;
			int top = 1;
			for(int i=N; i>=0; i--) {
				for(int j=0; j<num; j++) {
					bottom += top;
					nums[right][bottom] = a++;
					
				}
				num--;
				for(int j=0; j<num; j++) {
					right += top;
					nums[right][bottom] = a++;
					
				}
				
				top = top * (-1);
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(nums[i][j]+ " ");
				}
				System.out.println("");
			}
			
			}
		}
	}

