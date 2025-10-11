import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		double sum = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			sum += num;
			nums[i] = num;
		}
		
		
		
		// 산술평균
		System.out.println((int)Math.round(sum / N));
		
		// 중앙값
		Arrays.sort(nums);
		System.out.println(nums[N/2]);
		
		// 최빈값
		
		int[] counts = new int[8001];
		int maxCount = 0;
		
		for(int num : nums) {
			counts[num + 4000]++;
			if(counts[num + 4000] > maxCount) maxCount = counts[num + 4000];
		}
		
		List<Integer> modes = new ArrayList<>();
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] == maxCount) modes.add(i - 4000);
		}
		
		if(modes.size() > 1) {
			System.out.println(modes.get(1));
		}else {
			System.out.println(modes.get(0));
		}
		
		
		// 범위
		System.out.println(nums[nums.length-1] - nums[0]);
		
		
		
		
	}
}
