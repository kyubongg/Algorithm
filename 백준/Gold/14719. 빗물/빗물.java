import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] walls = new int[W];
		for (int i = 0; i < W; i++) {
			walls[i] = Integer.parseInt(st.nextToken());
		}
		
		int water = 0;
		for (int i = 1; i < W-1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			
			for (int j = 0; j <= i; j++) {
				leftMax = Math.max(leftMax, walls[j]);
			}
			
			for (int j = i; j <= W-1; j++) {
				rightMax = Math.max(rightMax, walls[j]);
			}
			
			water += Math.min(leftMax, rightMax) - walls[i];
		}
		
		System.out.println(water);
		
		
 	}
	
	
	
}
