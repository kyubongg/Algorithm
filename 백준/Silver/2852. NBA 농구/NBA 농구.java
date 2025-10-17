import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int score1 = 0;
		int score2 = 0;
		int time1 = 0;
		int time2 = 0;
		int prevTime = 0;
		
		for(int i = 0; i < N; i++) {
			int team = sc.nextInt();
			String timeStr = sc.next();
			
			int currentTime = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3));
			
			int duration = currentTime - prevTime;
			
			if(score1 > score2) {
				time1 += duration;
			}else if(score1 < score2) {
				time2 += duration;
			}
			
			if(team == 1) {
				score1++;
			}else {
				score2++;
			}
			
			prevTime = currentTime;
		}
		
		// 마지막 골부터 남은시간 계산
		int lastTime = 48 * 60 - prevTime;
		if(score1 > score2) {
			time1 += lastTime;
		}else if(score1 < score2){
			time2 += lastTime;
		}
		
		System.out.printf("%02d:%02d\n", time1 / 60, time1 % 60);
		System.out.printf("%02d:%02d\n", time2 / 60, time2 % 60);
		sc.close();
	}
}
