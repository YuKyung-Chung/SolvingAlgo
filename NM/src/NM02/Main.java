package NM02;

import java.util.Scanner;

//1부터 N까지 중복없이 M개를 고른 수열
//수열은 오름차순
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
		
		perm(1,0);
		System.out.println(sb);
	}
	
	public static void perm(int idx, int depth) {
		if(depth == M) {
			for(int i: sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//수열을 오름차순으로 만들기 위해 idx 증가시키면서 시작을 idx로 갱신
		for(int i=idx; i<=N; i++) {
			sel[depth] = i; //현재 깊이를 인덱스로 하여 i값 저장
			perm(i+1, depth+1); //현재 i보다 다음 재귀에서 더 커야하므로 i+1 넘겨주고, 깊이도 1 증가
			
		}
	}
}
