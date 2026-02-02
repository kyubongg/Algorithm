import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] maxLen = new int[6];
		int[] currentLen = new int[6];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            for(int grade = 1; grade <= 5; grade++) {
            	if(grade == a || grade == b) {
            		currentLen[grade]++;
            	}else {
            		currentLen[grade] = 0;
            	}
            	
            	if (currentLen[grade] > maxLen[grade]) {
            		maxLen[grade] = currentLen[grade];
            	}
            }
		}
		
		int maxStudents = 0;
		int minGrade = 0;
		
		for(int grade = 1; grade <= 5; grade++) {
			if (maxLen[grade] > maxStudents) {
				maxStudents = maxLen[grade];
				minGrade = grade;
			} else if (maxLen[grade] == maxStudents && minGrade == 0) {
				minGrade = grade;
			}
		}
		
		
		System.out.println(maxStudents + " " + minGrade);
	}
}
