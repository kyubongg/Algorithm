import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String str = Integer.toBinaryString(M);
			
			boolean isOn = true;
			
			for(int i = str.length()-1; i >= str.length() - N; i--) {
				if(i < 0) {
					isOn = false;
					break;
				}
				
				if(str.charAt(i) != '1') {
					isOn = false;
					break;
				}
				
				
			}
			
			if(isOn) System.out.println("#" + t + " ON");
			else System.out.println("#" + t + " OFF");
		}
	}

}
