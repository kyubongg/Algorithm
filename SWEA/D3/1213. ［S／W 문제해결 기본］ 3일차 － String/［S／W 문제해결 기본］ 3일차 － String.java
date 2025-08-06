
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		for(int t = 1; t <= 10; t++) {
			int num = sc.nextInt();
			sc.nextLine();
			
			String pattern = sc.nextLine();
			String str = sc.nextLine();
			int S = str.length();
			int P = pattern.length();
			int cnt = 0;
			
			for(int i = 0; i <= S - P; i++) {
				boolean isFind = true;
				for(int j = 0; j < P; j++) {
					if(pattern.charAt(j) != str.charAt(i+j)) {
						isFind = false;
						break;
					}
				}
				
				if(isFind) cnt++;
				
			}
			
			System.out.println("#" + num + " " + cnt);
		}
	}

}
