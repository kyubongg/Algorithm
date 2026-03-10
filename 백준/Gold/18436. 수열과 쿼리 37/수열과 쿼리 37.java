import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] tree;
	
	// tree에는 짝수의 개수가 저장되어 있음
	static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = (arr[start] % 2 == 0) ? 1 : 0;
			return;
		}
		
		int mid = (start + end) / 2;
		init(node * 2, start, mid);
		init(node * 2 + 1, mid+1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1]; 
	} 
	
	static void update (int node, int start, int end, int idx, int val) {
		if (idx < start || idx > end) return;
		if (start == end) {
			arr[idx] = val;
			tree[node] = (val % 2 == 0) ? 1 : 0;
			return;
		}
		
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, val);
		update(node * 2 + 1, mid + 1, end, idx, val);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + 
				query(node * 2 + 1, mid + 1, end, left, right);
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
	    
	    arr = new int[N + 1]; 
	    tree = new int[N * 4];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 1; i <= N; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
		
	    init(1, 1, N);
	    
	    int M = Integer.parseInt(br.readLine());
	    for (int i = 0; i < M; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int type = Integer.parseInt(st.nextToken());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	if (type == 1) {
	    		update(1, 1, N, a, b);
	    	} else if (type == 2) {
	    		System.out.println(query(1, 1, N, a, b));
	    	} else {
	    		int total = (b - a + 1);
	    		int evenCount = query(1, 1, N, a, b);
	    		System.out.println(total - evenCount);
	    	}
	    	
	    }
		
 	}

}
