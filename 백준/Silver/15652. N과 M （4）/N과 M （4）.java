import java.io.*;
import java.util.*;

public class Main {
   
	static int[] arr;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 중복 조합 구하기
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[M];
    	sb = new StringBuilder();
    	
    	solve(1, 0, N, M);
    	System.out.println(sb.toString());
    }
    
    static void solve(int start, int depth, int N, int M) {
    	
    	if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
    	
    	for (int i = start; i <= N; i++) {
    		arr[depth] = i;
    		
    		solve(i, depth + 1, N, M);
    		
    	}
    }
}