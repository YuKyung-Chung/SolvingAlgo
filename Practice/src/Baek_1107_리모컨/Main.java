package Baek_1107_리모컨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int min; //최소로 눌러야 하는 버튼 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //이동하려고 하는 채널
		M = sc.nextInt(); //고장난 버튼 개수
		
		List<Integer> broken = new ArrayList<>(); //고장난 버튼 
		for (int i = 0; i < M; i++) {
			broken.add(sc.nextInt());
		}
		List<Integer> button = new ArrayList<>();  //고장 안 난 버튼
		for (int i = 0; i < 10; i++) {
			if(broken.contains(i)) continue;
			else {
				button.add(i);
			}
		}
		
		int start = 0;
		
		
		
	}//main
}
