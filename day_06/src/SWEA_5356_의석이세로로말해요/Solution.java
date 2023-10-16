package SWEA_5356_의석이세로로말해요;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_5356_의석이세로로말해요/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for(int k=1; k<=T; k++) {
			
			char[][] arr = new char[5][15];
			//2차원 배열에 값 채우기
			for(int i=0; i<5; i++) {
				String str = sc.next();
				for(int j=0; j<str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
				for (int j = str.length(); j < 15; j++) {
					arr[i][j] = '$';
				}
			}
			
			String answer = "";
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(arr[j][i] != '$')
						answer += arr[j][i];
				}
			}
			
			System.out.printf("#%d %s\n", k, answer);
		}
		
		
	} //main

}
