package SWEA_1213_String;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1213_String/input.txt");
		Scanner sc = new Scanner(file);
		
		for(int k=1; k<=10; k++) {
			int count = 0; //문자열 개수 저장할 변수
			int T = sc.nextInt(); //테스트 케이스 번호
			
			String str = sc.next(); //찾을 문자열
			String fullStr = sc.next(); //검색할 문장
			int strLen = str.length();
			
			for(int i=0; i<fullStr.length()-strLen+1; i++) {
				
				if(fullStr.substring(i, i+strLen).equals(str)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", T, count);
		}
	}
}
