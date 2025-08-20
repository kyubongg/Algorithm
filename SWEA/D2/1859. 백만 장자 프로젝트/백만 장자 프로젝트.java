import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] prices = new int[N];
            
            for(int i = 0; i < N; i++){
            	prices[i] = sc.nextInt();
            }
            
            int max = 0;
            long answer = 0;
           
            
            for(int i = N - 1; i >= 0; i--){
                if(prices[i] > max){
                	max = prices[i];
                }else{
                	answer += (max - prices[i]);
                }
            
            }
 
            System.out.println("#" + test_case + " " + answer);
            
		}
	}
}