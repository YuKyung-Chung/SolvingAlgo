package SWEA_1216_회문2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1216_회문2/input.txt");
		Scanner sc = new Scanner(file);
		
		//테스트 케이스 10개
		for(int k=1; k<=10; k++) {
			int TestCase = sc.nextInt();
			
			String[][] arr = new String[100][100];
			//배열에 값 입력 받기
			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = str.substring(j,j+1);
				}
			}
			
			int count = 0; //최대 길이 저장할 변수
			
			//가로순회(뒤에서부터)
			for(int i = 0; i < 100; i++) {
				int j = 100;
				while (j > 0) {
					StringBuilder str1 = new StringBuilder();
					StringBuilder str2 = new StringBuilder();
						
					//절반 나눠서 앞부분 StringBuilder에 저장
					for (int l = 0; l < j/2; l++) {
						str1.append(arr[i][l]).toString();
					}
					//절반 나눠서 뒷부분 StringBuilder에 저장
					for (int l = j/2; l < j; l++) {
						str2.append(arr[i][l]).toString();
					}
					//하나 뒤집어서 같은지 비교하고 길이 count에 저장
					if(str1.toString().equals(str2.reverse().toString())) {
						count = Math.max(count, str1.length());
						break;
					}
					j--;
				}//while문
			} //가로순회(뒤에서부터)
					
			
			//세로순회
			for(int i = 0; i < 100; i++) {
				int j2 = 100;
				while (j2 > 0) {
					StringBuilder str1 = new StringBuilder();
					StringBuilder str2 = new StringBuilder();
					
					//절반 나눠서 앞부분 StringBuilder에 저장
					for (int l = 0; l < j2/2; l++) {
						str1.append(arr[l][i]).toString();
					}
					//절반 나눠서 뒷부분 StringBuilder에 저장
					for (int l = j2/2; l < j2; l++) {
						str2.append(arr[l][i]).toString();
					}
					//하나 뒤집어서 같은지 비교하고 길이 count에 저장
					if(str1.toString().equals(str2.reverse().toString())) {
						count = Math.max(count, str1.length());
						break;
					}
				}
				j2--;
				}
				//출력
				System.out.printf("#%d %d\n", TestCase, count);
			} 
	} //main
}
