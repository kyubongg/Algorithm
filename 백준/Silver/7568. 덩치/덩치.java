import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static class Human{
		int weight, height;

		public Human(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		Human[] humans = new Human[N];
		 
		for(int i = 0; i < N; i++) {
			humans[i] = new Human(sc.nextInt(), sc.nextInt());
		}
		
		int[] ranks = new int[N];
		for(int i = 0; i < N-1; i++) {
			Human first = humans[i];
			for(int j = i; j < N; j++) {
				Human second = humans[j];
				
				if(first.weight > second.weight && first.height > second.height) ranks[j]++;
				else if(first.weight < second.weight && first.height < second.height) ranks[i]++;
				
			}
		}
		
		for(int rank : ranks) {
			System.out.print(rank+1 + " ");
		}
		sc.close();
	}
}
