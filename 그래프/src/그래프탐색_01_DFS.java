
public class 그래프탐색_01_DFS {
	static int N = 7;
	//인접행렬 저장할 수 있어야해
	static int[][] adj = { 
			{ 0, 1, 1, 0, 0, 1, 0 }, 
			{ 1, 0, 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0, 0 } };
	
	static boolean[] visited = new boolean[N]; //방문처리를 할 배열
	
	public static void main(String[] args) {
		//실제 문제를 푸는 것이였으면 요기서 new를 하는게 맞다.
		DFS(0);
	}
	
	//인자로 현재 내가 방문하고 있는 정점이 들어온다.
	static void DFS(int v) {
		//v에 대한 방문처리를 하겠다.
		visited[v] = true;
		System.out.println(v+1); //교재랑 맞출려고 출력만 +1 한것!!!
		
		//방문하지 않았으면서, 너와 내가 연결된 간선이 존재한다면 재귀호출
		for(int i = 0 ; i<N; i++) {
			if(!visited[i] && adj[v][i] == 1) {
				DFS(i);
			}
		}
		
	}
}
