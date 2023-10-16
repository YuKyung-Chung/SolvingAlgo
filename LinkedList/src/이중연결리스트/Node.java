package 이중연결리스트;

//데이터 필드, 다음 노드를 가리키는 링크필드 한개가 존재한다.
public class Node {
	public String data; //예시로 문자열 넣음
	public Node link; //주소를 저장할 것이라 Node라고 하는 자료형 사용

	//기본 생성자
	public Node() {}
	
	public Node(String data) {
		this.data = data;
//		this.link = null; 이거 안써도 되는 부분. 어차피 null로 초기화되므로
	}
	
}
