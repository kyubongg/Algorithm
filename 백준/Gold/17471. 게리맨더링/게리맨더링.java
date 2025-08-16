import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;	// 총 구역 수
	static int[] population; // 구역별 인구 수
	static List<List<Integer>> adjList;	// 인접 리스트
	static boolean[] selected;	// 조합 생성을 위한 배열(A 선거구)
	static int minDifference = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 구역 개수
		
		population = new int[N+1];
		selected = new boolean[N+1];
		adjList = new ArrayList<>();
		
		// 각 노드별 인접한 노드를 담을 리스트
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		// 인구수 받기
		for(int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			int numAdjacent = sc.nextInt();
			for(int j = 0; j < numAdjacent; j++) {
				int neighbor = sc.nextInt();
				adjList.get(i).add(neighbor);
			}
		}
		
		
		// 가장 많이 연결된 구역을 루트로 설정
		for(int i = 1; i <= N/2; i++) {
			generateCombinations(1, 0, i);
		}
		
		if(minDifference == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDifference);
		
		sc.close();
	}

	
	// 선거구 나누는 메서드
	// 시작 노드 번호, 선거구 개수, A 선거구 노드 개수
	public static void generateCombinations(int start, int count, int R) {
		if(count == R) {
			validateAndCalculate();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			selected[i] = true;
			generateCombinations(i+1, count+1, R);
			selected[i] = false;
		}
	}
	
	public static void validateAndCalculate() {
		List<Integer> areaA = new ArrayList<>();
		List<Integer> areaB = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			if(selected[i]) areaA.add(i);
			else areaB.add(i);
		}
		
		if (areaA.isEmpty() || areaB.isEmpty()) {
            return;
		}
		
		if(isConnected(areaA) && isConnected(areaB)) {
			int popA = calculatePopulation(areaA);
			int popB = calculatePopulation(areaB);
			minDifference = Math.min(minDifference, Math.abs(popA - popB));
		}
	}
	
	public static boolean isConnected(List<Integer> area) {
		if(area.size() <= 1) return true;
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[N+1];
		
		int startNode = area.get(0);
		queue.offer(startNode);
		isVisited[startNode] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			// 같은 선거구이면서, 아직 방문하지 않았다면
			for(int neighbor: adjList.get(current)) {
				if(selected[current] == selected[neighbor] && !isVisited[neighbor]) {
					isVisited[neighbor] = true;
					queue.offer(neighbor);
					count++;
				}
			}
		}
		
		return area.size() == count;
	}
	
	public static int calculatePopulation(List<Integer> area) {
		int sum = 0;
		for(int i : area) {
			sum += population[i];
		}
		
		return sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
