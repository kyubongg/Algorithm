import java.util.*;
import java.io.*;

public class Main {
    static int N, M, Q;
    static int[][] tower;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException{
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tower = new int[N+1][M+1];
        for (int r = 1; r < N+1; r++) {

            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < M+1; c++) {
                tower[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            windOneTime(r1, c1, r2, c2);
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                System.out.print(tower[r][c] + " ");
            }
            System.out.println();
        }
    }

    // 시계방향으로 한바퀴 돌리는 메서드
    static void windOneTime(int r1, int c1, int r2, int c2) {
        
        // r1, c1 ~ r2, c2 시계방향 회전
        // 왼쪽 위 값 tmp에 저장
        int tmp = tower[r1][c1];
        
        // 왼쪽 열(c1) 위로 올리기
        for (int r = r1; r < r2; r++) {
            tower[r][c1] = tower[r+1][c1];
        }

        // 아래쪽 행(r2) 왼쪽으로 옮기기 
        for (int c = c1; c < c2; c++) {
            tower[r2][c] = tower[r2][c+1];
        }

        // 오른쪽 열(c2) 위로 올리기
        for (int r = r2; r > r1; r--) {
            tower[r][c2] = tower[r-1][c2];
        }

        // 위쪽 행(r2) 오른쪽으로 옮기기 
        for (int c = c2; c > c1+1; c--) {
            tower[r1][c] = tower[r1][c-1];
        }

        tower[r1][c1+1] = tmp;

        // for (int r = 0; r <= N; r++) {
        //     for (int c = 0; c <= M; c++) {
        //         System.out.print(tower[r][c] + " ");
        //     }
        //     System.out.println();
        // }

        getMean(r1, c1, r2, c2);
    }

    // 평균값을 구하는 메서드
    static void getMean(int r1, int c1, int r2, int c2){

        int[][] tmp = new int[N+1][M+1];
        
        
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                
                // 총 몇개의 값의 평균인지 확인하기 위한 cnt 변수
                int cnt = 1;
                // 본인값과 사방에 있는 값을 더하기
                tmp[r][c] = tower[r][c];
                for (int i = 0; i < 4; i++) {
                    int nr = r + drc[i][0];
                    int nc = c + drc[i][1];

                    if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                        tmp[r][c] += tower[nr][nc];
                        cnt++;
                    }
                }

                tmp[r][c] = tmp[r][c] / cnt;
            }
        }
        
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                tower[r][c] = tmp[r][c];
            }
            
        }
    }
}