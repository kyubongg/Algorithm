import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people); // 오름차순 정렬
        
        // 최대 2명 탑승 가능
        // 가장 무거운 사람은 가장 가벼운 사람이랑 타야함
        
        // 투포인터
        int min = 0;
        int max = people.length - 1;
        
        while (max >= min) {
            int sum = people[min] + people[max];
            // 둘이 구명보트를 탈 수 없을때는 max를 낮추고 혼자 타야하므로 보트수를 늘린다
            if (sum > limit) {
                max--; 
            } else {
                // 둘이 탈 수 있을 때는 min++, max--를 하고 둘이 같이 타므로 보트수를 한개 늘린다.
                min++;
                max--;
            }
            
            answer++;
            
        }
        
        
        return answer;
    }
}