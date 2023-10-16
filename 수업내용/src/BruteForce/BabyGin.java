package BruteForce;

public class BabyGin {
	public static void main(String[] args) {
		//0~9 ������ ���� ī�忡�� ������ ī�� 6���� �̾��� ��,
		//3���� ī�尡 �������� ��ȣ�� ���� ��츦 run
		//3���� ī�尡 ������ ��ȣ�� ���� ��츦 triplet
		//6���� ī�尡 run�� triplet�θ� ������ ��츦 baby-gin���� �θ���
		//6�ڸ��� ���ڸ� �Է� �޾� baby-gin ���θ� �Ǵ�
		
		int[] cards = {3, 4, 5};
		int N = 3;
		
		//���� �ݺ��� �̿��ؼ� �����
		//ù��° ī�� �̴� ���
		for (int i = 0; i < N; i++) {
			//�ι�° ī�� �̴� ���
			for (int j = 0; j < N; j++) {
				//i�� j�� ���� ���� ��
				if(i != j) {
					//����° ī�� �̴� ���
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
	
	//run : ������ ���ڰ� ���ӵ� �������� �˻�
	public static boolean runCheck(int a, int b, int c) {
//		if(b == a + 1 && c == a + 2) {
//			return true;
//		}
//		return false;
		return b == a + 1 && c == a + 2;
	}
	
	//triplet : ������ ���ڰ� ���� �������� �˻�
	public static boolean tripletCheck(int a, int b, int c) {
		return a == b && b == c;
	}
}
