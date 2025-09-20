import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 00, 24, 48, 72, 96
		// 00, 60
		
		// 14:19 => 14, 38, 62, 86
		//			19, 79
		
		// 가능한 시간과 분의 조합을 찾고, 필요한 노력이 가장 작은 조합을 출력
		String str = sc.next();
		String[] strArr = str.split(":");
		
		String time = strArr[0];
		String minute = strArr[1];
		
		List<String> times = new ArrayList<>();
		List<String> minutes = new ArrayList<>();
		
		
		int[] dialR = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2};
		int[] dialC = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
		
		while(Integer.parseInt(time) <= 100) {
			times.add(time);
			time = Integer.toString(Integer.parseInt(time) + 24);
		}
		while(Integer.parseInt(minute) <= 100) {
			minutes.add(minute);
			minute = Integer.toString(Integer.parseInt(minute) + 60);
		}
		

		int min = Integer.MAX_VALUE;
		String minTime = "";
		String minMinute = "";
		for(int i = 0; i < times.size(); i++) {
			String t = times.get(i);
			
			int t1 = t.charAt(0) - '0';
			int t2 = t.charAt(1) - '0';
			
			for(int j = 0; j < minutes.size(); j++) {
				String m = minutes.get(j);
				
				int m1 = m.charAt(0) - '0';
				int m2 = m.charAt(1) - '0';
				
				int first = Math.abs(dialR[t1] - dialR[t2]) + Math.abs(dialC[t1] - dialC[t2]);
				int second = Math.abs(dialR[t2] - dialR[m1]) + Math.abs(dialC[t2] - dialC[m1]);
				int third = Math.abs(dialR[m1] - dialR[m2]) + Math.abs(dialC[m1] - dialC[m2]);
				
				int sum = first + second + third;
				
				if(min > sum) {
					minTime = t;
					minMinute = m;
					min = sum;
				}
			}
		}
		
		System.out.println(minTime + ":" + minMinute);
		
    }
}
