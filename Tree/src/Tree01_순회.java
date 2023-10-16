
public class Tree01_순회 {
	public static char[] arr= new char[] {' ','A','B','C','D','E','F','G',' ',' ','H','I'};
	public static int N = arr.length;
	
	public static void main(String[] args) {
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	} //main
	
	//전위순회
	//i : 현재 방문하고 있는 노드 번호
	public static void preorder(int i) {
		//유효한 노드인지는 어떻게 체크?
		if(i < N) {
			if(arr[i] != ' ')
				System.out.print(arr[i] + " ");
			
			preorder(i*2); 	 //L
			preorder(i*2+1); //R
		}
	}
	
	//중위순회
	public static void inorder(int i) {
		if(i<N) {
			inorder(i*2); 	 //L
			if(arr[i] != ' ') {
				System.out.print(arr[i] + " ");
			}
			inorder(i*2+1); //R
		}
	}
	
	//후위순회
	public static void postorder(int i) {
		if(i < N) {
			postorder(i*2);
			postorder(i*2+1);
			if(arr[i] != ' ') {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
