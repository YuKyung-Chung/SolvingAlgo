package BruteForce;

public class BabyGin {
	public static void main(String[] args) {
		//0~9 사이의 숫자 카드에서 임의의 카드 6장을 뽑았을 때,
		//3장의 카드가 연속적인 번호를 갖는 경우를 run
		//3장의 카드가 동일한 번호를 갖는 경우를 triplet
		//6장의 카드가 run과 triplet로만 구성된 경우를 baby-gin으로 부른다
		//6자리의 숫자를 입력 받아 baby-gin 여부를 판단
		
		int[] cards = {3, 4, 5};
		int N = 3;
		
		//순열 반복문 이용해서 만들기
		//첫번째 카드 뽑는 경우
		for (int i = 0; i < N; i++) {
			//두번째 카드 뽑는 경우
			for (int j = 0; j < N; j++) {
				//i와 j가 같지 않을 때
				if(i != j) {
					//세번째 카드 뽑는 경우
					for (int j2 = 0; j2 < N; j2++) {
						if(j2 != i && j2 != j) {
							System.out.printf("%d %d %d\n",cards[i],cards[j],cards[j2]);
							
							System.out.println(runCheck(cards[i],cards[j],cards[j2]));
						}
					}
				}		
			}
		}
	}
	
	//run : 세개의 숫자가 연속된 숫자인지 검사
	public static boolean runCheck(int a, int b, int c) {
//		if(b == a + 1 && c == a + 2) {
//			return true;
//		}
//		return false;
		return b == a + 1 && c == a + 2;
	}
	
	//triplet : 세개의 숫자가 같은 숫자인지 검사
	public static boolean tripletCheck(int a, int b, int c) {
		return a == b && b == c;
	}
}
