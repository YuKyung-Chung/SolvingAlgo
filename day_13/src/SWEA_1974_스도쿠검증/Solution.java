package SWEA_1974_스도쿠검증;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1974_스도쿠검증/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		tc: for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			
			//스도쿠 배열에 값 입력받음
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			int answer = 1;
			
			//행검사, 열검사 한방에
			go: for (int i = 0; i < 9; i++) {
				boolean[] row = new boolean[10];
				boolean[] col = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if(row[sudoku[i][j]] || col[sudoku[j][i]]) {
						answer = 0;
						break go;
					}
					row[sudoku[i][j]] = true;
					col[sudoku[j][i]] = true;
					
					//3x3 검사
					if(i % 3 == 0 && j % 3 == 0) {
						boolean[] square = new boolean[10];
						
						for (int k = i; k < i+3; k++) {
							for (int k2 = j; k2 < j+3; k2++) {
								if(square[sudoku[k][k2]]) {
									answer = 0;
									break go;
								}
								square[sudoku[k][k2]] = true;
							}
						}
					}
				}
			}
			
			
			
			

			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
