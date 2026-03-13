import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class City implements Comparable<City>{
		int to, weight;
		
		public City(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(City o) {
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		
		List<City>[] cities = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			cities[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());	
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			cities[from].add(new City(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(start, 0));
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			City curr = pq.poll();
			int currTo = curr.to;
			int currWeight = curr.weight;
			
			if (currWeight > dist[currTo]) continue;
			
			for (City next : cities[currTo]) {
				int newDist = dist[currTo] + next.weight;
				
				if (newDist < dist[next.to]) {
					pq.add(new City(next.to, newDist));
					dist[next.to] = newDist;
				}
				
			}
			
		}
		
		System.out.println(dist[end]);
	    
 	}

}
