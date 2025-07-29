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
            // 1. 다음날의 매매가가 오늘의 매매가보다 높다면
            //    다음날의 매매가와 오늘의 매매가를 더한다.
            // 2. 다음날의 매매가가 오늘의 매매가보다 낮다면
            //    계속해서 더해왔던 값을 더했던 횟수로 나누고 오늘의 매매가에 뺀다.
            //	  그리고, 더했던 횟수만큼 곱하고 answer에 더한다.
            // 공식 : (ik - (i1 + i2+ i3+ ...) / n) * n
            
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