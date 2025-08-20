import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] students = new int[31];
		for(int i = 0; i < 28; i++) {
			int studentIdx = sc.nextInt();
			students[studentIdx]++;
		}
		
		int[] no = new int[2];
		int idx = 0;
		
		for(int i = 1; i < students.length; i++) {
			if(students[i] == 0) {
				no[idx++] = i;
//				no[idx] = i;
//				idx++; 
			}
		}
		
		System.out.println(no[0]);
		System.out.println(no[1]);
	}

}
