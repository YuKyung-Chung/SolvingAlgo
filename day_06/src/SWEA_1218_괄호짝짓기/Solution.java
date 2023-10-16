package SWEA_1218_괄호짝짓기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static boolean[] isTrue = new boolean[4]; //'()', '[]', '{}', '<>'
	static int[] stack = new int[4];
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1218_괄호짝짓기/input.txt");
		Scanner sc = new Scanner(file);
		
		//테스트 케이스 개수
		for(int k=1; k<=10; k++) {
			int N = sc.nextInt(); //테스트케이스 길이
			String str = sc.next();
			
			for(int i=0; i<N; i++) {
				String s = str.substring(i,i+1);
				findPair(s);
			}
			
			for(int i=0; i<stack.length; i++) {
				if(stack[i] == 0)
					isTrue[i] = false; //유효함
				else
					isTrue[i] = true; //유효하지 않음
			}
			
			boolean answer = false;
			//1 유효 0 유효하지 않음
			for(int i=0; i<isTrue.length; i++) {
				if(isTrue[i] == true) {
					answer = true; //유효하지 않음
				}
			}
			
			if(answer == false) { //유효함
				System.out.printf("#%d %d\n", k, 1);
			} else { //유효하지 않음
				System.out.printf("#%d %d\n", k, 0);
			}
			
		} //test case
		
		
	} //main
	
	
	public static void findPair(String str) {
		if(str.equals("(")) {
			stack[0]++;
		}else if(str.equals(")")) {
			stack[0]--;
		}else if(str.equals("[")) {
			stack[1]++;
		}else if(str.equals("]")) {
			stack[1]--;
		}else if(str.equals("{")) {
			stack[2]++;
		}else if(str.equals("}")){
			stack[2]--;
		}else if(str.equals("<")) {
			stack[3]++;
		}else if(str.equals(">")) {
			stack[3]--;
		}
		return;
	} //findPair 메소드
	
	
}
