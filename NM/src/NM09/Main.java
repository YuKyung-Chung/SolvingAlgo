package NM09;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

//N개의 자연수 중에서 M개를 고른 수열
public class Main {
	static int  N,M;
	static int[] sel,nums;
	static boolean[] visited;
	static LinkedHashSet<String> answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		nums = new int[N+1];
		visited = new boolean[N+1];
		answer = new LinkedHashSet<>(); //순서가 저장되어야하므로
		
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		perm(0);
		for (String i : answer) {
			System.out.println(i);
		}
	}
	
	public static void perm(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i: sel) {
				sb.append(i).append(" ");
			}
			answer.add(sb.toString()); //set으로 중복제거
			sb.append("\n");
			return;
		}
		

		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[depth] = nums[i]; //현재 깊이를 인덱스로 하여 i값 저장
				perm(depth+1);
				visited[i] = false;
			}
			
		}
	}
}
