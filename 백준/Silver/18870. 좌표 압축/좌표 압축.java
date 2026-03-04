import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			set.add(input);
		}

		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), list.size()-1 - i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		
		System.out.println(sb);
	}
	
	
}
