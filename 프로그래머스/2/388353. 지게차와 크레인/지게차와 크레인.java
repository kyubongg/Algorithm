import java.util.*;
class Solution {
    
    static char[][] containerMap;
    static int[][] drc = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int answer = 0;
    public int solution(String[] storage, String[] requests) {
        containerMap = new char[storage.length][storage[0].length()];
        
        // 창고를 이중 리스트 형식으로 저장
        for(int i = 0; i < storage.length; i++){
            containerMap[i] = storage[i].toCharArray();
        }
        
        answer = storage.length * storage[0].length();
        
        for(int i = 0; i < requests.length; i++){
            String request = requests[i];
            
            delivery(request);
        }
        
        return answer;
    }
    
    // 크레인을 사용한 출고요청
    // 요청에 들어온 컨테이너를 전부 출고한다.
    static void delivery(String request){
        
        // request.length() == 2 => 크레인 출고
        // request.length() == 1 => 지게차 출고
        char target = request.charAt(0);
        
        // 크레인 출고는 창고에 있는 모든 컨테이너를 뺄 수 있다.
        if(request.length() == 2){
            for(int r = 0; r < containerMap.length; r++){
                for(int c = 0; c < containerMap[r].length; c++){
                    if(containerMap[r][c] == target) {
                        answer--;
                        containerMap[r][c] = '0';
                    }
                }
            }
            
        }
        // 지게차 출고는 창고에 있는 컨테이너중 외곽에 있는 컨테이너만 뺄 수 있다.
        // bfs 사용
        else{
            List<int[]> removeContainer = new ArrayList<>();
            for(int r = 0; r < containerMap.length; r++){
                for(int c = 0; c < containerMap[r].length; c++){
                    if(containerMap[r][c] == target) {
                        
                        Queue<int[]> q = new ArrayDeque<>();
                        boolean[][] visited = new boolean[containerMap.length][containerMap[r].length];
                        q.add(new int[]{r, c});
                        visited[r][c] = true;
                        
                        while(!q.isEmpty()){
                            int[] curr = q.poll();
                            
                            for(int i = 0; i < 4; i++){
                                int nr = curr[0] + drc[i][0];
                                int nc = curr[1] + drc[i][1];
                                
                                if(nr >= 0 && nr < containerMap.length && nc >= 0 && nc < containerMap[r].length){
                                    if(!visited[nr][nc] && containerMap[nr][nc] == '0'){
                                        visited[nr][nc] = true;
                                        q.add(new int[] {nr, nc});
                                    }
                                }else{
                                    removeContainer.add(new int[] {r, c});
                                    q.clear();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            
            for(int[] arr : removeContainer){
                containerMap[arr[0]][arr[1]] = '0';
                answer--;
            }
        }
        
        
        return;
        
    }

}