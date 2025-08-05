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
		
            String[][] words = new String[5][];
            int max = 0;
			for(int i = 0; i < 5; i++){
                
            	String str = sc.next();
                String[] strArr = str.split("");
                words[i] = strArr;
                if(max < str.length()) max = str.length();
            }
            
      
            String word = "";
            for(int col = 0; col < max; col++){
            	for(int row = 0; row < 5; row++){
                	if(col < words[row].length){
                    	word += words[row][col];
                    }
                }
            }
			
        	System.out.println("#" + test_case + " " + word);
		}
	}
}