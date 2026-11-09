import java.util.*;
class Solution {
    
    static class Node {
        int idx;
        int cnt;
        
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    static List<Integer>[] nodes;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MIN_VALUE;
        
        // target이 존재하는지 확인
        boolean isTargetExist = false;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (target.equals(word)) isTargetExist = true;
        }
        
        if (!isTargetExist) return 0;
        
        // 한글자씩 다른 애들을 인접 리스트에 넣는다.
        nodes = new ArrayList[words.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        } 
        
        boolean[] idx = new boolean[words.length];      // begin과 한글자만 다른 word들의 인덱스 배열
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            int cnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == word.charAt(j)) cnt++;
            }
            
            if (cnt == begin.length() - 1) idx[i] = true;
        }
        
        
        for (int i = 0; i < words.length; i++) {
            String now = words[i];
            
            // word랑 한글자만 다른 단어들 찾기
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                
                String next = words[j];
                int equalCnt = 0;
                for (int k = 0; k < now.length(); k++) {
                    if (now.charAt(k) == next.charAt(k)) equalCnt++;
                }
                
                if (equalCnt == now.length() - 1) {
                    nodes[i].add(j);
                    nodes[j].add(i);
                }
            }
        }
        
        bfs(begin, target, words, idx);
        
        return answer;
    }
    
    static void bfs(String begin, String target, String[] words, boolean[] idx) {
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[nodes.length];
        
        // begin이랑 한글자 차이나는 단어들 집어넣기
        for (int i = 0; i < idx.length; i++) {
            if(idx[i]) {
                q.add(new Node(i, 1));
                isVisited[i] = true;
            }
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if(words[now.idx].equals(target)) answer = now.cnt;
            
            for (int next : nodes[now.idx]) {
                
                if (!isVisited[next]) {
                    // System.out.println(now.idx + " " + next + " " + (now.cnt+1));
                    q.add(new Node(next, now.cnt+1));
                    isVisited[next] = true;
                }
            }
        }
    }
}