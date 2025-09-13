import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		// 중복 제거를 위한 set
		Queue<Character> q = new ArrayDeque<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!q.contains(ch)) q.add(ch); 
		}
			
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			if(!q.contains(ch)) q.add(ch);
		}
		
		char[] password = new char[26];
		int idx = 0;
		while(!q.isEmpty()) {
			char ch = q.poll();
			password[idx++] = ch;
		}
		
		String input = sc.next();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			sb.append(password[ch-'A']);
		}

		System.out.println(sb.toString());
		
		
	}
}
