import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 지면의 수
		int K = sc.nextInt();		// 목표 낙찰 지면 수
		
		
		// 낙찰 받으려면 올려야하는 금액
		int[] diff = new int[N];
		int bid = 0;
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < N; i++) {
			int moloco = sc.nextInt();
			int other = sc.nextInt();
			
			if(moloco >= other) bid++;
			else {
				diff[i] = other - moloco;
				map.put(diff[i], map.getOrDefault(diff[i], 0)+1);
			}
		}
		
		if(bid >= K) System.out.println(0);
		else {
			int cnt = 0;
			List<Integer> keySet = new ArrayList<>(map.keySet());
			Collections.sort(keySet);
			for(int key : keySet) {
				bid += map.get(key);
				cnt = key;
				
				if(bid >= K) break;
			}
			
			System.out.println(cnt);
		}
		
		sc.close();
	}

}
