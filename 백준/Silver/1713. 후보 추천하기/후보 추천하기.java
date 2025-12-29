import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int imageLen = sc.nextInt();
		int recommendCnt = sc.nextInt();
		
		int[] students = new int[101];	// 학생수: 1 ~ 100
		int[] recommendTime = new int[101];	// 추천받은 시간
		int frames = 0;
		
		
		for(int i = 1; i <= recommendCnt; i++) {
			int studentNum = sc.nextInt();
			
			// 추천받은 학생이 사진틀에 있는 경우
			if(recommendTime[studentNum] > 0) {
				students[studentNum]++;
			}
			// 추천받은 학생이 사진틀에 없는 경우
			else {
				if (frames == imageLen) {
					int target = 0;
					int minRecommend = Integer.MAX_VALUE;
                    int oldestTime = Integer.MAX_VALUE;
                    
                    for(int j = 1; j <= 100; j++) {
                    	if(students[j] > 0) {
                    		// 가장 작은 추천수를 가진 학생보다 추천수가 작을 때
                        	if(students[j] < minRecommend) {
                        		target = j;
                        		minRecommend = students[j];
                        		oldestTime = recommendTime[j];
                        	} 
                        	// 가장 작은 추천수를 가진 학생과 추천수가 같을 때
                        	else if (students[j] == minRecommend) {
                        		// 추천받은 시간을 기준으로 삭제할 학생 찾음
                        		if (recommendTime[j] < oldestTime) {
                        			target = j;
                        			oldestTime = recommendTime[j];
                        		}
                        	}
                    	}
                    	
                    }
				
                    students[target] = 0;
                    recommendTime[target] = 0;
                    frames--;
				}
				
				students[studentNum] = 1;
				recommendTime[studentNum] = i;
				frames++;
			}
		}
	
		for(int i = 1; i <= 100; i++) {
			if(students[i] > 0)
				System.out.print(i + " ");
		}
		
		sc.close();
	}

}
