import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 첫번째 수
		
		
		// 세번째 : 이후에 나오는 모든 수는 idx - 2의 수에서 idx - 1의 수를 빼서 만든다.
		// 음의 정수가 나오면 멈춤
		
		// 두번째 : 양의 정수 밑의 수 중에서 하나 선택
		

		
		List<List<Integer>> nums = new ArrayList<>();
		
		// 반복 횟수가 최대가 될 때의 반복 횟수와 수들을 출력
		
		for(int s = N; s > 0; s--) {
			int next = Integer.MAX_VALUE;
			int first = N;
			int second = s;
			
			List<Integer> list = new ArrayList<>();
			
			if(list.isEmpty()) {
				list.add(first);
				list.add(second);
			}

			while(next >= 0) {
				
				next = first-second;
				
				first = second;
				second = next;
				
				if(next >= 0) {
					list.add(next);
				}
			}
			
			nums.add(list);
		}
		
		
		int maxSize = 0;
		int maxIdx = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(maxSize < nums.get(i).size()) {
				maxSize = nums.get(i).size();
				maxIdx = i;
			}
		}
		
		System.out.println(maxSize);
		
		for(int i = 0; i < nums.get(maxIdx).size(); i++) {
			if(i == nums.get(maxIdx).size() - 1) {
				System.out.print(nums.get(maxIdx).get(i));
			}else {
				System.out.print(nums.get(maxIdx).get(i) + " ");
			}
			
		}
		
		
			
		
	}
}
