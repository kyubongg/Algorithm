import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node>{
        int num, dist;

        public Node(int c, int weight) {
            this.num = c;
            this.dist = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }

        @Override
        public String toString() {
            return "[num: " + num + ", dist: " + dist + "]";
        }
    }

    static List<Integer>[] trees;
    static boolean[] isChecked;
    static int leaf = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        isChecked = new boolean[N+1];
        trees = new ArrayList[N+1];
        for (int i = 0; i < N; i++) {
            trees[i] = new ArrayList<>();
        }

        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                roots.add(i);
                continue;
            }

            trees[parent].add(i);
        }

        int removeNode = Integer.parseInt(br.readLine());

        int answer = 0;

        trees[removeNode] = null;
        for (int i = 0; i < N; i++) {
            if (i == removeNode) continue;

            for (int j = 0; j < trees[i].size(); j++) {
                if (trees[i].get(j) == removeNode) {
                    trees[i].remove(j);
                    break;
                }
            }
        }


        for (int i = 0; i < roots.size(); i++) {
            int root = roots.get(i);
            dfs(root, trees[root]);
        }

        answer = leaf;


        System.out.println(answer);
    }

    static void dfs(int curr, List<Integer> nextNodes) {
        if (trees[curr] == null) return;

        // 밑에 달려있는 노드가 없으면 리프 노드임
        if (!isChecked[curr] && trees[curr].isEmpty()) {
            isChecked[curr] = true;
            leaf++;
            return;
        }

        for (int next : nextNodes) {
            dfs(next, trees[next]);
        }

    }
}
