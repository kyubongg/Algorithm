import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		
		for(int i = 0; i < C; i++) {
			int N = sc.nextInt();
			
			double[] scores = new double[N];
			double sum = 0;
			for(int j = 0; j < N; j++) {
				double score = sc.nextDouble();
				scores[j] = score;
				sum += score;
			}
			
			double avg = 0;
			double cnt = 0;
			
			if(sum > 0.0) {
				avg = sum / N;
				for(int j = 0; j < N; j++) {
					if(scores[j] > avg) cnt++;
				}
			}

			if(cnt == 0) {
				System.out.println("00.000%");
			}else {
				double percent = cnt / N;
				String ans = Integer.toString((int)Math.round(percent * 100000));
				
				System.out.println(ans.substring(0, ans.length()-3) + "." + ans.substring(ans.length() - 3) + "%");
			}
			
			
		}
	}
}
