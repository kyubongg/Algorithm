import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Fruit {
		int num, last;
		
		public Fruit (int num, int last) {
			this.num = num;
			this.last = last;
		}

	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[10]; 	// 과일이 0 ~ 9
		int cnt = 0;
		int left = 0;
		int right = 0;
		int max = 0;
		
		while (right < N) {
			if (count[fruits[right]] == 0) cnt++;
			count[fruits[right]]++;
			
			while (cnt > 2) {
				count[fruits[left]]--;
				if (count[fruits[left]] == 0) cnt--;
				left++;
			}
			
			max = Math.max(max, right - left + 1);
			right++;
		}
		
		System.out.println(max);
	}
	
	
	
	
}
