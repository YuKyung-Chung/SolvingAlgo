package SWEA_1225_암호생성기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1225_암호생성기/input.txt");
		Scanner sc = new Scanner(file);
		
		//테스트 케이스 반복
		for (int tc = 1; tc <= 10; tc++) {
			Queue<Integer> q = new LinkedList<>(); //큐 선언
			int T = sc.nextInt(); //테스트 케이스 번호
			
			//큐에 값 입력받음
			for(int i=0; i<8; i++) {
				q.add(sc.nextInt());
			}
			
			cycle: while(true) {
				//한 사이클
				for (int i = 1; i <= 5; i++) {
					int minus = q.poll() - i; //큐 맨앞에서 값 꺼내서 빼줌
					if(minus <= 0) { //뺀 값이 0보다 작거나 같으면
						minus = 0; //0으로 저장
						q.add(minus); //큐에 다시 입력해줌
						break cycle; //0이 나왔으므로 while문 탈출
					}
					q.add(minus); //큐 뒷부분에 계산한 값 추가
				}
			}
			
			//출력
			System.out.printf("#%d ", T);
			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+ " ");
			}
			System.out.println();
			
		} //test case 반복문
	} //main
}
