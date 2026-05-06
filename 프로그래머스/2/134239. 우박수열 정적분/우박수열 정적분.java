import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> list = new ArrayList<>();
        int tmp = k;
        while (tmp != 1) {
            list.add(tmp);
            if (tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp *= 3;
                tmp += 1;
            }
        }
        list.add(1);
        
        double[] dimensions = new double[list.size()+1];
        for (int i = 1; i < list.size(); i++) {
            double left = list.get(i-1);
            double right = list.get(i);
            
            double dimension = (left + right) / 2;     // 높이는 1
            
            dimensions[i] = dimension + dimensions[i-1];
        }
        
        
        
        int n = list.size()-1;
        
        
        // [a, -b]에 대해 a ~ n-b, y = 0 구간의 정적분
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if (a > b) answer[i] = -1;
            else {
                answer[i] = dimensions[b] - dimensions[a];
            }
            
        }
        
        
        return answer;
    }
}