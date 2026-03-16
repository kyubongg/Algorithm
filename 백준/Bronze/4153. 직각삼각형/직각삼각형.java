import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if (A == 0 && B == 0 && C == 0) break;
			
			int[] arr = new int[3];
			arr[0] = A;
			arr[1] = B;
			arr[2] = C;
			
			Arrays.sort(arr);
			
			if (Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) System.out.println("right");
			else System.out.println("wrong");
		}
		
		
		
		
 	}

	
	
	
	
	
}
