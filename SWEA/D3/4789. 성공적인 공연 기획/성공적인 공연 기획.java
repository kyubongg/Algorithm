import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			String str = sc.next();
			
			int peoples = 0;
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				
				if(str.charAt(i) == '0') continue;
				else {
					if(peoples >= i) {
						peoples += str.charAt(i) - '0';
					}else {
						cnt += i - peoples;
						peoples += i - peoples;
						peoples += str.charAt(i) - '0';
					}
				}
				
			}
			
			
			System.out.println("#" + t + " " + cnt);
		}
	}

}
