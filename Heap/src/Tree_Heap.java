import java.util.Arrays;

// 배열을 이용한 최대 힙을 만들어보자.
// 부등호 방향을 반대로 바꾸면 최소힙으로 만들 수 있다.
// 힙 push를 할 때 값의 부호를 반대로 바꾸어 넣고, 꺼낼 때도 부호 바꾸면 최소힙으로 만들 수 있다.
public class Tree_Heap {
	public static int[] heap = new int[100]; //완전이진트리라고 생각할 것
	public static int heapSize = 0;
	
	public static void main(String[] args) {
		heapPush(5);
		System.out.println(Arrays.toString(heap));
		heapPush(22);
		System.out.println(Arrays.toString(heap));
		heapPush(4023);
		System.out.println(Arrays.toString(heap));
		heapPush(17);
		System.out.println(Arrays.toString(heap));
		
		while(heapSize != 0) {
			System.out.println(heapPop());
		}
	}
	
	//힙에 삽입
	public static void heapPush(int item) {
		heap[++heapSize] = item; //마지막 자리에 삽입
		
		int ch = heapSize; //자식
		int p = ch/2; //부모
		
		//부모의 인덱스가 0보다 크고
		//자식의 값이 부모의 값 보다 클 때 스위치
		while(p > 0 && heap[ch] > heap[p]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			//부모 자식을 한레벨 위로 다시 결정
			ch = p;
			p = ch / 2;
		}
	} //삽입
	
	//삭제 : 반환 타입은 우리가 heap으로 관리하고 있는 것으로 한다
	public static int heapPop() {
		//힙이 공백이라면?
		if(heapSize <= 0) return -1; //주의요망
		
		int item = heap[1]; //루트노드
		heap[1] = heap[heapSize--]; //마지막 값을 루트에 덮어씌우기
		
		int p = 1;
		int ch = p * 2;
		//오른쪽 자식이 있다면
		if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
			ch += 1; //만약 오자가 더 크면 오자로 변경 세팅
		
		//내려갈수 있는 만큼 내려보내기
		while(ch <= heapSize && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			p = ch;
			ch = p * 2;
			
			//오른쪽 자식이 있다면
			if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
				ch += 1; //만약 오자가 더 크면 오자로 변경 세팅
		}
		return item;
	} //삭제
	
	
}
