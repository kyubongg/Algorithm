
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] two = new char[] {'B'};
		char[] one = new char[] {'A', 'D', 'O', 'P', 'Q', 'R'};
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			String word1 = sc.next();
			String word2 = sc.next();
			
			if(word1.length() != word2.length()) {
				System.out.println("#" + t + " DIFF");
				continue;
			}
			
			boolean isSame = false;
			
			
			for(int i = 0; i < word1.length(); i++) {
				char ch1 = word1.charAt(i);
				char ch2 = word2.charAt(i);
				
				if(ch1 == two[0] && ch2 == two[0]) {
					isSame = true;
					continue;
				}else if(ch1 != two[0] && ch2 == two[0] || ch1 == two[0] && ch2 != two[0]) {
					isSame = false;
					break;
				}
					
				
				boolean isOne = false;
				boolean isTwo = false;
				for(int j = 0; j < one.length; j++) {
					if(ch1 == one[j]) isOne = true;
					if(ch2 == one[j]) isTwo = true;
					
				} 
				
				if(isOne == isTwo) isSame = true;
				else {
					isSame = false;
					break;
				}
			}
			
		
			
			if(isSame) System.out.println("#" + t + " SAME");
			else System.out.println("#" + t + " DIFF");
			
		}
	}

}
