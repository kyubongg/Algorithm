import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt()-1;
            char d = sc.next().charAt(0);
            boolean[] visited = new boolean[a.length];

            // 바람이 왼쪽에서 불 때
            if (d == 'L') {
                rotateRight(a, r, visited);
            } 
            // 바람이 오른쪽에서 불 때
            else {
                rotateLeft(a, r, visited);
            }


        }

        
        // Please write your code here.
       for(int r = 0; r < a.length; r++) {
        for (int c = 0; c < a[r].length; c++) {
            System.out.print(a[r][c] + " ");
        }
        System.out.println();
       }
    }

    // 왼쪽으로 밀리는 메서드
    // 오른쪽에서 바람이 붐
    static void rotateLeft (int[][] a, int r, boolean[] visited) {

        if(r < 0 || r >= a.length || visited[r]) return;

        visited[r] = true;

        // 위 아래 영향여부 변수
        boolean topEffect = false;
        boolean bottomEffect = false;
        
        // 첫번째 값 tmp에 저장
        int tmp = a[r][0];
        if (r > 0 && tmp == a[r-1][a[r].length - 1]) topEffect = true;
        if (r < a.length-1 && tmp == a[r+1][a[r].length-1]) bottomEffect = true;

        for (int i = 0; i < a[r].length-1; i++) {

            // 위쪽에 영향이 있는지 판단
            if (r > 0 && a[r][i+1] == a[r-1][i]) {
                topEffect = true;
            } 

            // 아래쪽에 영향이 있는지 판단
            if (r < a.length-1 && a[r][i+1] == a[r+1][i]){
                bottomEffect = true;
            }

            a[r][i] = a[r][i+1];
        }

        a[r][a[r].length-1] = tmp;

        if (topEffect && r-1 >= 0) {
            rotateRight(a, r-1, visited);
        }

        if (bottomEffect && r < a.length-1) {
            rotateRight(a, r+1, visited);
        }
    }

    // 오른쪽으로 밀리는 메서드
    // 왼쪽에서 바람이 붐
    static void rotateRight (int[][] a, int r, boolean[] visited) {

        if(r < 0 || r >= a.length || visited[r]) return;

        visited[r] = true;

        // 위 아래 영향여부 변수
        boolean topEffect = false;
        boolean bottomEffect = false;

        int length = a[r].length;
        int tmp = a[r][length-1];

        if (r > 0 && tmp == a[r-1][0]) topEffect = true;
        if (r < a.length-1 && tmp == a[r+1][0]) bottomEffect = true;
        for (int i = length - 1; i > 0; i--) {
            // 위쪽에 영향이 있는지 판단
            if (r > 0 && a[r][i-1] == a[r-1][i]) {
                topEffect = true;
            } 

            // 아래쪽에 영향이 있는지 판단
            if (r < a.length-1 && a[r][i-1] == a[r+1][i]){
                bottomEffect = true;
            }

            a[r][i] = a[r][i-1];
        }

        a[r][0] = tmp;

        if (topEffect && r-1 >= 0) {
            rotateLeft(a, r-1, visited);
        }

        if (bottomEffect && r < a.length-1) {
            rotateLeft(a, r+1, visited);
        }

    }
}