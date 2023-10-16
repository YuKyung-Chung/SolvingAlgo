package SWEA_8931_제로;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] stack = new int[100000];
	//top
	static int top = -1;
	
	//push
	static void push(int i) {
		stack[++top] = i;
	}
	
	//pop
	static int pop() {
		return stack[top--];
	}
	
	//isEmpty
	static boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_8931_제로/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for(int tc=1; tc<=T; tc++) {
			int K = sc.nextInt(); // K개 줄
			
			stack = new int[K];
			//배열에 값 채우기
			for(int i=0; i<K; i++) {
				int num = sc.nextInt();
				if(num != 0) { //0이 아닌 경우
					push(num);
				} else { //0인 경우
					pop();
				}
			}
			
			//스택에 남은 수 총합 구하기
			int sum = 0;
			while(!isEmpty()) {
				sum += pop();
			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		} //테스트 케이스 반복
	}//main	
}
