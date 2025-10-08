import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static String[] guitars;
	static String[] songs;
	static int min = Integer.MAX_VALUE;
//	static int allMin = Integer.MAX_VALUE;
	static int c = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Y 개수로 정렬 -> 재귀로 가능한 조합 다보기
		N = sc.nextInt();
		M = sc.nextInt();
		
		guitars = new String[N];
		songs = new String[N];
		
		for(int i = 0; i < N; i++) {
			guitars[i] = sc.next();
			songs[i] = sc.next();
		}
	
		dfs(new boolean[M], c, 0, 0);
		
		if(min == 0) System.out.println("-1");
		else System.out.println(min);
		
	}
	
	static void dfs(boolean[] isPlay, int cnt, int idx, int gCnt) {
		if(cnt > c) {	
			
			min = gCnt;
			c = cnt;
			
		}else if(cnt == c) {
			min = Math.min(gCnt, min);
			c = cnt;
		}
		

		for(int i = idx; i < N; i++) {
			List<Integer> isTrue = new ArrayList<>();
			String song = songs[i];
			
			int originalCnt = cnt;
			
			for(int j = 0; j < song.length(); j++) {
				if(song.charAt(j) == 'Y' && !isPlay[j]) {
					isPlay[j] = true;
					isTrue.add(j);
					cnt++;
				}
			}
			
//			System.out.println(idx + " " + song + " " + cnt);
			dfs(isPlay, cnt, i+1, gCnt+1);
			
			for(int j : isTrue) {
				isPlay[j] = false;
			}
			
			cnt = originalCnt;
		}
		
	}
	
	
	
	
	
}
