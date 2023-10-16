package SWEA_1873_배틀필드;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int H,W; //행,열
	static String[][] field; //배틀필드
	static int input; //사용자가 명령할 개수
	static String[] order; //명령어 입력 받을 배열
	static int dir = -1; //위1 아래2 왼쪽3 오른쪽4
	static int wall = -1; //평지1 벽돌2 강철3 물4
	static int x,y; //전차의 현재 위치 저장할 변수
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1873_배틀필드/input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		tc: for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			
			field = new String[H][W];
			//배틀필드 입력받기
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					field[i][j] = str.substring(j,j+1);
				}
			}
			
			input = sc.nextInt(); //사용자가 넣을 입력 개수
			String tmp = sc.next();
			order = new String[input]; //사용자의 입력
			for (int i = 0; i < input; i++) {
				order[i] = tmp.substring(i,i+1);
			}
			
			//전차의 현재 인덱스 저장할 변수
			x=0;
			y=0;
			//처음 시작점 찾기
			findDir: for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					Direction(i,j);
					x=i;
					y=j;
					if(dir != -1)
						break findDir;
				}
			}
			
			//order
			for (int i = 0; i < order.length; i++) {
				Battle(order[i]);
			}
			
			//출력
			System.out.printf("#%d ",tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
			
		}//tc
	}//main
	
	//위1 아래2 왼쪽3 오른쪽4
	//평지1 벽돌2 강철3 물4
	public static void Battle(String order) {
		//경계 밖으로 나가지 않음
		//포탄 발사 시(S), 벽돌벽(*) 또는 강철벽(#)에 충돌하거나 맵 밖까지 직전
		//벽돌벽(*)이라면 파괴되어 평지됨
		
		//포탄 발사
		if(order.equals("S")) {
			if(dir==1) {
					String tmp = field[x-1][y];
					//벽돌벽 만나면 평지로 만들고 탈출
					if(tmp.equals("*")){
						tmp = ".";
					}
					//경계 넘어가면 break
					if(x-1 < 0) {
					}
					//강철벽 만나면 
					if(tmp.equals("#")){
					}
					x--;
				
			}
			//아래
			else if(dir==2) {
				
			}
			//왼쪽
			else if(dir==3) {
				
			}
			//오른쪽
			else if(dir==4) {
				
			}
		}
		//방향 위쪽으로 바꾸고, 위칸 평지면 한칸 이동
		else if(order.equals("U")) {
			dir = 1;
			//위칸이 평지이고 경계를 벗어나지 않으면
			if(field[x-1][y].equals(".") && x-1 >= 0) {
				field[--x][y] = "^";
			}
			else {
				field[x][y] = "^";
			}
		}
		//방향 아래쪽으로 바꾸고, 아래칸 평지면 이동
		else if(order.equals("D")) {
			dir = 2;
			//아래칸이 평지면
			if(field[x+1][y].equals(".")) {
				x++;
			}
		}
		//방향 왼쪽으로 바꾸고, 왼쪽칸 평지면 이동
		else if(order.equals("L")) {
			dir = 3;
			//왼쪽칸이 평지면
			if(field[x][y-1].equals(".")) {
				y--;
			}
		}
		//방향 오른쪽으로 바꾸고, 오른칸 평지면 이동
		else if(order.equals("R")) {
			dir = 4;
			//오른칸이 평지면
			if(field[x][y+1].equals(".")) {
				y++;
			}
		}
	}
	
	
	//방향찾기
	public static void Direction(int i, int j) {
		//dir: 위1 아래2 왼쪽3 오른쪽4
		//위
		if(field[i][j].equals("^") || dir == 1) {
			dir = 1;
		}
		//아래
		else if(field[i][j].equals("v") || dir == 2) {
			dir = 2;
		}
		//왼쪽
		else if(field[i][j].equals("<") || dir == 3) {
			dir = 3;
		}
		//오른쪽
		else if(field[i][j].equals(">") || dir == 4) {
			dir = 4;
		}
	}
}
