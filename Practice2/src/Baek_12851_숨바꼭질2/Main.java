package Baek_12851_숨바꼭질2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int cnt;
	static List<Integer> answer = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		BFS(N);
		
		System.out.println(cnt+"번");
		for (int i : answer) {
			System.out.println(i);
		}
	}//main
	
	public static void BFS(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k < a; k++) {
				int now = q.poll();
				
				if(now == K) {
					answer.add(now);
				}
				
				if(now * 2 <= 200000) {
					q.add(now*2);
				}
				if(now + 1 <= 200000) {
					q.add(now+1);
				}
				if(now - 1 >= 0) {
					q.add(now-1);
				}
				
				
			}
			cnt++;
			
		}
		
		
	}
}
