package SWEA_1238_Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static class Node implements Comparable<Node>{

		@Override
		public int compareTo(Node o) {
			return 0;
		}
		
	}
	
	static int N, st;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1238_Contact/input.txt");
		Scanner sc = new Scanner(file);
		
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt(); //데이터 길이
			st = sc.nextInt(); //시작점
			
			
			
			
		}//tc
	}//main
}
