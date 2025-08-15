
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();		// 롤 케이크의 길이
		int N = sc.nextInt();		// 방청갱의 수
		
		int[] cakes = new int[L+1];
		int[] peoples = new int[N+1];
		
		
		for(int i = 1; i <= N; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			peoples[i] = right-left;
			
			for(int j = left; j <= right; j++) {
				if(cakes[j] == 0) cakes[j] = i;
			}
		}
		
		// 가장 많이 받을 것으로 기대하는 방청객
		int max = 0;
		int maxIdx = 0;
		for(int i = 1; i < peoples.length; i++) {
			if(peoples[i] > max) {
				maxIdx = i;
				max = peoples[i];
			}
		}
		
		// 실제로 가장 많이 받는 방청객
		int real = 0;
		int[] counts= new int[N+1];
		for(int i = 1; i < cakes.length; i++) {
			counts[cakes[i]]++;
		}
		
		
		int realIdx = 0;
		for(int i = 1; i < counts.length; i++) {
			if(counts[i] > real) {
				realIdx = i;
				real = counts[i];
			}
		}
	
		System.out.println(maxIdx);
		System.out.println(realIdx);
	}

}
