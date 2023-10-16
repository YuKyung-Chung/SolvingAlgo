package SWEA_1210_Ladder1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	//상좌우
	static int[] dr = {-1, 0, 0};
	static int[] dc = {0, -1, 1};
	static int[][] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1210_Ladder1/input.txt");
		Scanner sc = new Scanner(file);
		
		tc: for(int k=1; k<=10; k++) {
			int T = sc.nextInt();
			arr = new int[100][100];
			//배열 입력 받음
			for(int i=0; i<100; i++) {
				for(int j=0;j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//시작좌표 구하기
			row: for(int i=99; i>=0; i--) {
				column: for(int j=99; j>=0; j--) {
					if(arr[i][j] == 2) {
						//여기서부터 시작
						
						//좌우 중에 1이 있으면
						//1이 있는 쪽으로 쭉 이동하고 (while 종료조건: i+1이 인덱스를 벗어나거나 0인경우)
						//위로 한칸 이동
						if(arr[i][j--] == 1) {
							while(j-->=0) {
								
							}
						}else if(arr[i][j++] == 1) {
							while(j++ <100) {
								
							}
						}
						
								
								
						//좌우가 0이고
						//위가 1이면
						//위로 한칸 이동
						if(arr[i][j--] == 0 && arr[i][j++] == 0 && arr[i--][j] == 1) {
							//위로 한칸 이동
							
						}
						
					}
					
					
					
				}
			}
					
		}//tc for문
	}//main
}


