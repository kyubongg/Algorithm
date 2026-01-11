import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int KEYMAP_LENGTH = keymap.length;
        int TARGETS_LENGTH = targets.length;
        
        int[] answer = new int[TARGETS_LENGTH];
        int[] keys = new int[26];
        
        Arrays.fill(keys, 101);
        
        for(int i = 0; i < KEYMAP_LENGTH; i++) {
            String str = keymap[i];
            
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                
                if(j+1 < keys[ch-'A']) {
                    keys[ch-'A'] = j+1;
                }
            }
        }
        
        
        for(int i = 0; i < TARGETS_LENGTH; i++) {
            String target = targets[i];
            int count = 0;
            boolean isPossible = true;
            
            for(int j = 0; j < target.length(); j++) {
                char alphabet = target.charAt(j);
                
                if(keys[alphabet-'A'] == 101){
                    isPossible = false;
                    break;
                }
                count += keys[alphabet-'A']; 
            }
            
            if(isPossible) {
                answer[i] = count;
            }else{
                answer[i] = -1;
            }
            
            
        }
        
        return answer;
    }
}