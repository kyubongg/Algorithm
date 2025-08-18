import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<List<Character>> list;
	static boolean[] isDifference = new boolean[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 톱니바퀴 4개 받아오기
		list = new ArrayList<>();
		
		for(int i = 0 ; i < 4; i++) {
			list.add(new ArrayList<>());
			String str = sc.next();
			for(int j = 0; j < str.length(); j++) {
				list.get(i).add(str.charAt(j));
			}
		}
		
//		System.out.println(list.toString());
		
		
		int K = sc.nextInt();		// 회전 수
		// 회전 메서드 시작
		for(int i = 0; i < K; i++) {
			// 1~4번까지 서로 맞닿은 부분이 다른지 확인
			// 회전하는 톱니와 맞닿은 부분이 다른 값인 톱니는 반대 방향으로 회전
			// 같은 값이면 회전 x
			// 오른쪽 바퀴: 2번, 왼쪽 바퀴: 6번
			// 톱니바퀴끼리 맞닿은 톱니의 값이 다른지 확인
			
//			System.out.println(Arrays.toString(isDifference));
			
			int moveNum = sc.nextInt()-1;		// 움직일 톱니바퀴 번호
			int direction = sc.nextInt();	// 움직일 방향: 시계 방향(1), 반시계 방향(-1)
			
			// 좌우 톱니 양방향 돌리기
			
			isDifference();
			move(list, moveNum, direction);
			
			int currentDir = direction;
			for(int j = moveNum-1; j >= 0; j--) {
				if(!isDifference[j]) break; 
				else {
					currentDir *= -1;
					move(list, j, currentDir);
				}
				
				
			}
			
			currentDir = direction;
			for(int j = moveNum; j < 3; j++) {
				if(!isDifference[j]) break;
				else {
					currentDir *= -1;
					move(list, j+1, currentDir);
				}
					
				
			}
			
		}// 회전 메서드 끝
		
		
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			// 12시 방향이 S극 일때
			if(list.get(i).get(0) == '1') {
				sum += Math.pow(2, i);
			}
		}
		
		System.out.println(sum);
	}
	
	public static void move(List<List<Character>> list, int moveNum, int direction) {
		
		List<Character> moveList = list.get(moveNum);
		
		
		// 시계 방향 회전 -> 맨 뒤 요소 => 맨앞으로 이동
		if(direction == 1) {
			moveList.add(0,moveList.remove(moveList.size()-1));
		}
		// 반시계 방향 회전 -> 맨 앞에 요소 => 맨 뒤로 이동
		else {
			moveList.add(moveList.remove(0));
		}
	}
	
	public static void isDifference() {
		
		for(int j = 0; j < 3; j++) {
			if(list.get(j).get(2) != list.get(j+1).get(6)) {
				isDifference[j] = true;
			}else {
				isDifference[j] = false;
			}
		}
	}
}
