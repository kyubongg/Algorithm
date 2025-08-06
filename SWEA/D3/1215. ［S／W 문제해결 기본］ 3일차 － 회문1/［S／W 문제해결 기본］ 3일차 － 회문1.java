import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		// 가로방향 회문 찾고, 세로방향 회문 찾기
		for(int t = 1; t <= T; t++) {
			int L = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[8][8]; 
			
			for(int i = 0; i < 8; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			int ans = 0;
			
			// 가로방향 회문 찾기
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8 - L + 1; j++) {
					String str = "";
					boolean isFind = true;
					// L 길이만큼의 문자열 저장
					for(int k = 0; k < L; k++) {
						str += arr[i][j+k];
					}
					
					// 해당 문자열이 회문인지 체크
					for(int m = 0; m < str.length() / 2; m++) {
						if(str.charAt(m) != str.charAt(str.length() - 1 - m)) {
							isFind = false;
							break;
						}
					}
					
					if(isFind) ans++;
				}
			}
			
			// 세로방향 회문 찾기
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8 - L + 1; j++) {
					String str = "";
					boolean isFind = true;
					// L 길이만큼의 문자열 저장
					for(int k = 0; k < L; k++) {
						str += arr[j+k][i];
					}
					
					// 해당 문자열이 회문인지 체크
					for(int m = 0; m < str.length() / 2; m++) {
						if(str.charAt(m) != str.charAt(str.length() - 1 - m)) {
							isFind = false;
							break;
						}
					}
					
					if(isFind) ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
		
	}

}
