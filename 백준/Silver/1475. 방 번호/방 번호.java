import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String NStr = br.readLine();
		int[] nums = new int[10];
		
		for(int i = 0; i < NStr.length(); i++) {
			char ch = NStr.charAt(i);
			
			nums[ch-'0']++;
		}
		
		nums[9] = (int)Math.ceil((nums[6] + nums[9]) / 2.0);
		nums[6] = 0;
		
		Arrays.sort(nums);
		
		System.out.println(nums[9]);
	}
}
