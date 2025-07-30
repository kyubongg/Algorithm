import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
       for(int i = 1; i <= T; i++){
       	  String str = Integer.toString(i);
          int cnt = 0;
          for(int j = 0; j < str.length(); j++){
          	if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9'){
            	cnt++;
            }
              
          
          }
           
            if (cnt == 0) {
                System.out.print(i + " ");
            } else {
                for (int k = 0; k < cnt; k++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
       }
	}
}