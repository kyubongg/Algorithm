import java.io.*;
import java.util.*;

public class Main {
   
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 중복 조합 구하기
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N];
    	ans = new int[M];
    	visited = new boolean[N];
    	sb = new StringBuilder();
    	st = new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	solve(0, 0, N, M);
    	System.out.println(sb.toString());
    }
    
    static void solve(int start, int depth, int N, int M) {
    	
    	if (depth == M) {
    		for (int i = 0; i < M-1; i++) {
    			sb.append(ans[i]).append(" ");
    		}
    		sb.append(ans[M-1]).append("\n");
    		return;
    	}
    	
    	
    	for (int i = 0; i < N; i++) {
    		if (visited[i]) continue;
    		
    		visited[i] = true;
    		ans[depth] = arr[i];
    		solve(0, depth+1, N, M);
    		visited[i] = false;
    	}
    	
    	
    	
    	
    	
    }
}