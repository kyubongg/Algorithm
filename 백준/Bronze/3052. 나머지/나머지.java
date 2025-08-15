import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] counts = new int[42];
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			
			counts[num%42]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] != 0) cnt++;
		}
		
		System.out.println(cnt);
	}
}
