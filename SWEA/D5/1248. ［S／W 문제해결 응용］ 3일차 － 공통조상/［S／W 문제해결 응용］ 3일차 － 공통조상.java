
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static int cnt = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			cnt = 0;
			int V = sc.nextInt();   // 정점의 개수
			int E = sc.nextInt();	// 간선의 개수
			int desc1 = sc.nextInt();	// 공통 조상을 찾는 자손 1
			int desc2 = sc.nextInt();   // 공통 조상을 찾는 자손 2
			
			int[][] tree = new int[V+1][3];	// 1~V까지 다룰거고, 왼자/오자/부모를 저장하기 위해서 이렇게 선언
			
			// 트리를 채울 때 왼쪽, 오른쪽 선택 기준이 없는거 같기 때문에
			// 왼쪽 -> 오른쪽으로 채움
			for(int i = 0; i < V-1; i++) {
				int p = sc.nextInt();		// 부모 노드
				int c = sc.nextInt(); 		// 자식 노드
				
				if(tree[p][0] == 0) tree[p][0] = c;
				else tree[p][1] = c;
				
				tree[c][2] = p;
			}

			// 최상위 노드를 찾아야함

			List<Integer> ances1 = getAnces(tree, desc1);
			List<Integer> ances2 = getAnces(tree, desc2);

//			System.out.println("==========================");
//			System.out.println(ances1.toString());
//			System.out.println(ances2.toString());
			int common = 0;
			

			for(int i = 0; i < ances1.size(); i++) {
				for(int j = 0; j < ances2.size(); j++) {
					if(ances1.get(i).equals(ances2.get(j))) {
						common = ances1.get(i);
//						System.out.println(common);
					}
				}
				
				if(common != 0) {
					break;
				}
			}
			
//			System.out.println("common: " + common);
//			System.out.println("V: " + V);
//			System.out.println("desc1: " + desc1);
//			System.out.println("desc2: " + desc2);
			preOrder(tree, common);
			System.out.println("#" + t + " " + common + " " + cnt);
			
			
		}
	}
	
	public static List<Integer> getAnces(int[][] tree, int num) {
		
		List<Integer> list = new ArrayList<>();
		
//		if()
		int curr = num;
		while(curr != 0) {
			list.add(curr);
			curr = tree[curr][2];
		}
		
		return list;
	}
	
	
	public static void preOrder(int[][] tree, int num) {
		if(num == 0) return;
		
		cnt++;
		preOrder(tree, tree[num][0]);
		preOrder(tree, tree[num][1]);
	}
	
	
}
