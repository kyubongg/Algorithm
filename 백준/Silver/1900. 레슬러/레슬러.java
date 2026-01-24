import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static class Player implements Comparable<Player> {
		int idx, power, ring;
		
		public Player(int idx, int power, int ring) {
			this.idx = idx;
			this.power = power;
			this.ring = ring;
		}
		
		@Override
		public String toString() {
			return "[idx: " + idx + ", power: " + power + ", ring: " + ring + "]";
		}

		@Override
		public int compareTo(Player o) {
			int thisPower = this.power + o.power * this.ring;
			int InputPower = o.power + this.power * o.ring;
			
			return thisPower > InputPower ? -1 : 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		// 경기력 공식 : ‘A의 힘’ + ‘B의 힘’ * ‘A가 착용하고 있는 마술 링의 힘’
		// 금화의 수 공식 :  그가 이긴 경기 수 + 선수들의 줄에서 자기보다 앞에 있는데 자기가 이긴 선수의 수
		
		// 나눠주는 금화의 수를 최소화함.
		// Player들의 경기력 순서를 입력받는 동시에 계산함 (시간복잡도: N^2 -> N)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			players.add(new Player(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		players.sort(null);
		
		StringBuilder sb = new StringBuilder();
		for(Player p : players) {
			sb.append(p.idx).append("\n");
		}
		
		System.out.print(sb);
	}

}
