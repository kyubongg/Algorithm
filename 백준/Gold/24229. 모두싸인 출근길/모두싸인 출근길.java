import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Bridge implements Comparable<Bridge>{
		int start, end;
		
		public Bridge(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		// 점프 최대거리 : 마지막으로 착지한 시점 이후로 건너간 거리
		//				점프를 한 적이 없으면 출발한 시점 이후로 건너간 거리
		//				ex) 점프 -> 좌표 9에 착지, 12에서 다시 점프 -> 최대거리 == 3
		
		// 판자의 개수가 최대 200,000개 이므로 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Bridge> inputList = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			inputList.add(new Bridge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		List<Bridge> mergedList = new ArrayList<>();
		Collections.sort(inputList);
		
		int curS = inputList.get(0).start;
		int curE = inputList.get(0).end;
		
		for(int i = 1; i < N; i++) {
			if(inputList.get(i).start <= curE) {
				curE = Math.max(curE, inputList.get(i).end);
			} else {
				mergedList.add(new Bridge(curS, curE));
				curS = inputList.get(i).start;
				curE = inputList.get(i).end;
			}
		}
		
		mergedList.add(new Bridge(curS, curE));
		// 앞 판자의 마지막 인덱스가 뒷 판자의 시작 인덱스보다 크거나 같으면 둘이 연결되어 있음
		// 위 경우가 아닐때
		//	1. 최대 점프거리를 계산
		//  2. 점프해서 갈 수 있는 판자 중 다음 판자로 넘어갈 수 있는 판자로 뛰어야 함
		//  2.1. 다음 판자로 뛰어넘기 위해서는 판자의 시작점으로 점프하는게 가장 좋음(다음 점프 거리 길어짐)
		//  2.2. 내가 갈 수 있는 최대 길이 : 현재 발판 끝 + (현재 발판 끝 - 현재발판 시작)
		
		// 필요한 변수
		// 1. 점프로 도달할 수 있는 최대 좌표: maxJump
		// 2. 현재 위치 : nIdx
		// 3. 현재 발판 최대 점프거리: currJumpLimit
	
		int maxJumpDistance = 0;
		int nIdx = 0;
		
		for(int i = 0; i < mergedList.size(); i++) {
			Bridge b = mergedList.get(i);
			
			if(b.start <= maxJumpDistance) {
				nIdx = b.end;
				maxJumpDistance = Math.max(maxJumpDistance, b.end + (b.end - b.start));
			} else {
				break;
			}
			
		}
		
		System.out.println(nIdx);
	}
}
