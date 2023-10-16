package 단순연결리스트;

public class SinglyLinkedList {
	private Node head; //노드의 시작점
	private int size; //연결리스트 노드의 개수: 필수는 아니지만 있으면 편함
	
	//아래의 코드는 사실 필요없어! 자바가 알아서해줌
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	//조회
	public Node get(int idx) {
		//0보다 작은 값 들어오면 그냥 첫번째 노드 반환
		//size 이상이 들어오면 그냥 마지막 노드 반환
		if(idx < 0 || idx >= size) {
			return null;
		}
		
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}
	
	//첫번째 위치에 원소 삽입
	public void addFirst(String data) {
		//노드를 생성
		Node node = new Node(data); //생성자 만들어 놨으니 인스턴스 생성 가능
		//순서중요
		node.link = head;
		head = node; //첫번째 요소 가리키는데 넣어
		size++;
		
	}
	
	//중간 원소 삽입
	public void add(int idx, String data) {
		if(idx < 0 || idx >= size) {
			System.out.println("유효하지 않은 인덱스");
			return;
		}
		if(idx == 0) {
			addFirst(data);
			return;
		}
		if(idx == size) {
			addLast(data);
			return;
		}
		
		Node pre = get(idx-1); //조회 함수를 만들어 두었으니 이전 노드 찾는건 쉬움
		Node node = new Node(data);
		node.link = pre.link;
		pre.link = node;
		size++;
		
		
	}
	
	//마지막 위치에 원소 삽입
	public void addLast(String data) {
		//head가 null인건 무슨의미? size=0이고 공백리스트
		if(size == 0) {
			addFirst(data);
			return;
		}
		
		
		Node node = new Node(data);
		
		Node curr = head;
		while(curr.link != null) {
			curr = curr.link;
		}
		curr.link = node;
		size++;
	}
	
	//연결리스트에 내용물을 출력하는 메서드 구현
	public void printList() {
		Node curr = head;
		
		if(head == null) {
			System.out.println("지금은 공백 리스트");
			return;
		}
		
		//size라는 필드를 사용하면 for문 가능
		//size 필드 사용하지 않으면 while문 사용
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.link;
		}
		System.out.println();
	}
	
	
	//첫번째 원소 삭제
	public String remove() {
		if(head == null)
			return null;
		
		String data = head.data;
		head = head.link;
		size--;
		
		return data;
	}
	
	
//	//중간 원소 삭제
//	public String remove(int idx) {
//		if(idx == 0)
//			return remove();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
