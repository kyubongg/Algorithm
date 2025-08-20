import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			
			String str = sc.next();
			
			int count = 0;
			boolean isOne = false;
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(!isOne && ch == '1') {
					isOne = true;
					count++;
				}
				
				if(isOne && ch == '0') {
					isOne = false;
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}

}
