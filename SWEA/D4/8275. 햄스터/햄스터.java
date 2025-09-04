import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<int[]> hamsters;
	static int[] arr;
	static int[] ans;
	static int N;
	static int X;
	static int M;
	static int maxSum;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			M = sc.nextInt();
			
			hamsters = new ArrayList<>();
			arr = new int[N+1];
			ans = null;
			maxSum = -1;
			
			for(int i = 0; i < M; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				int s = sc.nextInt();
				
				hamsters.add(new int[] {l, r, s});
			}
			
			dfs(0);
			
			if(ans == null) System.out.println("#" + tc + " " + -1);
			else {
				System.out.print("#" + tc);
				for(int i = 1; i < ans.length; i++) {
					System.out.print(" " + ans[i]);
				}
				System.out.println();
			}
			
//			
			
		}
		
		
	}
	
	static void dfs(int idx) {
		if(idx > N) {
			for(int[] hamster : hamsters) {
				int l = hamster[0];
				int r = hamster[1];
				int s = hamster[2];
				int currentSum = 0;
				
				for(int i = l; i <= r; i++) {
					currentSum += arr[i];
				}
				
				if(currentSum != s) {
					return;
				}
			}
			
			int totalSum = 0;
			for(int i = 1; i <= N; i++) {
				totalSum += arr[i];
			}
			
			if(totalSum > maxSum) {
				maxSum = totalSum;
				ans = arr.clone();
			}
			
			return;
		}
		
		
		for(int h = 0; h <= X; h++) {
			arr[idx] = h;
			dfs(idx + 1);
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
