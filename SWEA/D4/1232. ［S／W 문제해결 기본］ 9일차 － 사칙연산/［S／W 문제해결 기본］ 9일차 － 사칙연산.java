import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		// 정수 : 정점 번호, 양의 정수
		// 연산자 : 정점 번호, 연산자, 해당 정점의 왼쪽자식, 오른쪽 자식
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			// 길이가 2 or 4인 배열이 들어가기 떄문에 열은 설정하지 않는다.
			// 1부터 시작할것이기 때문에 N+1로 설정
			String[][] tree = new String[N+1][];
			
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();	// 노드 번호
				String s = sc.next();
				// 두번째 값이 숫자인지 연산자인지 확인
				if(!s.equals("-") && !s.equals("+") && !s.equals("/") && !s.equals("*")) {
					tree[num] = new String[]{s};
				}else {
					String left = sc.next();
					String right = sc.next();
					tree[num] = new String[] {s,left,right};
				}
			}
			
			System.out.println("#" + tc + " " +inOrder(tree, 1));
		}
	}
	
	// 중위 순환
	public static int inOrder(String[][] tree, int num) {
		
		
		if(tree[num].length == 1) {
			return Integer.parseInt(tree[num][0]) ;
		}
		
		// 1번부터 시작
		if(tree[num].length == 3) {
			int left = Integer.parseInt(tree[num][1]);
			int right = Integer.parseInt(tree[num][2]);
			String op = tree[num][0];
			
			int v1 = inOrder(tree, left);
			int v2 = inOrder(tree, right);
			
			switch(op) {
				case "+":
					return v1 + v2;
				case "-":
					return v1 - v2;
				case "*":
					return v1 * v2;
				case "/":
					return v1 / v2;
			}

		}
		
		return 0;
	}

}

