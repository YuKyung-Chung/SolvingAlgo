package SWEA_1204_최빈수구하기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1204_최빈수구하기/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			int num = sc.nextInt();
			int[] students = new int[1000];
			for(int i=0; i<1000; i++) {
				students[i] = sc.nextInt();
			}
			
			int[] scores = new int[101]; //0점 ~100점
			for(int i=0; i<students.length; i++) {
				scores[students[i]] += 1;
			}
			
			//scores에 저장된 수 중 가장 큰 수가 최빈수
			int answer = 0;
			int index = 0;
			for(int i=1; i<scores.length; i++) {
				if(answer <= scores[i]) {
					answer = scores[i];
					index = i;
				}
				
			}
			System.out.printf("#%d %d\n",num,index);
			
		}
	}
}
