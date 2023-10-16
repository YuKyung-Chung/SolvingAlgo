package 부분집합_조합;

import java.util.Arrays;

public class 부분집합01 {
	public static String[] 재료 = {"오이","참치","햄","우엉"};
	
	public static void main(String[] args) {
		int N = 4;
		int[] sel = new int[N];
		
		//for문으로 만들면 4중 for문 필요함
		for (int i = 0; i < 2; i++) {
			sel[0] = i;
			for (int j = 0; j < 2; j++) {
				sel[1] = j;
				for (int j2 = 0; j2 < 2; j2++) {
					sel[2] = j2;
					for (int k = 0; k < 2; k++) {
						sel[3] = k;
						System.out.println(Arrays.toString(sel));
						for (int k2 = 0; k2 < N; k2++) {
							if(sel[k2]==1)
								System.out.print(재료[k2]);
						}
						System.out.println(": 김밥");
					}
				}
				
			}
		}
		
		
		
		
		
		
		
		
	}//main
}
