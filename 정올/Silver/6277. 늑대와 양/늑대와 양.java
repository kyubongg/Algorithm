import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[][] isVisited;
    static int R, C, wolf, sheep;
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                char inputChar = input.charAt(c);
                if (inputChar == '#') isVisited[r][c] = true;

                map[r][c] = inputChar;
            }
        }

        /**
         * '.': 빈 필드
         * '#': 울타리
         * 'o': 양, 'v': 늑대
         *
         *  한칸에서 수평/수직으로만 이동하면 울타리를 지나지 않는다면 두 칸은 같은 영역이라고 판단
         *
         *  양 vs 늑대 했을 때 수가 더 많은쪽이 이긴다.
         *
         *  R, C는 3 이상 250 이하
         */
        wolf = 0; sheep = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!isVisited[r][c]) {
                    getCountInArea(r, c, 0, 0);
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }

    /**
     * bfs 사용
     *
     * 1. isVisited 배열에서 '#'은 미리 true로 만든다.
     * 2. isVisited 배열을 순회하면서 false인 칸을 찾는다.
     *  2-1. false라면 영역 탐색 시작 (Queue를 이용)
     *   2-1-1. 영역 내부의 양, 늑대 수를 count
     *   2-1-2. 영역 탐색이 끝났을 때 숫자가 더 많은 동물의 수를 각자에 맞게 더한다.
     *
     * @param r: 현재 행
     * @param c: 현재 열
     * @param wolf: 현재 영역의 늑대 수
     * @param sheep: 현재 영역의 양 수
     */
    static void getCountInArea(int r, int c, int nowWolf, int nowSheep) {
//        System.out.println(r + ", " + c + ": " + nowWolf + " " + nowSheep);
        // bfs 알고리즘을 사용하기 위해 Queue를 이용해 사방탐색을 함.
        Queue<int[]> queue = new ArrayDeque<>();

        // 시작 칸 방문처리 및 queue에 삽입
        queue.add(new int[] {r,c});
        isVisited[r][c] = true;

        if (map[r][c] == 'v') nowWolf++;
        else if (map[r][c] == 'o') nowSheep++;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = arr[0] + drc[i][0];
                int nc = arr[1] + drc[i][1];


                // nr, nc가 map 영역 내부이고 방문한 곳이 아니라면 진행
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});

                    if (map[nr][nc] == 'v') nowWolf++;
                    else if (map[nr][nc] == 'o') nowSheep++;
                }
            }
        }


        if (nowWolf < nowSheep) sheep += nowSheep;
        else wolf += nowWolf;

    }
}
