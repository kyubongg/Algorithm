import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			
			int N = sc.nextInt();
			List<Long> dp = new ArrayList<>();
			int cnt = 0;
			while(cnt < N) {
				if(cnt < 5) {
					if(cnt < 3) dp.add(1L);
					else dp.add(2L);
				}else {
					dp.add(dp.get(cnt-1) + dp.get(cnt-5));
				}
				
				cnt++;
			}
			
			System.out.println(dp.get(dp.size()-1));
		}
		
		
		
		sc.close();
	}
}
