import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        boolean[] spoiler_range = new boolean[message.length()];
        for (int[] spoiler : spoiler_ranges) {
            int left = spoiler[0];
            int right = spoiler[1];
            
            for (int i = left; i <= right; i++) {
                spoiler_range[i] = true;
            }
        }
        
        // 스포 방지 구간에 한글자라도 걸려있는지 확인
        Map<String, List<Boolean>> wordMap = new HashMap<>();
        int currIdx = 0;
        for (String word : message.split(" ")) {
            
            int start = currIdx;
            int end = start + word.length() - 1;
            boolean isSpoiler = false;
            for (int i = start; i <= end; i++) {
                if (spoiler_range[i]) {
                    isSpoiler = true;
                    break;
                }
            }
            
            wordMap.putIfAbsent(word, new ArrayList<>());
            wordMap.get(word).add(isSpoiler);
            
            currIdx += word.length() + 1;
        }
        
        // 중요한 단어 카운트
        for (String word : wordMap.keySet()){
            List<Boolean> spoilerList = wordMap.get(word);
            
            boolean allSpoiled = true;
            for (boolean isSpoil : spoilerList) {
                if (!isSpoil) {
                    allSpoiled = false;
                    break;
                }
            }
            
            if (allSpoiled) answer++;
        }
        
        return answer;
    }
}