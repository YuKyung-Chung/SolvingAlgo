package 순열;

public class 순열01_반복문 {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int N = nums.length;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i != j) {
					for (int k = 0; k < N; k++) {
						if(k != i && k != j) {
							System.out.println(i+""+j+""+k);
						}
					}
				}
			}
		}
	}
}
