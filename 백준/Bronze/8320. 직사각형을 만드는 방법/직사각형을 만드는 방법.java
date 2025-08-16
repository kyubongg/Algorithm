import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 길이가 1인 정사각형 개수
		
		List<int[]> list = new ArrayList<>();
		
		// 행이 1인 직사각형 담기
		
		// 1 1, 1 2, 1 3, 1 4, 1 5, 1 6
		// 2 1, 2 2, 2 3
		 
		for(int r = 1; r <= Math.sqrt(N); r++) {
			for(int c = 1; c <= N/r; c++) {
				if(c < r) continue;
				list.add(new int[] {r,c});
			}
			
		}
		
		System.out.println(list.size());
	}

}
