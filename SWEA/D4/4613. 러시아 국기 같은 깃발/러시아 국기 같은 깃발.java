import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static char[] targetColors;
	static int[][] flag;
	static int minCount;
	
	static int N;		// 열 길이
	static int M;		// 행 길이
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();		// 행 길이
			M = sc.nextInt();		// 열 길이
			minCount = Integer.MAX_VALUE;
			// 조건
			// 국기에서 각 색의 줄은 한 줄 이상이어야 한다.
			// 1. 맨 위는 무조건 흰색, 맨 아래는 무조건 빨간색이다.
			// 2. 따라서, 반복문을 0 ~ N-1까지가 아닌 1 ~ N-2까지 돌린다.
			// 3. 1 ~ N-2 행의 색 조건
			// 3.1. 흰색, 파란색, 빨간색 순서를 지킨다(필수!)
			// 3.1.1 위/아래 행의 색을 보고 결정한다.(행의 후보는 3개 or 2개 or 1개가 될 수 있음)
			
			flag = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					flag[i][j] = str.charAt(j);
				}
			}

			// 각 행의 타겟 색을 담아둘 배열
			targetColors = new char[N];
			
			targetColors[0] = 'W';
			targetColors[N-1] = 'R';
			
			paintFlag(1);
			
			System.out.println("#" + t + " " + minCount);
		}
		
	}
	
	// up: 위의 깃발 색
	// down: 아래 깃발 색
	// N: 현재 몇행이나 색이 안정해졌는지
	public static void paintFlag(int row) {
		// 모든 행의 색이 정해진다면 종료
		if(row == N-1) {
			validateAndCalculate();
			return;
		}
		
		char prevColor = targetColors[row-1];
		
		// 이전 색이 W면 W,B만 올 수 있음
		if(prevColor == 'W') {
			// 흰 색으로 칠하기
			targetColors[row] = 'W';
			paintFlag(row+1);
			
			// 파란색으로 칠하기
			targetColors[row] = 'B';
			paintFlag(row+1);
		}
		// 이전 색이 B이면 B,R만 올 수 있음
		else if(prevColor == 'B') {
			// 파란색으로 칠하기
			targetColors[row] = 'B';
			paintFlag(row+1);
			// 빨간색으로 칠하기
			targetColors[row] = 'R';
			paintFlag(row+1);
		}
		// 이전 색이 R이면 R만 올 수 있음	
		else {
			// 빨간색으로 칠하기
			targetColors[row] = 'R';
			paintFlag(row+1);
		}
	}
	
	public static void validateAndCalculate() {
		
		boolean isValid = false;
		int count = 0;
		// 중복을 없애기 위해 set을 사용
		Set<Character> set = new HashSet<>();
		// targetColors에 3가지 색이 모두 있는지 확인
		for(int i = 0; i < N; i++) {
			set.add(targetColors[i]);
		}
		
		if(set.size() == 3) isValid = true;
		
		// 3가지 색이 다 있는 깃발
		if(!isValid) {
			return;
		}else {
			
			for(int i = 0; i < N; i++) {
				char targetColor = targetColors[i];
				for(int j = 0; j < M; j++) {
					if(flag[i][j] != targetColor) {
						count++;
					}
				}
			}

		}
		
		minCount = Math.min(count, minCount);
		
	}

}
