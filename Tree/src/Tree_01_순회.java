
public class Tree_01_순회 {
	public static char[] arr = new char[] { '\u0000', 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I' };
	public static int N = arr.length;
	public static void main(String[] args) {
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}
	
	//n : 현재 방문하고 있는 노드 번호 이다.
	public static void preorder(int i) {
		//유효한 노드인지는 어떻게 쳌?
		if(i < N) {
			if(arr[i] != ' ')
				System.out.print(arr[i]+" "); //V
			preorder(i*2);   //L
			preorder(i*2+1); //R
		}
	}
	public static void inorder(int i) {
		//유효한 노드인지는 어떻게 쳌?
		if(i < N) {
			inorder(i*2);   //L
			if(arr[i] != ' ')
				System.out.print(arr[i]+" "); //V
			inorder(i*2+1); //R
		}
	}
	
	//지금부터 1분을 주겠다. 후위 순회 결과 가져오세요.
	public static void postorder(int i) {
		//유효한 노드인지는 어떻게 쳌?
		if(i < N) {
			postorder(i*2);   //L
			postorder(i*2+1); //R
			if(arr[i] != ' ')
				System.out.print(arr[i]+" "); //V
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
