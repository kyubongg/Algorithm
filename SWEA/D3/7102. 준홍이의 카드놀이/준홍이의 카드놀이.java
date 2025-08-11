import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] cards = new int[N+M+1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					
					cards[i+j]++;
				}
			}
			
			int max = 0;
			for(int i = 0; i < cards.length; i++) {
				if(max < cards[i]) max = cards[i];
			}
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < cards.length; i++) {
				if(cards[i] == max) list.add(i);
			}
			
			System.out.print("#" + t + " ");
			
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
