package 부분집합_조합;

import java.util.Arrays;

public class 조합01 {
	public static String[] 토핑 = {"상추","패티","토마토","치즈","새우"};
	public static int N = 5; //배열 전체 크기
	public static int R = 2; //R개를 뽑는 경우의 수
	public static String[] sel = new String[R]; //조합 임시 저장될 배열
	
	public static void main(String[] args) {
		combination(0,0);
	} 

	// idx  : 토핑의 index
	// sidx : sel의 index
	public static void combination(int idx, int sidx) {
		//기저파트
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) return;
		
		//재귀파트
		sel[sidx] = 토핑[idx]; //해당 재료 넣기
		combination(idx+1, sidx+1); //idx 번째 재료 뽑은거
		combination(idx+1, sidx); //idx 번째 재료 안뽑은거
				
	}
}

