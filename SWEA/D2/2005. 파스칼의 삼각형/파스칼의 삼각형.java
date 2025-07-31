
import java.util.Scanner;
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
            int[][] pascalArr = new int[N][];
            for(int i = 0; i < N; i++){
               	pascalArr[i] = new int[i+1];
                // 첫번째와 마지막은 항상 1이 들어감
                pascalArr[i][0] = 1;
                pascalArr[i][i] = 1;
            	for(int j = 1; j < i; j++){
                	pascalArr[i][j] = pascalArr[i-1][j-1] + pascalArr[i-1][j];
                }
            }
            
            System.out.println("#" + test_case); 
            for(int i = 0; i < pascalArr.length; i++){
            	for(int j = 0; j < pascalArr[i].length; j++){
                	System.out.print(pascalArr[i][j] + " ");
                }
                System.out.println();
               	
            }
		}
	}
}