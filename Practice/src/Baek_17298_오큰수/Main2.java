package Baek_17298_오큰수;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> s = new Stack<>();
		
		boolean isTrue;
		int answer;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				s.push(arr[j]);
			}
			int a = arr[i];
			isTrue = false;
			answer = 0;
			while(!s.isEmpty()) {
				int b = s.pop();
				if(a < b) {
					answer = b;
					isTrue = true;
				}
				
			}
			if(isTrue)
				sb.append(answer).append(" ");
			else
				sb.append(-1).append(" ");
			
		}
		System.out.println(sb);
		
	}
}
