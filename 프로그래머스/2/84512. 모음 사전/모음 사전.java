class Solution {
    
    static String[] alphabets = {"A", "E", "I", "O", "U"};
    static int answer, k;
    static boolean found;
    public int solution(String word) {
        answer = 0;
        k = 0;
        found = false;
        
        getSequence(word, "");
        
        return answer;
    }
    
    static void getSequence(String word, String str) {
        if (str.length() > 5 || found) {
            return;
        }
        
        if (word.equals(str)) {
            answer = k;
            found = true;
            return;
        }
        
        k++;
        for (int i = 0; i < alphabets.length; i++) { 
            
            getSequence(word, str + alphabets[i]);
        }
        
    }
}
