import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			List<Integer> passwordList = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				passwordList.add(sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			for(int i = 0; i < M; i++) {
				String command = sc.next();
				
				if(command.equals("I")) {
					int idx = sc.nextInt();
					int cnt = sc.nextInt();
					
					for(int j = 0; j < cnt; j++) {
						passwordList.add(idx+j, sc.nextInt());
					}
				}else if(command.equals("D")) {
					int idx = sc.nextInt();
					int cnt = sc.nextInt();
					
					for(int j = 0; j < cnt; j++) {
						passwordList.remove(idx);
					}
				}else {
					int cnt = sc.nextInt();
					for(int j = 0; j < cnt; j++) {
						passwordList.add(sc.nextInt());
					}
				}
			}
			
			System.out.print("#" + t);
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + passwordList.get(i));
			}
			System.out.println();
			
		}
		
		
		
		
		sc.close();
	}
}
