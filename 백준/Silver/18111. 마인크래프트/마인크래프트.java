import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] heights = new int[257];
		int minH = 256, maxH = 0;
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int num = Integer.parseInt(st.nextToken());
				heights[num]++;
				
				minH = Math.min(minH, num);
				maxH = Math.max(maxH, num);
			}
		}
			
		int minTime = Integer.MAX_VALUE;
		int targetHeight = 0;
		for (int height = minH; height <= maxH; height++) {
			
			// 주머니에 있는 블럭 수
			int block = B;
			int time = 0;
			
			for (int h = minH; h <= maxH; h++) {
				if (heights[h] == 0) continue;
				
				if (height > h) {
					int diff = height - h;
					time += (diff * heights[h]);
					block -= (diff * heights[h]);
				} else if (height < h) {
					int diff = h - height;
					time += (diff * heights[h]) * 2;
					block += (diff * heights[h]);
				}
			}
			
			
			if (block >= 0) { // 블록이 부족하지 않을 때만
		        if (time <= minTime) { // "작거나 같을 때"로 해야 높은 높이 갱신 가능
		            minTime = time;
		            targetHeight = height;
		        }
		    }
		}
		
		System.out.println(minTime + " " + targetHeight);
			
			
		
 	}
	
	
	
}
