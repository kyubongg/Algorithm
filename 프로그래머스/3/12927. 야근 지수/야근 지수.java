import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 모든 수를 제곱해서 더한 것중에 제일 작은 값을 찾는거임
        // 평탄화를 해야함
        
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < works.length; i++) {
            sum += works[i];
            max = Math.max(max, works[i]);
            map.put(works[i], map.getOrDefault(works[i], 0) + 1);    
        }
        
        if (sum <= 0) return 0;
       
        while(max > 0) {
            int cnt = map.get(max);
            
            
            if(n - cnt == 0) {
                map.put(max-1, map.getOrDefault(max-1, 0) + cnt);
                map.remove(max);
                max--;
                n -= cnt;
                break;
            }
            else if (n - cnt > 0) {
                map.put(max-1, map.getOrDefault(max-1, 0) + cnt);
                map.remove(max);
                max--;
                n -= cnt;
            } else {
                map.put(max-1, map.getOrDefault(max-1, 0) + n);
                map.put(max, cnt - n);
                break;
            }
        }

       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer += (long)Math.pow(entry.getKey(), 2) * entry.getValue();
        }
    
        
        
        return answer;
    }
}