import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int now = sc.nextInt();
		int target =sc.nextInt();

		int ans = (int)Math.abs(now-target);
        
        System.out.print(ans+1);
	}
}