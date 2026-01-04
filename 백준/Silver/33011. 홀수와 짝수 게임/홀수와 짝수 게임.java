import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int even = 0;
			int odd = 0;
			
			String [] nums = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                if(Integer.parseInt(nums[i]) % 2 ==0){
                	even++;
                }
                else{
                	odd++;
                }
            }
			
			// 첫번째 뽑은 카드와 홀짝 여부가 동일해야함
			
			// 경우 1
			// 홀/짝의 개수가 다름
			// 1) 첫번째 뽑는 사람은 카드가 더 많은 쪽을 뽑아야함
			// 2) 두번째 뽑는 사람이 이기는 경우
			// 2-1) 첫번째 뽑은 사람과 같은 수를 뽑을 때 => 남은 카드의 수가 홀수일 때
			
			// 경우 2
			// 홀/짝의 개수가 같음
			// 1) 첫번째 뽑는 사람이 이길 수 없음
				
			if (even != odd) {
				int biggerNum = Math.max(even, odd);
				
				if ((biggerNum -1) % 2 == 0) {
					System.out.println("amsminn");
					continue;
				}
					
			} 
				
			
			System.out.println("heeda0528");
			
		}
		
	}
}
