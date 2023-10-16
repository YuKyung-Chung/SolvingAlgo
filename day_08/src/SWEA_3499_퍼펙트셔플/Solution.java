package SWEA_3499_퍼펙트셔플;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_3499_퍼펙트셔플/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			Queue<String> answer = new LinkedList<>();
			//N이 짝수일때
			if(N % 2 ==0) {
				Queue<String> q1 = new LinkedList<>();
				Queue<String> q2 = new LinkedList<>();
				
				for (int i = 0; i < N/2; i++) {
					q1.add(sc.next());
				}
				for (int i = N/2; i < N; i++) {
					q2.add(sc.next());
				}
				
				for (int i = 0; i < N/2; i++) {
					answer.add(q1.poll());
					answer.add(q2.poll());
				}
			} //N이 짝수
			//N이 홀수일때
			else {
				Queue<String> q1 = new LinkedList<>();
				Queue<String> q2 = new LinkedList<>();
				
				for (int i = 0; i < N-(N/2); i++) {
					q1.add(sc.next());
				}
				for (int i = N-(N/2); i < N; i++) {
					q2.add(sc.next());
				}
				
				while(!q1.isEmpty()){
					if(!q1.isEmpty()) {
						answer.add(q1.poll());
					}
					if(!q2.isEmpty()) {
						answer.add(q2.poll());
					}
				}
			} //N이 홀수
			
			System.out.printf("#%d ", tc);
			for(String s : answer) {
				System.out.print(s+" ");
			}
			System.out.println();
			
		} //test case 반복문
	} //main
}
