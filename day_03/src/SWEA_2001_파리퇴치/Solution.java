package SWEA_2001_파리퇴치;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_2001_파리퇴치/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int k = 1; k<=T; k++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] n = new int[N][N];
			//배열 입력받음
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					n[i][j] = sc.nextInt();
				}
			}
			
			int max = -1;
			
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int hap = 0;
					for(int l=i; l<M+i; l++) {
						for(int o=j; o<M+j; o++) {
							hap += n[l][o];
						}
					}
					max = Math.max(max, hap);
				}
			}
			System.out.printf("#%d %d\n", k, max);
		}
		
	}
}
