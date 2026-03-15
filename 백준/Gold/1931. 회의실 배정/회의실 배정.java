import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			if (this.end != o.end) {
				return Integer.compare(this.end, o.end);
			}
			
			return Integer.compare(this.start, o.start);
			
		}
	}
	public static void main(String[] args) throws IOException {
		
		/**
		 * 
		 * 회의를 최대한 많이 할 수 있는 경우
		 * 
		 * 끝나는 시간을 기준으로 오름차순 정렬
		 * 현재 회의 시작 시간 < 이전 회의 끝나는 시간 -> 그 회의 건너뜀
		 * 현재 회의 시작 시간 >= 이전 회의 끝나는 시간 -> 해당 회의 시작
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Meeting> meetingQueue = new PriorityQueue<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			meetingQueue.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int ans = 0;
		int beforeEnd = -1;
		while (!meetingQueue.isEmpty()) {
			Meeting meet = meetingQueue.poll();
			
			if (meet.start < beforeEnd) continue;
			else {
				beforeEnd = meet.end;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
