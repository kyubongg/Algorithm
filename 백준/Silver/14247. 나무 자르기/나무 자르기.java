import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Tree implements Comparable<Tree>{
		int initHeight, growHeight;
		
		public Tree(int initHeight, int growHeight) {
			this.initHeight = initHeight;
			this.growHeight = growHeight;
		}

		@Override
		public int compareTo(Tree o) {
			return this.growHeight - o.growHeight;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		
		
		// 기본 나무 길이는 다 더함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer init = new StringTokenizer(br.readLine());
		StringTokenizer grow = new StringTokenizer(br.readLine());
		
		Tree[] trees = new Tree[N];
		
		for(int i = 0; i < N; i++) {
			trees[i] = new Tree(Integer.parseInt(init.nextToken()), Integer.parseInt(grow.nextToken()));
		}
		
		long total = 0;
		Arrays.sort(trees);
		
		for(int i = 0; i < N; i++) {
			total += trees[i].initHeight + trees[i].growHeight * i;
		}
		
		System.out.println(total);
	}
}
