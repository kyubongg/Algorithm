import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		int[] ans = new int[M];
		for(int i = 0; i < M; i++) {
			if(set.add(sc.nextInt())) ans[i] = 0;
			else ans[i] = 1;
		}
		
		for(int num : ans) {
			System.out.print(num + " ");
		}
	}
}
