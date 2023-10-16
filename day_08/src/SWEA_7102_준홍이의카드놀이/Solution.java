package SWEA_7102_준홍이의카드놀이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_7102_준홍이의카드놀이/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트케이스 개수
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] sum = new int[N+M+1]; //N과 M의 합 기록할 배열 선언
			
			// 만들 수 있는 숫자의 합 경우의 수를 sum 배열의 인덱스로 저장
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum[i+j]++;
				}
			}
			
			//최빈값 저장할 변수
			int max = -1;
			//최빈값 찾기
			for (int i = 0; i < sum.length; i++) {
				if(max < sum[i]) {
					max = sum[i];
				}
			}
			
			//정답 저장할 ArrayList 선언
			//정답이 몇개가 들어올지 모르므로 컬렉션 프레임워크 사용
			List<Integer> answer = new ArrayList<>();
			//최빈값에 해당하는 값 answer 에 저장
			for (int i = 0; i < sum.length; i++) {
				if(max == sum[i]) {
					answer.add(i);
				}
			}
			
			//오름차순 정렬
			Collections.sort(answer);
			
			//출력형식에 맞게 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < answer.size(); i++) {
				System.out.print(answer.get(i)+ " ");
			}
			
			
			System.out.println();
		}
	}
}
