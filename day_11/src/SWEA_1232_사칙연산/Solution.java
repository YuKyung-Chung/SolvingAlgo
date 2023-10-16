package SWEA_1232_사칙연산;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static String[] eq;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1232_사칙연산/input.txt");
		Scanner sc = new Scanner(file);
		
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); //정점개수
			
			eq = new String[N+1];
			
			for (int i = 1; i <= N; i++) {
				int node = sc.nextInt();
				String str = sc.next();
				//연산자인 경우
				if(str.equals("-") || str.equals("+") || str.equals("*") || str.equals("/")) {
					eq[i] = str;
					sc.nextInt();
					sc.nextInt();
				}
				//숫자인 경우 배열에 String으로 저장
				else {
					eq[i] = str;
				}
			}
			
//			inorder(1);
			System.out.println(Arrays.toString(eq));
			
		}//tc
	}//main
	
	public static void inorder(int i) {
		if(i <= N) {
			inorder(2*i);
			if(eq[i].equals("-")) {
//				eq[i] = String.valueOf(Integer.valueOf(eq[2*i]) - Integer.valueOf(eq[2*i+1]));
			} else if(eq[i].equals("+")) {
//				eq[i] = String.valueOf(Integer.valueOf(eq[2*i]) + Integer.valueOf(eq[2*i+1]));
			} else if(eq[i].equals("*")) {
//				eq[i] = String.valueOf(Integer.valueOf(eq[2*i]) * Integer.valueOf(eq[2*i+1]));
			} else if(eq[i].equals("/")) {
//				eq[i] = String.valueOf(Integer.valueOf(eq[2*i]) / Integer.valueOf(eq[2*i+1]));
			}
			inorder(2*i+1);
		}
	}
}
