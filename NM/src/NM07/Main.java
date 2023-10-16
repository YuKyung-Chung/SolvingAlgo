package NM07;

import java.util.Arrays;
import java.util.Scanner;

//N개의 자연수 중에서 M개를 고른 수열
public class Main {
	static int  N,M;
	static int[] sel,nums;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		nums = new int[N];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int depth) {
		if(depth == M) {
			for(int i: sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//중복허용
		for(int i=0; i<N; i++) {
			sel[depth] = nums[i]; //현재 깊이를 인덱스로 하여 i값 저장
			perm(depth+1);
		}
	}
}
