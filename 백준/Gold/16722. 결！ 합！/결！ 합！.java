import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Diagram {
		String shape, color, bgColor;
		
		public Diagram(String shape, String color, String bgColor) {
			this.shape = shape;
			this.color = color;
			this.bgColor = bgColor;
		}
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// 합 : 그림의 세가지 속성이 모두 같거나 모두 다른 세장의 그림 조합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Diagram[] diagrams = new Diagram[10];
		StringTokenizer st;
		
		for(int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			
			String shape = st.nextToken();
			String color = st.nextToken();
			String bgColor = st.nextToken();
			
			diagrams[i] = new Diagram(shape, color, bgColor);
		}
		
		List<Set<Integer>> allHaps = new ArrayList<>();
		
        // set을 이용해서 합이 되는 조합 찾기
		for(int i = 1; i <= 7; i++) {
			for (int j = i+1; j <= 8; j++) {
				for (int m = j+1; m <= 9; m++) {
					if(isHap(diagrams[i], diagrams[j], diagrams[m])) {
						Set<Integer> set = new HashSet<>();
						set.add(i); set.add(j); set.add(m);
						allHaps.add(set);
					}
				}
				
				
			}
		}
		 
		int score = 0;
		boolean gyulCalled = false;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			
			// 합 외치기
			if(type.equals("H")) {
				Set<Integer> currentTry = new HashSet<>();
				for(int k = 0; k < 3; k++) {
					currentTry.add(Integer.parseInt(st.nextToken()));
				}
				
				int foundIndex = -1;
				for(int j = 0; j < allHaps.size(); j++) {
					if(allHaps.get(j).equals(currentTry)) {
						foundIndex = j;
						break;
					}
				}
				
				if (foundIndex != -1) {
					score += 1;
					allHaps.remove(foundIndex);
				} else {
					score -= 1;
				}
			} 
			// 결 외치기
			else {
				if (allHaps.isEmpty() && !gyulCalled) {
					score += 3;
					gyulCalled = true;
				} else {
					score -= 1;
				}
			}
		}
		
		System.out.println(score);
		
	}
	
    // 한 요소의 set 크기가 2가 되면 합이 아님
	static boolean isHap(Diagram diagram1, Diagram diagram2, Diagram diagram3) {
		
	    Set<String> shapes = new HashSet<>();
	    shapes.add(diagram1.shape); shapes.add(diagram2.shape); shapes.add(diagram3.shape);
	    if (shapes.size() == 2) return false;

	   
	    Set<String> colors = new HashSet<>();
	    colors.add(diagram1.color); colors.add(diagram2.color); colors.add(diagram3.color);
	    if (colors.size() == 2) return false;

	  
	    Set<String> bgColors = new HashSet<>();
	    bgColors.add(diagram1.bgColor); bgColors.add(diagram2.bgColor); bgColors.add(diagram3.bgColor);
	    if (bgColors.size() == 2) return false;
	    
	    return true;
	}
	
	
	
}
