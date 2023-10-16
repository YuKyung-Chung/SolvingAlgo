package Array;

import java.util.Arrays;

public class 전치행렬 {
	static int[][] arr = { {1, 2, 3}, {4, 5, 6},{7, 8, 9} };
	static int N = arr.length;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		System.out.println(Arrays.deepToString(arr)); //�̰͵� �ϳ��� ���
		System.out.println("-----------------------");
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println("---------��ġ���---------");
		//��ġ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i < j) {
					int tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
				
			}
		}
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println("---------��ġ���2---------");
		//��ġ���2
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = tmp;
			}
		}
		
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
