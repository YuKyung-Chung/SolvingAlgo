package Array;

public class 이차원배열 {
	public static void main(String[] args) {
		int[][] arr = { {1, 2, 3},
						{4, 5, 6},
						{7, 8, 9} };
		int N = arr.length;
		int M = arr[0].length;
		
		//1. �� �켱 ��ȸ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();
		
		//2. �� ���켱 ��ȸ
		for (int i = 0; i < N; i++) {
			for(int j=M-1; j>=0; j--) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();
		
		//3. �� �켱 ��ȸ
		for (int i = 0; i < M; i++) { //������
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d", arr[j][i]);
			}
		}
		System.out.println();
		
		//4. �� ���켱 ��ȸ
		for (int i = 0; i < M; i++) {
			for (int j = N-1; j >=0; j--) {
				System.out.printf("%3d", arr[j][i]);
			}
		}
		System.out.println();
		
		//5. ������� ��ȸ
		//¦���� �� ������
		//Ȧ���� �� ������
		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				//������
//				if(i % 2 == 0)
//					System.out.printf("%3d", arr[i][j]);
//				//������
//				else
//					System.out.printf("%3d", arr[i][M-1-j]);
//			}
		}
		System.out.println();
		
	}
}
