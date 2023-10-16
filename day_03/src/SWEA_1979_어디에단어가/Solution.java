package SWEA_1979_어디에단어가;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1979_어디에단어가/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); // 테스트 케이스 개수
		for(int k=1; k<=T; k++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			//배열에 값 할당
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			//가로순회
			for(int i=0; i<N; i++) {
				int count = 0;
				for(int j=0; j<N; j++) {
					if(arr[i][j] == 1) {
						count++;
					} else {
						if(count == K) {
							answer++;
							count = 0;
						}else {
							count = 0;
						}
					}
				}
				if(count == K) {
					answer++;
				}
			}
			
			//세로순회
			for(int i=0; i<N; i++) {
				int count = 0;
				for(int j=0; j<N; j++) {
					if(arr[j][i] == 1) {
						count++;
					} else  {
						if(count == K) {
							answer++;
							count = 0;
						} else {
							count = 0;
						}
					}
				}
				if(count == K) {
					answer++;
				}
			}
			System.out.printf("#%d %d\n", k, answer);
		}
	}
}


