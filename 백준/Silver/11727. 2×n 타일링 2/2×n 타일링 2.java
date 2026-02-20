import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] tiles = new int[N+5];
		
		tiles[1] = 1;
		tiles[2] = 3;  
		

		for (int i = 3; i <= N; i++) {
			tiles[i] = (tiles[i-1] + 2 * tiles[i-2]) % 10007;
		}
		
		System.out.println(tiles[N]);
		
	}

}
