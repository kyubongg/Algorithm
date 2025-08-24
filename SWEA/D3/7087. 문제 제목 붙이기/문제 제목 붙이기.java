import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
//		System.out.println((int)'Z');
		for(int t = 1; t <= tc; t++) {
			
			Map<Character, Integer> titles = new HashMap<>();
			
			int N = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				
				char title = str.charAt(0);
				
				if(!titles.containsKey(title)) {
					titles.put(title, 1);
				}
			}
			
			int cnt = 0;
			for(int i = 65; i <= 90; i++) {
				if(titles.containsKey((char)i)) {
					cnt++;
				}else {
					break;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
