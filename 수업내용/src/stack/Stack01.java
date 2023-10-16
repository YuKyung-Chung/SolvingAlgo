package stack;

public class Stack01 {
	public static int[] stack = new int[5];
	public static int top = -1;
	
	public static void main(String[] args) {
		//예시 작성해보고 확인해보자.
	}
	//포화상태 체크
	public static boolean isFull() {
		return top == stack.length -1;
	}
	
	//공백상태 체크
	public static boolean isEmpty() {
		if(top == -1) return true;
		return false;
	}
	
	//삽입
	public static void push(int value) {
		//배열로 만든 스택이므로 작업한개가 추가된다
		if(isFull()) {
			System.out.println("가득 차서 더이상 넣을 수 없다.");
		} else {
			top++;
			stack[top] = value;
			//stack[++top] = value; 이것도됨
		}
		//return; 생략되어 있음
	}
	
	//삽입2
	public static void push2(int value) {
		//배열로 만든 스택이므로 작업한개가 추가된다
		if(isFull()) {
			System.out.println("가득 차서 더이상 넣을 수 없다.");
		}
	}
	
	public static int pop() {
		if(isEmpty()) {
			System.out.println("자료가 텅텅 비어 꺼낼 것이 없다.");
			return -1; //이건 주의 요망
		}
//		int value = stack[top];
//		top--;
//		return value;
		
		//어차피 top 변수가 다시 데이터 덮게끔 도와주니까 놔둔다.
		return stack[top--];
	}
	
	//top이 가리키고 있는 위치 값 확인
	public static int peek() {
		if(isEmpty()) {
			System.out.println("자료가 텅텅이야");
			return -1;
		}
		return stack[top];
	}
	
}
