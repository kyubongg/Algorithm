import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
			
			return thisPower > InputPower ? 1 : -1;
		}
	}
	public static void main(String[] args) {
		
		
		// 경기력 공식 : ‘A의 힘’ + ‘B의 힘’ * ‘A가 착용하고 있는 마술 링의 힘’
		// 금화의 수 공식 :  그가 이긴 경기 수 + 선수들의 줄에서 자기보다 앞에 있는데 자기가 이긴 선수의 수
		
		// 나눠주는 금화의 수를 최소화함.
		// Player들의 경기력 순서를 입력받는 동시에 계산함 (시간복잡도: N^2 -> N)
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Player> players = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int power = sc.nextInt();
			int ring = sc.nextInt();
			
			players.add(new Player(i, power, ring));
			
		}
		
        players.sort(null);
        
		for(int i = players.size()-1; i >= 0; i--) {
			System.out.println(players.get(i).idx);
		}
	}
	
}
