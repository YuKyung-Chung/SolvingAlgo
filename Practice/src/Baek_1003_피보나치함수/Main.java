package Baek_1003_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt0, cnt1, N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); 
			arr =new int[N+1];
			cnt0 = 0;
			cnt1 = 0;
			
			arr[0] = 0;
			arr[1] = 1;
			
			fibonacci(N);
			System.out.println(cnt0+" "+cnt1);
		}
		
	}//main
	
	public static void fibonacci(int n) {
		if(n==0) {
			cnt0++;
			return;
		} else if(n==1) {
			cnt1++;
			return;
		}else if(n<0) return;
		else {
			for (int i = 2; i <= n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
	}
}
