package 벌꿀채취;

import java.util.Scanner;

public class Solution {
	static int N,M,C,answer;
	static int[][] arr,selected;
	static boolean[][] visited;
	static int[] max = new int[3];
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //�׽�Ʈ ���̽� ����
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //���� ũ��
			M = sc.nextInt(); //������ �� �ִ� ���� ����
			C = sc.nextInt(); //�� ä���� �� �ִ� �ִ� ��
			answer = 0; //�ִ� ���� ������ ����
			selected = new int[N][N];
			
			arr = new int[N][N];
			//���� �迭 �Է¹ޱ�
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			visited = new boolean[N][N];
			find(1,0);
			
			System.out.printf("#%d %d\n",tc,answer);
		}//tc
		
	}//main
	
	public static void find(int cnt,int idx) {
		//������ 2�� ���õǾ�����
		if(cnt == 3) {
			//�ִ� �ʱ�ȭ
			max[1] = max[2] = 0;
			//�ִ� ã��
			setMax();
			//�ִ� ����
			answer = Math.max(answer, max[1] + max[2]);
			return;
		}
		
		int r = idx/N;
		int c = idx%N;
		
		//�׷��� ���� �����ϸ� 
		if(idx>=N*N) return;
		
		//���� 2�� �����ϱ�
		//�׷��� �Ѿ�� ���� ������
		if(c + M > N) {
			find(cnt, idx+M -(idx+M)%N);
		}else {
			//�����ϰ� ���� �� ����
			select(cnt,r,c);
			find(cnt+1,idx+M);
			select(cnt,r,c);
			//�������� �ʰ� ���� ĭ���� ���� �� ����
			find(cnt,idx+1);
		}
		
	}//find
	
	public static void select(int cnt, int r, int c) {
		for (int i = 0; i < M; i++) {
			//select ����
			if(selected[r][c+i] == 0) {
				selected[r][c+i] = cnt;
			}
			//select ����
			else {
				selected[r][c+i] = 0;
			}
		}
	}
	
	public static void setMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(selected[i][j] == 1) {
					if(max[1] != 0) continue;
					combination(1,i,j,0,0);
				}
				else if(selected[i][j] == 2) {
					if(max[2] != 0) continue;
					combination(2,i,j,0,0);
				}
			}
		}
	}
	
	public static void combination(int cnt, int r, int c, int sum, int cost) {
		if(sum > C) {
			return;
		}
		
		max[cnt] = Math.max(max[cnt],cost);
		
		if(c>=N) return;
		if(selected[r][c] != cnt) return;
		
		combination(cnt, r, c+1, sum+arr[r][c], cost+arr[r][c]*arr[r][c]);
		combination(cnt, r, c+1, sum, cost);
		
	}
}
