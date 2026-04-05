import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase(); // 시작부터 대문자로 변환

        int[] alphabet = new int[26];

        // 1. 각 알파벳 빈도수 계산
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'A']++;
        }

        int max = -1;
        char answer = '?';

        // 2. 가장 많이 나온 알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                answer = (char) (i + 'A'); // 다시 문자로 변환
            } else if (alphabet[i] == max) {
                answer = '?'; // 최댓값이 중복되면 '?'
            }
        }

        System.out.println(answer);
    }
}