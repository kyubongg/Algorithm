import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		
		List<BigInteger> list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			String str = sc.next();
			
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				
				if(Character.isDigit(ch)) {
					sb.append(ch);
				}else {
					if(sb.length() > 0) {
						list.add(new BigInteger(sb.toString()));
						sb.setLength(0);
					}
				}
			}
			
			if(sb.length() > 0) list.add(new BigInteger(sb.toString()));
		}
		
		Collections.sort(list);
		
		for(BigInteger num : list) {
			System.out.println(num);
		}
		sc.close();
	}
}
