package Array;

public class Delta {
	static int[][] arr = { {1, 2, 3}, {4, 5, 6},{7, 8, 9} };
	static int N = arr.length;
	
	public static void main(String[] args) {
		//현재 나의 좌표
		int r = 2;
		int c = 1;
		
		//상하좌우 : 문제에서 주어진 방향이 있으면 그것을 따르고 없으면 내맘
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		//한방에 2차원 배열로 작성하려면
		int[][] drc = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; //현재 d방향으로 이동한 곳의 값을 알고 시퍼
			int nc = c + dc[d];
			
			//2차원 배열 이용하는 방법
//			int nr2 = r + drc[d][0];
//			int nc2 = c + drc[d][1];
			
			//1. 벗어나는 범위 체크해서 제외하기
//			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
//				System.out.println(arr[nr][nc]);
//			}
			
			//2. 하나라도 만족하면 continue로 넘기기
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			System.out.println(arr[nr][nc]);
			
			//다음 좌표의 값을 비교하고 그리고 범위체크 (위험)
			//범위 체크하고 다음 좌표의 값을 비교 (안전)
		}
	}//main
	
	public static boolean isRange(int nr, int nc) {
		if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
			return false;
		}
		return true;
	}
	
	public static boolean isRange2(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	
	
	
}
