import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] chess = new int[] {1, 1, 2, 2, 2, 8};
		
		int[] input = new int[chess.length];
		for(int i = 0; i < chess.length; i++) {
			input[i] = sc.nextInt();
		}
		
		int[] result = new int[chess.length];
		for(int i = 0; i < chess.length; i++) {
			result[i] = chess[i] - input[i];
		}
		
		for(int i = 0; i < chess.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
