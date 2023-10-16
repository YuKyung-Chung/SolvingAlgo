package SWEA_1217_거듭제곱;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int N,M;
	static int answer;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1217_거듭제곱/input.txt");
		Scanner sc = new Scanner(file);
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.printf("#%d %d\n",tc,pow(M));
			
		}//tc
	}//main
	
	public static int pow(int M) {
		if(M == 1) {
			return N;
		}
		return N * pow(M-1);
	}
}
