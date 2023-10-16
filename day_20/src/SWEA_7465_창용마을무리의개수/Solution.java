package SWEA_7465_창용마을무리의개수;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_7465_창용마을무리의개수/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //창용 마을에 사는 사람의 수
			int M = sc.nextInt(); //서로를 알고 있는 사람의 관계 수
			
			p = new int[N+1];
			//makeSet : 자기 자신의 인덱스로 초기화
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				//부모 찾기
				int px = find(u);
				int py = find(v);
				
				//같은 집합이 아니면 뽑음
				if(px != py) {
					//숫자가 작은 쪽이 부모가 되도록 범위 설정
					if(px < py) union(px, py);
					else union(py,px);
				}
				//union 해준 이후에 원래 부모와도 갱신
				for (int j = 1; j <= N; j++) {
					p[j]=p[p[j]];
				}

			}

			HashSet<Integer> set = new HashSet<>();
			//Set에 넣어 중복 값 제거
			for (int i = 1; i <= N; i++) {
				set.add(p[i]);
			}
			
			//Set의 크기를 통해 무리의 개수 출력
			System.out.printf("#%d %d\n",tc,set.size());
		}//tc
	}//main
	
	//합치기
	public static void union(int x, int y) {
		p[y] = x;
	}
	
	//대표자 찾기
	public static int find(int x) {
		//자기 자신의 인덱스로 초기해놓았는데
		//같지 않다면 대표자를 찾아 값 갱신
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
}
