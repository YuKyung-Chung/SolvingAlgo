package SWEA_1952_수영장;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int[] prices, plans;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1952_수영장/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			//가격 정보 입력받기 
			int day = sc.nextInt();
			int month = sc.nextInt();
			int quarter = sc.nextInt();
			int year = sc.nextInt();
			
			plans = new int[13];
			//이용 계획 입력받기
			for (int i = 1; i < plans.length; i++) {
				plans[i] = sc.nextInt();
			}
			
			int[] price = new int[13];
			//일간 vs 월간 이용권 비교
			for (int i = 1; i < 13; i++) {
				price[i] = Math.min(day*plans[i], month);
			}
			
			//3개월권과 비교
			for (int i = 1; i < 13; i++) {
				if(i<3) {
					price[i] += price[i-1]; //price[0]=0이므로
				}else {
					price[i] = Math.min(price[i-3]+quarter, price[i-1]+ price[i]);
				}
			}
			
			//연간 이용권과의 비교
			System.out.printf("#%d %d\n",tc,Math.min(price[12], year));
		}//tc
		
	}//main
	
	
}
