import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = 0;
		int start = 0;
		int finish = 0;
		
		int rise = 1;
		// 증가하는 수열 길이 체크
		for(int i = 0; i < N-1; i++) {
			if(arr[i] <= arr[i+1]) {
				finish++;
			}else {
				rise = Math.max(rise, finish - start + 1);
				start = finish = i+1;
			}
		}
		
		rise = Math.max(rise, finish-start+1);
		
		int dec = 1;
		start = finish = 0;
		// 감소하는 수열 길이 체크
		for(int i = 0; i < N-1; i++) {
			if(arr[i] >= arr[i+1]) {
				finish++;
			}else {
//				System.out.println(i + " " + start + " " + finish);
				dec = Math.max(dec, finish - start + 1);
				start = finish = i+1;
			}
		}
		
		dec = Math.max(dec, finish-start+1);
		
		ans = Math.max(rise, dec);
		
		System.out.println(ans);
	}

}
