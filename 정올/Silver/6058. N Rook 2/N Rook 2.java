import java.io.*;
import java.util.*;

public class Main {
    
    static String[][] map;
    static int N, ans;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        
        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().split("");
        }
        
        /*
         * 문제 조건
         * - '.'은 빈칸, '#'은 장애물
         * - 체스 rook은 가로 세로에 있는 다른 말을 잡을 수 있다
         * - 체스판에 N개의 rook들을 배치할 때 서로 잡을 수 없게 배치하는 경우의 수를 출력한다. 
         * - N은 1~9 사이의 정수
         * 
         * 계획 1 (dfs)
         * - 0번째 행부터 N번째 행까지 rook을 배치함
         * - 길이가 N인 boolean 배열을 둠
         * - 재귀 함수를 이용해서 i번째 열에 rook을 배치하고 boolean 배열의 i 인덱스를 true로 변경
         * - 다음 함수 호출에 해당 배열 넘김 
         * - 배치한 rook의 수가 N과 같아지면 ans 증가
         * 
         */
        
        
        dfs(0, new boolean[N] , 0);
        
        System.out.println(ans);
    } 
    
    static void dfs(int r, boolean[] cols, int nRook) {
        
        // 모든 rook을 배치한 경우 리턴
        if (nRook == N) {
            ans++;
            return;
        }
        
        for (int c = 0; c < N; c++) {
            // 이미 한개의 rook이 배치된 열이면 건너뜀
            if (cols[c]||map[r][c].equals("#")) continue;
            
            cols[c] = true;
            dfs(r+1, cols, nRook+1);
            cols[c] = false;
        }
    }
    
}
