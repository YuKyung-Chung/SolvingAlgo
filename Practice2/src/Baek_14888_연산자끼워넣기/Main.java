package Baek_14888_연산자끼워넣기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, maxCal, minCal;
	static int[] A;
	static int[] calc = new int[4];
	static String[] operator;
	static String[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		maxCal = Integer.MIN_VALUE;
		minCal = Integer.MAX_VALUE;
		
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			calc[i] = sc.nextInt();
		}
		
		List<String> temp = new ArrayList<>();
		if(calc[0] != 0) {
			for (int i = 0; i < calc[0]; i++) {
				temp.add("+");
			}
		}
		if(calc[1] != 0) {
			for (int i = 0; i < calc[1]; i++) {
				temp.add("-");
			}
		}
		if(calc[2] != 0) {
			for (int i = 0; i < calc[2]; i++) {
				temp.add("*");
			}
		}	
		if(calc[3] != 0) {
			for (int i = 0; i < calc[3]; i++) {
				temp.add("/");
			}
		}
		operator = temp.toArray(new String[N-1]);
		sel = new String[N-1];
//		System.out.println(Arrays.toString(operator));
		
		visited = new boolean[N];
		perm(0); //기호 순열 만들기
		
		System.out.println(maxCal);
		System.out.println(minCal);
	}//main
	
	public static void perm(int idx) {
		if(idx==N-1) {
//			System.out.println(Arrays.toString(sel));
			
			//기호 순열 완료 됐으므로 계산하기
			//최댓값, 최솟값 갱신하기
			maxCal = Math.max(maxCal, calculate(sel));
			minCal = Math.min(minCal, calculate(sel));
			return;
		}
		
		//기호 순열 만들기
		for (int i = 0; i < N-1; i++) {
			if(visited[i]) continue;
			
			sel[i] = operator[idx];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
		
	}
	
	public static int calculate(String[] sel) {
		int sum = 0;
		for (int i = 0; i < N-1; i++) {
			if(sel[i].equals("+")) {
				sum += (A[i] + A[i+1]);
			}
			else if(sel[i].equals("-")) {
				sum += (A[i] - A[i+1]);
			}
			else if(sel[i].equals("*")) {
				sum += (A[i] * A[i+1]);
			}
			else if(sel[i].equals("/")) {
				if(A[i] < 0 && A[i+1] > 0) {
					sum += -((-A[i])/A[i+1]);
				}else if(A[i] > 0 && A[i+1] < 0) {
					sum += -(A[i]/(-A[i+1]));
				}
				
				else
					sum += (A[i] / A[i+1]);
			}
		}
		return sum;
	}
}
