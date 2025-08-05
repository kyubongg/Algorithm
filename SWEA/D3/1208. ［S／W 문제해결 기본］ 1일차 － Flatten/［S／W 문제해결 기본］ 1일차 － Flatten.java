import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
			
			int[] arr = new int[100];
			
			for(int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			// 가장 높은곳의 위치를 찾는다.  
			// arr를 정렬함
			// 버블정렬 사용
			bubbleSort(arr);
			
			for(int i = 0; i < dump; i++) {
				if(arr[0] == arr[arr.length-1] || arr[arr.length - 1] - arr[0] == 1) break;
			
				arr[arr.length - 1]--;
				arr[0]++;
				
				bubbleSort(arr);
			}
			
			int ans = arr[arr.length - 1] - arr[0];
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}