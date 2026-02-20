import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Word implements Comparable<Word>{
		String key, original;
		
		public Word(String key, String original) {
			this.key = key;
			this.original = original;
		}

		@Override
		public int compareTo(Word o) {
			return this.key.compareTo(o.key);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		/**
		 * abakada : 1213141
		 * ako     : 1313
		 * alpabet : 191412517
		 * tagalog : 
		 */
		
		// 알파벳을 숫자로 변환
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> alphabetMap = new HashMap<>();
		
		String[] alphabets = {
                "a", "b", "k", "d", "e", "g", "h",
                "i", "l", "m", "n", "ng", "o",
                "p", "r", "s", "t", "u", "w", "y"
        };

        for (int i = 0; i < alphabets.length; i++) {
            alphabetMap.put(alphabets[i], i);
        }
		
        List<Word> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	String word = br.readLine();
        	String key = buildKey(word, alphabetMap);
        	list.add(new Word(key, word));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (Word w : list) {
        	sb.append(w.original).append("\n");
        }
        
        System.out.println(sb);
	}
	
	public static String buildKey(String word, Map<String, Integer> alphabetMap) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		while (i < word.length()) {
			char ch = word.charAt(i);
			
			// ng
			if (ch == 'n' && i+1 < word.length() && word.charAt(i+1) == 'g') {
				int value = alphabetMap.get("ng");
				sb.append((char) ('a' + value));
				i += 2;
			} else {
				int value = alphabetMap.get(String.valueOf(ch));
				sb.append((char) ('a' + value));
				i += 1;
			}
		}
		
		return sb.toString();
		
	}
}
