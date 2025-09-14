import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Integer> list;
	static int P;
	static int idx = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		P = sc.nextInt();
		
		list = new ArrayList<>();
		
		dfs(A);
		
		System.out.println(idx);
	}
	
	static void dfs(int num) {
		if(list.contains(num)) {
			idx = list.indexOf(num);
			return;
		}else {
			list.add(num);
		}
		
		String str = String.valueOf(num);
		int n = 0;
		for(char ch : str.toCharArray()) {
			n += Math.pow(ch-'0', P);
		}
		
		dfs(n);
	}
}
