import java.util.*;
class Solution {
    static int[][] costs;
    static int[][] memo;
    static int N;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        N = minerals.length;
        
        int groups = (int) Math.ceil(N / 5.0);
        int totalPicks = picks[0] + picks[1] + picks[2];
        groups = Math.min(groups, totalPicks);
        
        costs = new int[groups][3];
        memo = new int[groups][216];
        for (int i = 0; i < groups; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        for (int i = 0; i < groups; i++) {
            int dia = 0, iron = 0, stone = 0;
            
            for (int j = i * 5; j < Math.min(N, (i+1) * 5); j++) {
                String mineral = minerals[j];
                
                // 다이아 곡괭이
                dia += 1;
                
                // 철 곡괭이
                if (mineral.equals("diamond")) iron += 5;
                else iron += 1;
                
                // 돌 곡괭이
                if (mineral.equals("diamond")) stone += 25;
                else if (mineral.equals("iron")) stone += 5;
                else stone += 1;
            }
            
            costs[i][0] = dia;
            costs[i][1] = iron;
            costs[i][2] = stone;
            
        }
        
        
        return dfs(0, picks[0], picks[1], picks[2]);
    }
    
    static int dfs (int idx, int dia, int iron, int stone) {
        
        if ((dia == 0 && iron == 0 && stone == 0) || idx == costs.length) return 0;
        
        // 6진수 기반으로 곡괭이 사용 갯수 판별
        int state = dia * 36 + iron * 6 + stone;
        if (memo[idx][state] != -1) return memo[idx][state];
        
        int res = Integer.MAX_VALUE;
        if (dia > 0) res = Math.min(res, costs[idx][0] + dfs(idx + 1, dia - 1, iron, stone));
        if (iron > 0) res = Math.min(res, costs[idx][1] + dfs(idx + 1, dia, iron - 1, stone));
        if (stone > 0) res = Math.min(res, costs[idx][2] + dfs(idx + 1, dia, iron, stone - 1));
        
        return memo[idx][state] = res;
    }
}