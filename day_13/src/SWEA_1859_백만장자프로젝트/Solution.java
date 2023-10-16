package SWEA_1859_백만장자프로젝트;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1859_백만장자프로젝트/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			
			//매매가 입력 받음
			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			int max = -1;
			long count = 0;
			
			//뒤에서부터 max값 갱신하면서 풀자
			for (int i = N-1; i >= 0; i--) {
				//max값 갱신
				if(max <= price[i]) {
					max = price[i];
				}
				
				//max보다 같거나 작으면  차이 값 count에 더함
				if(price[i] <= max) {
					count += (max - price[i]);
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}
