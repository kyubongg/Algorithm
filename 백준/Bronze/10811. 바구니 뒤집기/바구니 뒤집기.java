import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 바구니 개수
		int M = sc.nextInt();	// 테스트케이스 개수
		int[] arr = new int[N];	
		
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		for(int t = 1; t <= M; t++) {
			int left = sc.nextInt() - 1;	// 역순으로 변경할 바구니 시작 번호
			int right = sc.nextInt() - 1;	// 역순으로 변경할 바구니 마지막 번호
			
			int[] tmp = new int[right-left+1];
			
			for(int i = 0; i < tmp.length; i++) {
				tmp[i] = arr[left+i];
			} 
			
			
			for(int i = right; i >= left; i--) {
				arr[i] = tmp[right-i];
			}
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}

}
