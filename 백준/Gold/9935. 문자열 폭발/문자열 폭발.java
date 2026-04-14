import java.io.*;
import java.util.*;

public class Main {
   
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 스택을 이용함
    	
    	// 1. 문자열을 하나씩 나눠서 본다.
    	// 2. 해당 문자가 폭발 문자와 같은지 본다.
    	// 2.1. 같으면 폭발 문자열 인덱스를 +1 한다.
    	// 2.2. 다르면 폭발 문자열 인덱스를 0으로 바꾼다.
    	// 3. 폭발 문자열 인덱스가 폭발 문자열 길이-1과 같아지면 그만큼을 스택에서 뺀다.
    	
    	String str = br.readLine();
    	String boom = br.readLine();
    	
    	List<Character> list = new ArrayList<>();
    	for (int i = 0; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		
    		list.add(ch);
    		
    		if (list.size() >= boom.length()) {
    			boolean isBoom = true;
    			for (int j = 0; j < boom.length(); j++) {
    				if (list.get(list.size() - boom.length() + j) != boom.charAt(j)) {
    					isBoom = false;
    					break;
    				}
    			}
    			
    			if (isBoom) {
    				for (int j = 0; j < boom.length(); j++) {
    					list.remove(list.size()-1);
    				}
    			}
    		}
    	}
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < list.size(); i++) {
    		sb.append(list.get(i));
    	}
    	
    	System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
    
    
}