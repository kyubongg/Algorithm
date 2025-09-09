import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
     
    static int[] p;
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
         
        int tc = sc.nextInt();
         
        for(int t = 1; t <= tc; t++) {
            int N = sc.nextInt();   // 사람 최대 번호
            int M = sc.nextInt();   // 주어지는 입력의 개수
             
            p = new int[N+1];
             
            for(int i = 0; i < N+1; i++) {
                p[i] = i;
            }
             
            for(int i = 0; i < M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                 
                union(from, to);
                union(to, from);
//              System.out.println(Arrays.toString(p));
            }
             
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i < p.length; i++) {
                set.add(p[i]);
            }
             
             
            System.out.println("#" + t + " " + set.size());
        }
         
    }
 
    static void union(int x, int y) {
        int num = find(y);
        for(int i = 1; i < p.length; i++) {
            if(p[i] == num) p[i] = find(x);
        }
         
    }
     
    static int find(int x) {
        if(p[x] != x) {
            p[x] = find(p[x]);
        }
         
        return p[x];
    }
}
