package BAEK_10870_피보나치수;

import java.util.Scanner;

public class Solution {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i <= N; i++) {
			fn(i);
		}
		System.out.println(fn(N));
	}//main
	
	public static int fn(int num) {
		if(num < 2) return num;
		return fn(num-2) + fn(num-1);
	}
}
