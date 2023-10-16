package Array;

public class Delta {
	static int[][] arr = { {1, 2, 3}, {4, 5, 6},{7, 8, 9} };
	static int N = arr.length;
	
	public static void main(String[] args) {
		//���� ���� ��ǥ
		int r = 2;
		int c = 1;
		
		//�����¿� : �������� �־��� ������ ������ �װ��� ������ ������ ����
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		//�ѹ濡 2���� �迭�� �ۼ��Ϸ���
		int[][] drc = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; //���� d�������� �̵��� ���� ���� �˰� ����
			int nc = c + dc[d];
			
			//2���� �迭 �̿��ϴ� ���
//			int nr2 = r + drc[d][0];
//			int nc2 = c + drc[d][1];
			
			//1. ����� ���� üũ�ؼ� �����ϱ�
//			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
//				System.out.println(arr[nr][nc]);
//			}
			
			//2. �ϳ��� �����ϸ� continue�� �ѱ��
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			System.out.println(arr[nr][nc]);
			
			//���� ��ǥ�� ���� ���ϰ� �׸��� ����üũ (����)
			//���� üũ�ϰ� ���� ��ǥ�� ���� �� (����)
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
