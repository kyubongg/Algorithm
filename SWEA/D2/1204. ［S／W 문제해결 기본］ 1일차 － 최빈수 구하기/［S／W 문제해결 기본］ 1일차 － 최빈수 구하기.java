import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t <= tc; t++) {
			int T = sc.nextInt();
			
			int[] scores = new int[101];
			
			for(int i = 0; i < 1000; i++) {
				scores[sc.nextInt()]++;
			}
			
			int max = 0;
			for(int i = 0; i < scores.length; i++) {
				max = Math.max(max, scores[i]);
			}
			
			int ans = 0;
			for(int i = scores.length-1; i >= 0; i--) {
				if(scores[i] == max) {
					ans = i;
					break;
				}
			}
            
            System.out.println("#" + t + " " + ans);
		}
	}

}
