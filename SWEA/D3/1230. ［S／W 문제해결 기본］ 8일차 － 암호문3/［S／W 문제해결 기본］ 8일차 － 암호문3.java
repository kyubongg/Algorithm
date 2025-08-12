import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//File file = new File("./src/input.txt");
		Scanner sc = new Scanner(System.in);

		
		for(int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();		// 암호문의 개수
			List<String> list = new ArrayList<>();	// 암호문 리스트
			
			for(int i = 0; i < N; i++) {
				list.add(sc.next());
			}
			
			int M = sc.nextInt();		// 명령어 개수
			
			// 명령어 종류
			// 1. I(삽입) x,y,s: x번째 암호문 다음에 y개의 암호문 삽입 s(암호문들)
			// 2. D(삭제) x,y: x번째 암호문 바로 다음부터 y개의 암호문 삭제
			// 3. A(추가) y,s: 맨 뒤에 y개의 암호문을 덧붙인다.
			
//			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < M; i++){
				String str = sc.next();
				
				if(str.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j = 0; j < y; j++) {
						String IStr = sc.next();
						list.add(x+j, IStr);
					}
				}else if(str.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for(int j = 0; j < y; j++) {
						list.remove(x);
					}
					
				}else if(str.equals("A")) {
					int y = sc.nextInt();
					for(int j = 0; j < y; j++) {
						String AStr = sc.next();
						list.add(AStr);
					}
					
				}
			}
			
			System.out.print("#" + t + " ");
			
			for(int k = 0; k < 10; k++) {
				System.out.print(list.get(k) + " ");
			}
			System.out.println();
			
			
		}
	}

}
