import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	
	static class Micro{
		// dir: 위(1), 아래(2), 좌(3), 우(4)
		// maxCount: 합쳐질 때 방향을 정하기 위한 변수
		int r, c, count, dir, maxCount;
		
		public Micro(int r, int c, int count, int dir) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
			this.maxCount = count;
		}
	}
	
	static int[][] drc = {{0,0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			Queue<Micro> q = new LinkedList<>();
			Micro[][] map = new Micro[N][N];
			
			for(int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int count = sc.nextInt();
				int dir = sc.nextInt();
				
				Micro micro = new Micro(r, c, count, dir);
				map[r][c] = micro;
				q.add(micro);
			}
			
			
			for(int i = 0; i < M; i++) {
				
				Micro[][] nextMap = new Micro[N][N];
				
				int currentSize = q.size();
				
				for(int j = 0 ; j < currentSize; j++) {
					Micro current = q.poll();
					
					// 군집 이동
					current.r += drc[current.dir][0];
					current.c += drc[current.dir][1];
					
					// 군집이 약품 셀로 이동했을때
					if(current.r == 0 || current.c == 0 || current.r == N-1 || current.c == N-1) {
						current.count /= 2;
						switch(current.dir) {
							case 1: current.dir = 2; break;
							case 2: current.dir = 1; break;
							case 3: current.dir = 4; break;
							case 4: current.dir = 3; break;
						}
					}
					
					// 군집의 크기가 0이 되면 사라짐
					if(current.count == 0) continue;
					
					// 군집 합치기 알고리즘
					// 이동하려고 하는 셀에 아무것도 없으면 그냥 이동
					if(nextMap[current.r][current.c] == null) {
						current.maxCount = current.count;
						nextMap[current.r][current.c] = current;	
					}
					
					// *핵심* (동시 이동이라서 어떻게 해야할지 몰라서 AI 도움 받음)
					// 이동하려는 셀에 다른 군집이 있다면
					// 셀에 존재하는 군집을 가져오기
					// 셀에 존재하는 군집의 최대 크기와 이번에 이동한 군집의 크기 비교
					// 최대 크기: 군집이 여러개 합쳐질 때 방향이 잘못 정해지는 경우를 없애기 위해서 사용
					else {
						Micro existing = nextMap[current.r][current.c];
						if(existing.maxCount < current.count) {
							existing.dir = current.dir;
							existing.maxCount = current.count;
						}
						
						existing.count += current.count;
					}
				}
				
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(nextMap[r][c] != null) q.add(nextMap[r][c]);
					}
				}
			}
			
			
			
			int ans = 0;
			while(!q.isEmpty()) {
//				System.out.println(q.peek().count);
				ans += q.poll().count;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
