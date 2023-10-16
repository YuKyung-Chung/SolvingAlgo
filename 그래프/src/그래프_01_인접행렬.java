import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//정점의 개수(V)와 간선의 수(E)가 주어진다.
		int V = sc.nextInt();
		int E = sc.nextInt(); 
		
		//인접행렬 
		int[][] adjArr = new int[V+1][V+1]; // 1번~V개의 정점 번호를 이용한다라고 가정
		
		//간선의 정보를 입력받자.
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();//시작정점
			int B = sc.nextInt();//끝정점
			int w = sc.nextInt();//가중치 그래프라고 했을때 가중치 값
			
			adjArr[A][B] = 1; //이렇게 저장 끝? 가중치가 있다면 w / 아니라면 1
			adjArr[B][A] = 1; //무향이라면 필쑤! (유향이라면 생략)
			
			adjArr[A][B] = adjArr[B][A] = 1; //이런식으로 정리도 가넝
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
