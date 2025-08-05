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
            // 첫번째 행에 값이 1인 부분에서만 출발 가능
            
			// 좌우에 사다리가 있는지 확인
            // 1. 사다리가 있다면 좌/우 사다리로 이동 -> 밑으로 가는 사다리가 나올때 까지
            // 2. 사다리가 없다면 밑으로 이동
            
            // 다른 막대를 가로지르는 막대가 없기 때문에 가능
            
            // 사다리 배열 받아오기
            int[][] ladder = new int[100][100];
            for(int i = 0; i <100; i++){
            	for(int j = 0; j < 100; j++){
                	ladder[i][j] = sc.nextInt();
                }
            }
            
            // 좌우 상하 배열
            int[][] drc = new int[][]{{0,-1}, {0,1}, {-1, 0}};
            int[] nowIndex = new int[]{0,0};
            int ans = 0;
            
			// 첫줄 숫자가 1인지 0인지 판단
            for(int startCol = 0; startCol < ladder[0].length; startCol++){
            	if(ladder[0][startCol] != 1) continue;
                
                // 시작 위치 (행, 열)
                int row = 0;
                int col = startCol;
                
                // num이 1이면 출발
               	while(row < 100){
                    // 2를 발견하면 시작 위치의 col값을 ans에 저장한 후while문, for문 break;
                	if(ladder[row][col] == 2){
                    	ans = startCol;
                        break;
                    }
                    
                    // 오른쪽 이동
                    // 더이상 오른쪽으로 이동할 수 없으면 밑으로 한칸 이동
                    if(col < ladder[row].length - 1 && ladder[row][col + 1] == 1){
                    	while(col < ladder[row].length - 1 && ladder[row][col+1] == 1){
                        	col++;
                        }
                        row++;
                    }
                    
                    // 왼쪽 이동
                    // 더이상 왼쪽으로 이동할 수 없으면 밑으로 한칸 이동
                    else if(col > 0 && ladder[row][col - 1] == 1){
                    	while(col > 0 && ladder[row][col - 1] == 1){
                        	col--;
                        }
                        row++;
                    }
                    
                    // 아래쪽 이동
                    else{
                    	row++;
                    }
                    
                }
             	if(ans != 0) break;
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}