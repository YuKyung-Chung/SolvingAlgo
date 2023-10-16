package SWEA_1228_암호문1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	//노드 구현
	public static class Node {
		String data;
		Node link;
		
		public Node() {};
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	//노드를 이용한 LinkedList 정의
	public static class LinkedList{
		Node head;
		int size;
		
		public LinkedList() {
			
		}
		
		//맨 앞에 값 추가
		//새로운 노드가 맨앞(head)이 가리키던 link를 가리키게 한다
		//head를 바꿔준다
		public void addFirst(String data) {
			Node node = new Node(data);
			
			node.link = head;
			head = node;
			size++;
		}
		
		//마지막에 위치한 노드를 찾아 새로운 노드와 연결
		public void addLast(String data) {
			if(head == null) {
				addFirst(data);
				return;
			}
			
			Node node = new Node(data);
			Node curr = head;
			
			while(curr.link != null)
				curr = curr.link;
			curr.link = node;
			size++;
		}
		
		public void add(int idx, String data) {
			if(idx < 0 || idx > size) return;
			
			if(idx == 0) {
				addFirst(data);
				return;
			}
			
			if(idx == size) {
				addLast(data);
				return;
			}
			
			Node curr = head;
			
			for (int i = 0; i < idx-1; i++) {
				curr = curr.link;
			}
			Node node = new Node(data);
			
			node.link = curr.link;
			curr.link = node;
			
			size++;
		}
		
		//최대 10개까지 출력
		public void printList() {
			Node curr = head;
			int cnt = 0;
			
			while(curr.link != null && cnt++ < 10) {
				System.out.print(curr.data + " ");
				curr = curr.link;
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1228_암호문1/input.txt");
		Scanner sc = new Scanner(file);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int N = sc.nextInt(); //원본 암호문의 길이
			
			LinkedList list = new LinkedList();
			
			//원본 암호문 저장
			for(int i=0; i<N; i++)
				list.addLast(sc.next());
			
			int count = sc.nextInt(); //명령어 개수
			for(int i=0; i<count; i++) {
				String order = sc.next();
				if(order.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();

					for (int j = 0; j < y; j++) {
						list.add(x+j, sc.next());
					}
				}
			}
			
			System.out.printf("#%d ", tc);
			list.printList();
			
		} //tc
		
	}
}
