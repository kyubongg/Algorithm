import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		
		while(true) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(num1 == 0 && num2 == 0) break;

			// 한쪽 숫자에서 사이클이 발생할 때까지 계산을 함
			// 다른쪽 숫자에서 그 사이클에 들어갈 때 까지 계산을 함
			
			int min1 = cycle(num1, num2);
			int min2 = cycle(num2, num1);
			
			int min = Math.min(min1, min2);
			System.out.println(num1 + " " + num2 + " " + min);
		}
		
		sc.close();
	}
	
	static int calc(int num) {
		int sum = 0;
		String s = String.valueOf(num);
//		System.out.println(s);
		for(int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - '0';
			sum += n * n;
		}
		
		return sum;
	}
	
	static int cycle(int num1, int num2) {
		Map<Integer, Integer> map = new HashMap<>();
		int currentNum1 = num1;
		int idx1 = 1;
		
		// 사이클 찾기
		while(!map.containsKey(currentNum1)) {
			map.put(currentNum1, idx1);
			currentNum1 = calc(currentNum1);
			idx1++;
		}
		
		// 다른 숫자가 사이클 내에 도달할 수 있는지 확인
		Set<Integer> set = new HashSet<>();
		int currentNum2 = num2;
		int idx2 = 1;
		int min = 0;

		while(true) {
			if(map.containsKey(currentNum2)) {
				int meet = map.get(currentNum2);
				min = meet + idx2;
				break;
			}
			
			if(set.contains(currentNum2)) {
				min = 0;
				break;
			}
			
			set.add(currentNum2);
			currentNum2 = calc(currentNum2);
			idx2++;
			
		}
		
		return min;
	}
}
