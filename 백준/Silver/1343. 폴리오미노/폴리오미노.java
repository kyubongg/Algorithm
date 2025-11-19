import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String board = sc.next();
		
		
		board = board.replaceAll("XXXX", "AAAA");
		board = board.replaceAll("XX", "BB");
		
		if(board.contains("X")) {
			System.out.println(-1);
		}else {
			System.out.println(board);
		}
		
		sc.close();
	}
}
