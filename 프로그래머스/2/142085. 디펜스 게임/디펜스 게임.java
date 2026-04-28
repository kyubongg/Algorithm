import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 무적권을 쓸지 말지 정해야하는 문제
        
        // 1. 1라운드부터 필요한 병사 수를 더한다. (sum)
        // 2. 필요한 병사 수(sum)가 n보다 작거나 같으면 넘어감
        // 3. sum이 n보다 크면 현재 더한 값 중 가장 큰 값에 무적권을 사용함. k--
        // 4. k가 0이 되었는데 sum이 n보다 커지면 중단하고 idx 값 리턴
        
        // 모든 값을 확인해야 하기 때문에 O(N) : enemy의 길이
        // 최대값이 뭔지 알아야함 (무적권을 쓰면 최대값만큼 n값을 더해야하기 때문에)
        // 내림차순 PriorityQueue를 사용하면 됨.
        
        int sum = 0;  
        PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            descPq.offer(enemy[i]);
            
            if (sum > n) {
                if (k > 0) {
                    k--;
                    sum -= descPq.poll();
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}