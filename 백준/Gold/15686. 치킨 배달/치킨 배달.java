import java.io.*;
import java.util.*;

public class Main {

	static int N, M, minDist = Integer.MAX_VALUE;
	static int[][] selected;
	static int[][] map;
	static List<int[]> house; 
	static List<int[]> chicken;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new int[M][2];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c] = num;
				
				if (num == 1) {
					house.add(new int[] {r, c});
				} else if (num == 2) {
					chicken.add(new int[] {r, c});
				}
			}
		}
		
		getComb(0, 0);
		
		System.out.println(minDist);
		
	}
	
	// 부분집합 고르기 (중복 없이 골라야함)
	static void getComb(int start, int depth) {
		
		if (depth == M) {
			int nowDist = getNowDist();
			minDist = Math.min(minDist, nowDist);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			selected[depth] = chicken.get(i);
			getComb(i + 1, depth + 1);
		}
		
		
	}
	
	// 살아남은 치킨집의 치킨 거리 구하기
	static int getNowDist() {
	    int totalCityDist = 0;
	    
	    for (int[] h : house) { 
	        int minHouseDist = Integer.MAX_VALUE;
	        
	        for (int[] c : selected) { 
	            int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	            minHouseDist = Math.min(minHouseDist, d);
	        }
	        
	        totalCityDist += minHouseDist;
	    }
	    
	    return totalCityDist;
	}
}
