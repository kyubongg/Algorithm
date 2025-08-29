import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<List<Integer>> list;
	static int N;
	public static void main(String[] args) {
		
		// 식재료 중복 X
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
//			System.out.println(Arrays.deepToString(arr));
			
			// 조합 만들기
			list = new ArrayList<>();
			
			combination(0, new ArrayList<>());

			int ans = Integer.MAX_VALUE;
			for(int i = 0; i < list.size() / 2; i++) {
				List<Integer> list1 = list.get(i);
				List<Integer> list2 = list.get(list.size()-i-1);
				
//				System.out.println(list1);
//				System.out.println(list2);
//				System.out.println("-----------------");
				
				int sum1 = 0;
				int sum2 = 0;
				for(int j = 0; j < list1.size() - 1; j++) {
					for(int k = j+1; k < list1.size(); k++) {
						int list1Value1 = list1.get(j);
						int list1Value2 = list1.get(k);
						
						int list2Value1 = list2.get(j);
						int list2Value2 = list2.get(k);
						
//						System.out.println("l1v1 : " + list1Value1);
//						System.out.println("l1v2 : " + list1Value2);
//						
//						System.out.println("l2v1 : " + list2Value1);
//						System.out.println("l2v2 : " + list2Value2);
						
						sum1 += arr[list1Value1][list1Value2] + arr[list1Value2][list1Value1];
						sum2 += arr[list2Value1][list2Value2] + arr[list2Value2][list2Value1];
//						
//						System.out.println("sum1 : " + sum1);
//						System.out.println("sum2 : " + sum2);
//						System.out.println("-------------------------");
					}
				}
				
//				System.out.println(sum1);
//				System.out.println(sum2);
//				System.out.println("-----------------------");
				ans = Math.min(ans, Math.abs(sum1 - sum2));
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		
	}
	
	static void combination(int start, List<Integer> current) {
		if(current.size() == N/2) {
			List<Integer> tmp = new ArrayList<>();
			
			for(int num : current) {
				tmp.add(num);
			}
			
			list.add(tmp);
		}
		
		for(int i = start; i < N; i++) {
			current.add(i);
			combination(i+1, current);
			current.remove(current.size()-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
