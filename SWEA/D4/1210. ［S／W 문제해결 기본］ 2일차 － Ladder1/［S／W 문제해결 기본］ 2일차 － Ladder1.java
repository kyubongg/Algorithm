
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
         	int test = sc.nextInt();
            // 마지막 행 -> 첫번째 행 
            
			// 좌우에 사다리가 있는지 확인
            // 1. 사다리가 있다면 좌/우 사다리로 이동 -> 위로 가는 사다리가 나올때 까지
            // 2. 사다리가 없다면 위로 이동
            
            // 다른 막대를 가로지르는 막대가 없기 때문에 가능
            
            // 사다리 배열 받아오기
            int[][] ladder = new int[100][100];
            for(int i = 0; i <100; i++){
            	for(int j = 0; j < 100; j++){
                	ladder[i][j] = sc.nextInt();
                }
            }
            
            // 좌우 상하 배열
            int[] nowIndex = new int[]{0,0};
            int ans = 0;
            
            
            int row = 99;
            // 숫자 2의 인덱스 col찾기
            int startCol = 0;
            for(int i = 0; i < 100; i++) {
            	if(ladder[row][i] == 2) {
            		startCol = i;
            		break;
            	}
            }

            int col = startCol;
            
			while(row > 0) {
				
				
				// 현재 칸의 왼쪽에 1이 존재하는지 확인
				// 있다면 col을 -1함.
				if(col > 0 && ladder[row][col-1] == 1) {
					while(col > 0 && ladder[row][col-1] == 1) {
						col--;
					}
				}
				
				// 현재 칸의 오른쪽에 1이 존재하는지 확인
				// 있다면 col을 +1함.
				else if(col  < 99 && ladder[row][col+1] == 1) {
					while(col  < 99 && ladder[row][col+1] == 1) {
						col++;
					}
				}
				
					row--;
				
				
				
				if(row == 0 && ladder[row][col] == 1) {
					ans = col;
					break;
				}
				
			}
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}