
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

        
		// 조망의 조건: 좌우로 두칸이상 확보되어야 한다.
      	// 해당 칸을 기준으로 좌우 두칸 이내에 해당 건물 높이보다 큰 건물이 있다면 조망 => 0
        // 해당 칸을 기준으로 좌우 두칸 이내에 해당 건물 높이보다 큰 건물이 없다면
        //   ->  해당 칸 건물 높이 - 두칸 이내에 존재하는 건물 중 가장 높은 건물의 높이 = 조망
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
            int N = sc.nextInt();
            int[] heights = new int[N];

			for(int i = 0; i < N; i++){
            	heights[i] = sc.nextInt();
            }
			
            int ans = 0;
            
            
            for(int i = 0; i < N; i++){
                boolean isView = true;
                int height = heights[i];
                int min = Integer.MAX_VALUE;
            	// 건물 좌우 두칸 이내의 건물 높이와 비교
                for(int j = i-2; j <= i+2; j++){
                	if(j < 0 || j == i || j >= N) continue;
                    
                    int nearHeight = heights[j];
                    if(nearHeight >= height){
                        isView = false;
                    	break;
                    }
                
                	min = Math.min(height - nearHeight, min);
                }
                
                if(isView) ans += min;
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}