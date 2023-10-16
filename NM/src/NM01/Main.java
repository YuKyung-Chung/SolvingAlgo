package NM01;

import java.util.Scanner;

//1부터 N까지 중복없이 M개를 고른 수열
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
			if(!visited[i]) {
				visited[i] = true;
				sel[depth] = i; //해당 깊이를 index로 하여 i 값 저장
				perm(depth+1); //다음 자식 노드 호출위해 depth 1증가
				
				//자식 노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
				visited[i] = false;
			}
			
		}
	}
}
