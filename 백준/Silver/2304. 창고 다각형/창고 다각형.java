import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		int[] walls = new int[1001];
		int left = 1001;
		int right = 0;
		int maxH = 0;
		int maxIdx = 0;
		for(int t = 1; t <= tc; t++) {
			int wall = sc.nextInt();
			int height = sc.nextInt();
	
			walls[wall] = height;
			
			if(wall < left) left = wall;
			if(wall > right) right = wall;
			if(height > maxH) {
				maxH = height;
				maxIdx = wall;
			}
		}
		
		
		
		int sum = 0;
		int currentMaxHeight = 0;
		 
		for(int i = left; i <= maxIdx; i++) {
			
			if(walls[i] > currentMaxHeight) currentMaxHeight = walls[i];
			sum += currentMaxHeight;
			
			
		}
		
		currentMaxHeight = 0;
		for(int i = right; i > maxIdx; i--) {
			if(walls[i] > currentMaxHeight) currentMaxHeight = walls[i];
			sum += currentMaxHeight;
		}
		
		

		System.out.println(sum);
		
		
		
		
	}

}
