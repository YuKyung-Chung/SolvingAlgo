package Baek_1107_리모컨;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N,M, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //바꿔야 하는 채널
		M = sc.nextInt(); //고장난 버튼의 개수
		
		List<Integer> broken = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			broken.add(sc.nextInt());
		}
		
		List<Integer> button = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			if(!broken.contains(i)) {
				button.add(i);
//				System.out.println(i);
			}
		}
		
		if(N == 100) {
			System.out.println(0);
			return;
		}
		
		String num = String.valueOf(N);
		String after = "";
		//일의 자리부터 체크
		for (int i = num.length()-1; i >= 0; i--) {
			String now = num.substring(i,i+1);
//			System.out.println(now);
			if(button.contains(now)) {
				
			}
		}
		
//		System.out.println(answer);
	}//main
	
	
}
