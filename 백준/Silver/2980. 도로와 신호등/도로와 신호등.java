import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int currTime = 0;
		int currPos = 0;
		
		for(int i = 0; i < N; i++) {
			int D = sc.nextInt();
			int R = sc.nextInt();
			int G = sc.nextInt();
			
			currTime += D - currPos;
			currPos = D;
			
			int cycle = R + G;
			int timeInCycle = currTime % cycle;
			
			if(timeInCycle < R) {
				int delayTime = R - timeInCycle;
				currTime += delayTime;
			}
		}
		
		currTime += L - currPos;
		System.out.println(currTime);
		
		sc.close();
	}
}
