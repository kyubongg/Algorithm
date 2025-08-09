import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] minions = new int[9];
		int totalSum = 0;
		for(int i = 0; i < minions.length; i++) {
			minions[i] = sc.nextInt();
			totalSum += minions[i];
		}
		
		// 7개를 더했을 때 100이 되는 수를 찾지말고
		// 9개를 더한 값에서 2개를 뺐을 때 100이 되는 수를 찾는게 더 쉽다.
		
		// tmi.위의 방법으로 했을 때 방법이 생각나지 않아서 인터넷에 검색했음
		// 발상의 전환을 해보는 것도 중요한듯?
		int num1 = 0;
		int num2 = 0;
		
		for(int i = 0; i < minions.length; i++) {
			for(int j = i+1; j < minions.length; j++) {
				if(totalSum - (minions[i] + minions[j]) == 100) {
					num1 = minions[i];
					num2 = minions[j];
				}
			}
			
		}
		
		Arrays.sort(minions);

		for(int i = 0; i < minions.length; i++) {
			if(minions[i] == num1 || minions[i] == num2) continue;
			System.out.println(minions[i]);
		}
		
	}

}
