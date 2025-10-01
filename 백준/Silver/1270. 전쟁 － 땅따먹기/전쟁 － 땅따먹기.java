import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Army implements Comparable<Army>{
		int value, cnt;

		public Army(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Army o) {
			return this.cnt - o.cnt;
		}
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int tc = 0; tc < N; tc++) {
			int T = sc.nextInt();
			
			Map<Long, Integer> map = new HashMap<>();
			
			for(int t = 0; t < T; t++) {
				long input = sc.nextLong();
				
				if(map.get(input) != null) {
					map.put(input, map.get(input)+1);
				}else {
					map.put(input, 1);
				}
				
			}
			
			Object[] mapValues = map.values().toArray();
			Arrays.sort(mapValues);
			
			int maxValue = (int)mapValues[mapValues.length-1];
			
			String ans = "";
			
			for(long key : map.keySet()) {
				if(ans.equals("")) {
					if(map.get(key) == maxValue) ans = Long.toString(key);
				}else {
					if(map.get(key) == maxValue) {
						ans = "SYJKGW";
						break;
					}
				}
			}
			

			if(maxValue <= (T / 2)) ans = "SYJKGW";
			
			
			System.out.println(ans);
		}
		
		sc.close();
	}
}
