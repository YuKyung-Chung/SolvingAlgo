package 부분집합_조합;

import java.util.Arrays;

public class 조합02 {
	public static String[] 토핑 = {"상추","패티","토마토","치즈","새우"};
	public static int N = 5;
	public static int R = 3; //문제에서 판단할 수 있는 부분들
	public static String[] sel = new String[R];
	
	public static void main(String[] args) {
		combination(0,0);
	}
	
	
	// idx  : 토핑의 시작 index
	// sidx : sel의 index
	public static void combination(int idx, int sidx) {
		// 기저파트
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = idx; i <= N-R+sidx; i++) {
			sel[sidx] = 토핑[i];
			combination(i+1, sidx+1);
		}
				
	}
}

