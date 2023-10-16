package Greedy;

public class BabyGin {
	public static void main(String[] args) {
		int[] cards = {3,4,5,4,4,4};
		int[] count = new int[12];
		
		for (int i = 0; i < cards.length; i++) {
			count[cards[i]]++;
		}
		
		//i번부터 검사
		int i=0;
		while(i < 10) {
			//triplet 검사
			if(count[i] >= 3) {
				count[i] -= 3;
				System.out.println("triplet이야");
			}
			
			//run 검사
			if(count[i] >= 1 && count[i+1] >= 1 && count[i+2] >= 1) {
				count[i]--;
				count[i+1]--;
				count[i+2]--;
				System.out.println("run이야");
			}
			
			i++;	
		}
	}
}
