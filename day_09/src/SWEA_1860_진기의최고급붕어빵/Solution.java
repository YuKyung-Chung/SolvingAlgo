package SWEA_1860_진기의최고급붕어빵;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1860_진기의최고급붕어빵/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //손님 수
			int M = sc.nextInt(); //시간
			int K = sc.nextInt(); //시간 당 만드는 붕어빵 수
			
			int[] people = new int[N];
			for (int i = 0; i < N; i++) {
				people[i] = sc.nextInt();
			}
//			people[0] = sc.nextInt();
//			
//			
//			//삽입정렬
//			for (int i = 1; i < N; i++) {
//				int input = sc.nextInt();
//				int j = i;
//				//새로 들어온 input이 바로 앞에 있는 것보다 작으면
//				while(j > 0 && input < people[j-1]) {
//					//j를 왼쪽으로 당기고, 앞에 있는 걸 한칸 뒤로 민다.
//					people[j] = people[j-1];
//					j--;
//				}
//				//앞에 있는게 없을 때 (j=0) 맨 앞에 input을 넣고
//				//앞으로 당기다가 삽입할 위치를 찾으면 (input >= input[j-1])
//				//
//				people[j] = input;
//			}
			
			boolean flag = true;
			
			int count = 0;
			int preTime = 0;
			
			for (int i = 0; i < N; i++) {
				//i번째 사람이 오는 시간
				int time = people[i];
				int pre = (preTime/M)*K;
				int now = (time/M)*K;
				count += now - pre;
				count--;
				
				if(count < 0)
					flag = false;
				preTime = time;
			}
			
			
			if(flag) {
				System.out.printf("#%d %s\n",tc,"Possible");
			}else if(!flag) {
				System.out.printf("#%d %s\n",tc,"Impossible");
			}
		}
	}
}
