package SWEA_1251_하나로_크루스칼;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p; //대표 저장할 배열
	static int[] arr;
	static int N;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1251_하나로_크루스칼/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //전체 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt(); //섬의 개수
			int V = N*(N-1)/2; //최대 간선의 개수
			
			int[][] island = new int[N][3]; //섬 정보
			double[][] tunel = new double[V][3]; //터널 정보
			
			for (int i = 0; i < N; i++) {
				island[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				island[i][1] = sc.nextInt();
			}
			
			double E = sc.nextDouble(); //세율
			
			//간선 배열 만들기
			arr = new int[N];
			for(int i=0; i<N; i++) arr[i] = i;
			
			//부분 조합 구하기
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					tunel[idx][0] = i;
					tunel[idx][1] = j;
					tunel[idx][2] = E * (dist(island[i][0], island[j][0], island[i][1], island[j][1]));
					idx++;
				}
			}
			
			//간선배열의 가중치 기준으로 오름차순 정렬
			Arrays.sort(tunel, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			int pick = 0; //뽑은 간선 개수
			double ans = 0; //가중치 합
			p = new int[N];
			//대표자 makeSet
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			//부모 찾기
			for (int i = 0; i < V; i++) {
				int px = findSet((int)tunel[i][0]);
				int py = findSet((int)tunel[i][1]);
				
				//같은 집합이 아니면 뽑음
				if(px != py) {
					//합치고
					union(px, py);
					ans += tunel[i][2];
					pick++;
				}
				//다 뽑았으면 끝
				if(pick == N-1) break;
			}
			System.out.printf("#%d %d\n", tc, Math.round(ans));
		}//tc
	}//main
	//두 섬 사이에 거리 구하기 메서드
	static double dist(double x1, double x2, double y1, double y2) {
		//피타고라스 정리, 1.0을 곱해주어 double로 변환
		return 1.0*(Math.pow(x1-x2, 2))+(Math.pow(y1-y2, 2));
	}
	static void union(int px, int py) {
		p[py] = px;
	}
	static int findSet(int x) {
		if(p[x] != x) return p[x] = findSet(p[x]);
		return p[x];
	}
}
