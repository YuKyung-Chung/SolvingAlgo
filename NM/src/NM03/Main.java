package NM03;

import java.util.Scanner;

//1부터 N까지 M개를 고른 수열
//중복가능
public class Main {
	static int  N,M;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
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
		
		for(int i=1; i<=N; i++) {
			sel[depth] = i; //현재 깊이를 인덱스로 하여 i값 저장
			perm(depth+1);
			
		}
	}
}
