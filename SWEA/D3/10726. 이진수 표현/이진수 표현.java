import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				if((M & (1<<i)) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("#" + t + " ON");
			}else {
				System.out.println("#" + t + " OFF");
			}
		}
		
		sc.close();
	}
}
