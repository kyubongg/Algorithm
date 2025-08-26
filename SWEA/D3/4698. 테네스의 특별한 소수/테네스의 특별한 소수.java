import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		// 소수 구하기
		for(int i = 2; i <= 1000000; i++) {
			String str = Integer.toString(i);
			
			boolean isNum = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					isNum = false;
					break;
				}
			}
			
			if(isNum) list.add(i);
			
		}
		
//		System.out.println(list.toString());
		for(int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			int cnt = 0;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) > right) break;
				else if(list.get(i) < left) continue;
				
				if(Integer.toString(list.get(i)).contains(Integer.toString(num))) {
					cnt++;
				}
			}
			
			
			System.out.println("#" + t + " " + cnt);
		}
		
	}

}
