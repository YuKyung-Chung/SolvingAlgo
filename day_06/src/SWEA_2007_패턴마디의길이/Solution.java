package SWEA_2007_패턴마디의길이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//문자열을 입력받아 마디의 길이를 출력하자.
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_2007_패턴마디의길이/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for(int tc=1; tc <= T; tc++) {
			//길이가 30인 문자열
			char[] arr = sc.next().toCharArray();
			String str1 = "";
			String str2 = "";
			int length = 0;
			
			for(int i=0; i<arr.length; i++) {
				//마디 최대 길이는 10
				int madi = 10;
				for(int j=0; j<madi; j++) {
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, length);
		}
	}
}
