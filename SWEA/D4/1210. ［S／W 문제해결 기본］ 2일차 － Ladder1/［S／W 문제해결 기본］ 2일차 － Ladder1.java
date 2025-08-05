

import java.util.ArrayList;
import java.util.List;
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
            
			// 1. 각 행마다 사다리가 있는 구간을 체크한다.
         	// 2. 가장 아래 행에 있는 2부터 시작해서, 위로 올라간다.
         	// 2-1. 위의 행에 사다리가 존재하는 구간이 2가 있는 열과 연속된다면
         	//		연속되는 값 중에 가장 끝 값으로 옮긴다.
            
            // 다른 막대를 가로지르는 막대가 없기 때문에 가능
            
            // 사다리 배열 받아오기
            int[][] ladder = new int[100][100];
            for(int i = 0; i <100; i++){
            	for(int j = 0; j < 100; j++){
                	ladder[i][j] = sc.nextInt();
                }
            }            
            
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
            int ans = 0;
			while(row > 0) {
				row--;
				

				List<Integer> list = new ArrayList<>();
				// 윗줄에 사다리가 존재하는 구간 체크
				for(int i = 0; i < 100; i++) {
					if(ladder[row][i] == 1) list.add(i);
				}
				
				for(int i = 0; i < list.size(); i++) {
					// 2가 존재하는 col과 붙어있는 사다리가 있다면
					// 사다리의 길이만큼 이동
					// col - list.get(i) == 1이면 왼쪽으로 이동
					if(i > 0 && col - list.get(i) == 1) {
						while(i > 0 && col - list.get(i) == 1) {
							col--;
							i--;
						}
						break;
					}else if(i < list.size() && col - list.get(i) == -1) {
						// col - list.get(i) == 1이면 오른쪽으로 이동
						while(i < list.size() && col - list.get(i) == -1) {
							col++;
							i++;
						}
						break;
					}
				}

				
			}
            
            System.out.println("#" + test_case + " " + col);
		}
	}
}