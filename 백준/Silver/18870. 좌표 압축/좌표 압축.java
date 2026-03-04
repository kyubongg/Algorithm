import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
				
		// 기존 코드의 시간/공간 복잡도를 줄이기 위해
		// 1. Set 사용 X => 원본배열을 복사해서 정렬한 후, 순회하면서 중복을 무시하는 방식
		// 2. List의 메모리 부담이 크기 때문에 int[]로 사용
		// 3. 정렬을 내림차순으로 정렬해서 재계산하는것이 아닌, 그냥 오름차순 정렬
		
		int[] origin = new int[N];
		int[] sorted = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for (int value : sorted) {
			if (!map.containsKey(value)) {
				map.put(value, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(origin[i])).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
	
	
}
