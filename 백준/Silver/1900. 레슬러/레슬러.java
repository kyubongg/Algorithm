import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Player {
		int num, power, ring;
		
		public Player(int num, int power, int ring) {
			this.num = num+1;
			this.power = power;
			this.ring = ring;
		}
		
		@Override
		public String toString() {
			return "[num: " + num + ", power: " + power + ", ring: " + ring + "]";
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
		for(int i = 0; i < N; i++) {
			int power = sc.nextInt();
			int ring = sc.nextInt();
			
			if(players.size() == 0) {
				players.add(new Player(i, power, ring));
			}
			else {
				int pIdx = 0;
				// 이번에 입력받은 플레이어의 경기력이 이전에 입력받은 플레이어의 경기력보다 클때까지 반복
				while(pIdx < (players.size()) && power + (players.get(pIdx).power * ring) > players.get(pIdx).power + power * players.get(pIdx).ring) {
					pIdx++;
				}
				
				players.add(pIdx, new Player(i, power, ring));
			}
		}
		
		for(int i = players.size()-1; i >= 0; i--) {
			System.out.println(players.get(i).num);
		}
	}

}
