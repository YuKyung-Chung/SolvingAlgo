package SWEA_1215_회문1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1215_회문1/input.txt");
		Scanner sc = new Scanner(file);
		
		//테스트 케이스 10개
		for(int k=1; k<=10; k++) {
			int N = sc.nextInt();
			String[][] arr = new String[8][8];
			for(int i=0; i<8; i++) {
				String str = sc.next();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.substring(j,j+1);
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
