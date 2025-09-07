import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Top{
		int index;
		int height;
		
		Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
	}

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Top> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().height < num) {
				stack.pop();
			}
			
			if(stack.isEmpty()) sb.append("0 ");
			else sb.append(stack.peek().index).append(" ");
			
			stack.push(new Top(i, num));
		}
		
		System.out.println(sb.toString());
		
	}

}
