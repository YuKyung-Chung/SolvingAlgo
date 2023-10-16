import java.util.Arrays;

//배열을 이용한 최대힙 heap을 만들어 보자~!
//부등호 방향을 반대로 바꾸면 최소힙으로 만들 수 있다.
//힙 push를 할때 값을 부호를 반대로 바꾸어 넣으면 꺼낼때도 반대로 바꾸면 최소힙으로 만들 수 있다.
//전부다 한방에 넣고 한방에 꺼내면 정렬된 모습을 얻을 수 있다. (힙정렬)
public class Tree_02_Heap {
	public static int[] heap = new int[100]; // 완전이진트리 라고 생각할 것!
	public static int heapSize = 0;

	public static void main(String[] args) {
		heapPush(-5);
//		System.out.println(Arrays.toString(heap));
		heapPush(-22);
//		System.out.println(Arrays.toString(heap));
		heapPush(-17);
//		System.out.println(Arrays.toString(heap));
		heapPush(-4038);
		heapPush(-34);
		heapPush(-6);
		System.out.println(Arrays.toString(heap));
		
		while(heapSize != 0) {
			System.out.println(-heapPop());
		}
		
		
	}

	// 힙에 삽입
	public static void heapPush(int item) {
		heap[++heapSize] = item; // 마지막 자리에 삽입

		int ch = heapSize; // 자식
		int p = ch / 2; // 부모

		while (p > 0 && heap[ch] > heap[p]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			//부모 자식을 한레벨 위로 다시 결정
			ch = p;
			p = ch / 2;
		}
	}
	
	//삭제 : 반환 타입은 우리가 heap으로 관리 하고 있는 것으로 한다.
	public static int heapPop() {
		//힙이 공백상태라면?
		if(heapSize <= 0) return -1; //주의 요망!
		
		int item = heap[1]; //루트노드
		heap[1] = heap[heapSize--]; //마지막 값을 루트에 덮어씌우기
		
		int p = 1;
		int ch = p * 2;
		//앞에 조건은 오자가 있다면~~
		if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
			ch += 1; //만약 오자가 더크면 오자로 변경 세팅
		
		//내려가 살수 있는 만큼 내려보내기 
		while(ch<=heapSize && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			p = ch;
			ch = p * 2;
			//앞에 조건은 오자가 있다면~~
			if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
				ch += 1; //만약 오자가 더크면 오자로 변경 세팅
		}
		
		
		return item;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
