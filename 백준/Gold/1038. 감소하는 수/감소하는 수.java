import java.util.Scanner;

public class Main {
	
	static final long MAX_NUM = 9876543210L;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int targetNum = sc.nextInt();
		// 감소하지 않는 수를 찾는게 더 빠를거같음
		
		int descCnt = 0;
		long num = 0;
		while(num < MAX_NUM && descCnt <= targetNum) {
			
			if(descCnt == targetNum) {
				String strNum = Long.toString(num);
				boolean isDesc = true;
				for(int i = 0; i < strNum.length()-1; i++) {
					if((strNum.charAt(i)-'0') <= (strNum.charAt(i+1)-'0')) {
						isDesc = false;
						break;
					}
				}
				
				if(isDesc) break;
			}
			
			// 한자리 수이면 전부 감소하는 수임
			if(num / 10 == 0) {
				descCnt++;
				num++;
			}
			else {
				String strNum = Long.toString(num);
				boolean isDesc = true;
				for(int i = 0; i < strNum.length()-1; i++) {
					if((strNum.charAt(i)-'0') <= (strNum.charAt(i+1)-'0')) {
						strNum = strNum.substring(0, i) + Integer.toString(strNum.charAt(i)-'0' + 1) + "0".repeat(strNum.length()-i-1);
						num = Long.parseLong(strNum);
						isDesc = false;
						break;
					}
				}

				if(isDesc) {
					descCnt++;
					num++;
				}
			}
			
//			System.out.println(descCnt + " " + num);
		}
		
		if(descCnt < targetNum) System.out.println(-1);
		else System.out.println(num);
	}

}
