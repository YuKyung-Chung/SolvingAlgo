package SWEA_11315_오목판정;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	static int[] dr = {0, 1, 1, 1}; //우,하,우하향,좌하향
	static int[] dc = {1, 0, 1, -1};
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_11315_오목판정/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		tc: for(int k=1; k<=T; k++) {
			N = sc.nextInt();
			arr = new char[N][N];
			//배열 입력받음
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//o가 나오면 근처 4칸안에 o가 있는지 확인
					//있으면 YES 출력
					if(arr[i][j] == 'o' && check(i,j)) {
						System.out.printf("#%d %s\n",k,"YES");
						continue tc;
					}
				}
			}
			System.out.printf("#%d %s\n",k,"NO");		
		} //tc for문
	} //main

	//근처 4칸 안에 o가 있으면 true 반환
	public static boolean check(int a, int b) {
		//4방향 체크
		dir: for(int i=0; i<4; i++) {
			boolean isTrue = true;
			//4칸씩 체크 
			for(int j=1; j<=4; j++) {
				int nr = dr[i]*j + a;
				int nc = dc[i]*j + b;
				
				//nr, nc가 범위를 벗어나거나 .이 발견되는 false
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] == '.') {
					isTrue = false;
					break;
				} 
			}
			if(isTrue)
				return true;
		}
		return false;
	}
}
