package SWEA_11315_오목판정;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_11315_오목판정/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			//배열 입력받음
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			boolean isTrue = false; //오목 완성 여부
			
			//오목 완성되는 순간 while문 탈출
			while(isTrue == false) {
				//가로에 오목이 완성됐는지 확인
				for(int i=0; i<N; i++) {
					int count = 0;
					for(int j=0; j<N; j++) {
						if(arr[i][j] == 'o') { //'o'인 경우
							count++;
						} else { //'.'인 경우
							if(count >= 5) { //오목 완성됐는지 확인
								isTrue = true;
								break;
							}
							if(isTrue == false)//오목 완성 안됐는데 . 나온 것이므로 count 초기화
								count = 0;
							}
					}
					if(count >= 5) {
						isTrue = true;
						break;
					}
				}
				
				//세로에 오목이 완성됐는지 확인
				for(int i=0; i<N; i++) {
					int count = 0;
					for(int j=0; j<N; j++) {
						if(arr[j][i] == 'o') { //'o'인 경우
							count++;
						} else { // '.'인 경우
							if(count >= 5) { //오목 완성됐는지 확인
								isTrue = true;
								break;
							}
							
							if(isTrue == false)//오목 완성 안됐는데 . 나온 것이므로 count 초기화
								count = 0;
						}
					}
					if(count >= 5) {
						isTrue = true;
						break;
					}
				}
				
				//우하향 대각선에 오목이 완성됐는지 확인
				for(int i=0; i<N; i++) {
					int count = 0;
					for (int j = 0; j <= i; j++) {
						if(arr[j][N-1-i+j] == 'o') { //'o'인 경우
							count++;
						}else { //'.'인 경우
							if(count >= 5) { //오목 완성됐는지 확인
								isTrue = true;
								break;
							}
							if(isTrue == false)//오목 완성 안됐는데 . 나온 것이므로 count 초기화
								count = 0;
						}
					}
					if(count >= 5) {
						isTrue = true;
						break;
					}
				}
					
				//좌하향 대각선에 오목이 완성됐는지 확인
				for(int i=0; i<N; i++) {
					int count = 0;
					for(int j=0; j <= i; j++) {
						if(arr[j][i-j] == 'o') { //'o'인 경우
							count++;
						} else { //'.'인 경우
							if(count >= 5) { //오목 완성됐는지 확인
								isTrue = true;
								break;
							}
							if(isTrue == false)//오목 완성 안됐는데 . 나온 것이므로 count 초기화
								count = 0;
						}
					}
					if(count >= 5) {
						isTrue = true;
						break;
					}
				}
				
				break; //모든 경우의 수 돌았으므로 while문 탈출
				} //while문
			
				if(isTrue == true) { //오목이 완성된 경우
					System.out.printf("#%d %s\n",k,"YES");
				} else { //오목이 완성되지 않은 경우
					System.out.printf("#%d %s\n",k,"NO");
				}
			}	
	} // main
}
