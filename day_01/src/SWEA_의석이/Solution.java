package SWEA_의석이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_의석이/sample_input.txt");
		Scanner sc = new Scanner(file);
	
		
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			StringBuilder sb = new StringBuilder();
			char[][] letters = new char[5][15];

			for(int i=0; i<5; i++) {
				String str = sc.next();
				for(int j=0; j<15; j++) {
					if(j < str.length()) {
						letters[i][j] = str.charAt(j);
					}else {
						letters[i][j] = '$';
					}
					
				}	
			}

			
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(letters[j][i] !='$')
						sb.append(letters[j][i]);
				}
				
			}
			System.out.printf("#%d %s\n", k, sb.toString());

		}
		
	}
}
