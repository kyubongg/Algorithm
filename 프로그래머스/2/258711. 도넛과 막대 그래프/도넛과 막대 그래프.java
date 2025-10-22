import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int maxNode = 0;
        
        for(int i = 0; i < edges.length; i++){
            maxNode = Math.max(maxNode, edges[i][0]);
            maxNode = Math.max(maxNode, edges[i][1]);
        }
        
        // 들어오는 노드의 수
        // 나가는 노드의 수
        int[] inDegrees = new int[maxNode+1];
        int[] outDegrees = new int[maxNode+1];
        
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            
            inDegrees[to]++;
            outDegrees[from]++;
        }
        
    
        // 생성된 노드 찾기
        // inDegree = 0 && outDegree >= 2
        int gen = 0;
        for(int i = 1; i < maxNode+1; i++){
            if(inDegrees[i] == 0 && outDegrees[i] >= 2){
                gen = i;
                answer[0] = gen;
                break;
            }
        }
        
        // 막대그래프, 8자 그래프 찾기
        for(int i = 1; i < maxNode+1; i++){
            if(i == gen) continue;
            
            if(outDegrees[i] == 0 && inDegrees[i] == 0) continue;
            
            // 막대그래프: outDegree == 0 
            if(outDegrees[i] == 0){
                answer[2]++;
            }
            
            // 8자 그래프: inDegree >= 2 && outDegree == 2
            else if(inDegrees[i] >= 2 && outDegrees[i] == 2){
                answer[3]++;
            }
        }
        
        answer[1] = outDegrees[gen] - answer[2] - answer[3];
        
        
        return answer;
    }
}