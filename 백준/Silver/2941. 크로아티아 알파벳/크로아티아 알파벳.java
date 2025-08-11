
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String[] alphabet = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String str = sc.next();
	
		
		for(int i = 0; i < alphabet.length; i++) {
			str = str.replace(alphabet[i], "*");
		}
		
		
		System.out.println(str.length());
	}

}
