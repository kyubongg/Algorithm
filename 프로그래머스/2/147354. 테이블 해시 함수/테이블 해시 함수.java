import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // col번째 컬럼 기준 오름차순 정렬 -> 기본키 (첫째줄) 값을 기준으로 내림차순 정렬
        // S_i = i번재 행의 모든 컬럼 값 모듈로 연산값
        // 구간 내의 모든 S_i를 XOR한 값 출력
        
        // PriorityQueue<int[]>로 오름차순 정렬 (col번째 행 기준 -> 1번째 행 기준)
        // 시간 복잡도 : O(NlogN) = 2500 * 11 = 27500
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                                     if (a[col-1] == b[col-1]) {
                                         return b[0] - a[0];
                                     } 
                                      return a[col-1] - b[col-1];
        });
        
        for (int i = 0; i < data.length; i++) {
            pq.add(data[i]);
        }
        
        int[][] arr = new int[pq.size() + 1][pq.peek().length];
        int idx = 1;
        while (!pq.isEmpty()) {
            arr[idx] = pq.poll();
            idx++;
        }
        
        for (int row = row_begin; row <= row_end; row++) {
            int[] curr = arr[row];
            int s_i = 0;

            for (int i = 0; i < curr.length; i++) {
                s_i += curr[i] % row;
            }
            
            answer ^= s_i;
        }
        
        
        return answer;
    }
}