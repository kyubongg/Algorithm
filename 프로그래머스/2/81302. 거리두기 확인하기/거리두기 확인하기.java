import java.util.*;

class Solution {
    
    static int PLACE_NUM = 5;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 상 우 하 좌
    public int[] solution(String[][] places) {
        int[] answer = new int[PLACE_NUM];
        
        // BFS 사용
        // 1. 다음 지점의 원소가 O이면 해당 지점의 다음 지점 탐색
        // 2. 다음 지점의 원소가 X면 탐색 중지
        // 3. 다음 지점이 P이면
        //  3.1. 출발점과 맨해튼 거리가 2 이하인지 판단
        //  3.1.1. 2이하이면 0 리턴
        //  3.1.2. 2초과이면 다음 P부터 탐색 시작
        
        // 대기실 선택 반복문(0~4)
        for(int i = 0; i < PLACE_NUM; i++){
            String[] placeString = places[i];
            
            String[][] place = new String[PLACE_NUM][PLACE_NUM];
            for(int r = 0; r < PLACE_NUM; r++){
                place[r] = placeString[r].split("");
            }
            
            boolean isTrue = true;
            // P의 위치 찾기
            find_P:
            for(int r = 0; r < PLACE_NUM; r++){
                for(int c = 0; c < PLACE_NUM; c++){
                    String element = place[r][c];
                    
                    if(element.equals("P")){
                        boolean[][] visited = new boolean[PLACE_NUM][PLACE_NUM];
                        Queue<int[]> bfsQ = new ArrayDeque<>();
                        bfsQ.add(new int[] {r, c});
                        visited[r][c] = true;
                        
                        while(!bfsQ.isEmpty()){
                            int[] idx = bfsQ.poll();
                            
                            // 현재위치 기준 사방탐색(상 우 하 좌)
                            for(int j = 0; j < 4; j++){
                                int nr = idx[0] + drc[j][0];
                                int nc = idx[1] + drc[j][1];
                                
                                // System.out.println(nr + " " + nc);
                                
                                if(nr >= 0 && nr < PLACE_NUM && nc >= 0 && nc < PLACE_NUM && !visited[nr][nc] && manhatenIns(r, c, nr, nc)){
                                     
                                    if(place[nr][nc].equals("O")){
                                        visited[nr][nc] = true;
                                        bfsQ.add(new int[]{nr, nc});
                                    }else if(place[nr][nc].equals("P")){
                                        // 한명이라도 지키지 않으면 0을 리턴해야하기 때문에 현재 대기실 반복문 전체 종료
                                        isTrue = false;
                                        break find_P;
                                    }
                                }
                            }
                        } // while
                        
                    } // element.equals("P")
                }
            }
            
            if(isTrue) answer[i] = 1;
            else answer[i] = 0;
            
            
        }
        
        
        return answer;
    }
    
    // true: 맨해튼 거리가 2이하이다.
    // false: 맨해튼 거리가 2초과이다.
    static boolean manhatenIns(int r, int c, int nr, int nc){
        
        return (Math.abs(r - nr) + Math.abs(c - nc)) <= 2;
    }
}
