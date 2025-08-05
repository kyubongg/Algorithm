
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
			
			int[] arr = new int[101];
			
			// count 배열을 만들어 해당 위치의 박스가 몇개인지 체크
			// 최대 개수에서 최소 개수로 한개씩 옮겨주고 
			// 조건에 따라 최대, 최소 값을 옮긴다.
			
			for(int i = 0; i < 100; i++) {
				int num = sc.nextInt();
				arr[num]++;
			}
			
			
			
			int min = 0;
			int max = 100;
			
			
			for(int i = 0; i < dump; i++) {
				
				while(arr[min] == 0) min++;
				while(arr[max] == 0) max--;
				
				if(max - min <= 1) break;
				
				
				arr[max]--;
				arr[max-1]++;
				
				arr[min]--;
				arr[min+1]++;
				
				
			}

			// 마지막 dump후 min과 max가 변했을 수도 있으니 min,max 한번 더 찾기
			while(arr[min] == 0) min++;
			while(arr[max] == 0) max--;
			
			System.out.println("#" + test_case + " " + (max - min));
		}
	}
}
