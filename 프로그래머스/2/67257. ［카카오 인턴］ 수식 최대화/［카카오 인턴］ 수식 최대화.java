import java.util.*;
class Solution {
    
    static Character[] opArr;
    static boolean[] visited;
    static List<Long> operands;
    static List<Character> operators;
    static long max = Long.MIN_VALUE;
    public long solution(String expression) {
        
        // 수식에 존재하는 연산자 찾기
        Set<Character> opSet = new HashSet<>();
        operands = new ArrayList<>();
        operators = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            
            if(Character.isDigit(ch)) {
                sb.append(ch); 
            }else{
                opSet.add(ch);
                operators.add(ch);
                operands.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }
        }
        
        operands.add(Long.parseLong(sb.toString()));
        
        opArr = opSet.toArray(new Character[0]);
        visited = new boolean[opSet.size()];
        
        getComb(new ArrayList<>());
        return max;
    }
    
    static void getComb(List<Character> list){
        if(list.size() == opArr.length){
            getCost(list);
            return;
        }
        
        for(int i = 0; i < opArr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(opArr[i]);
                getComb(list);
                
                list.remove(list.size() - 1);
                visited[i] = false;
            }
            
        }
    }
    
    
    static void getCost(List<Character> list){
        
        // 연산자, 피연산자 리스트 복사
        List<Long> operandsList = new ArrayList<>(operands);
        List<Character> operatorsList = new ArrayList<>(operators);
        
        // exprssion 탐색하면서 연산자 찾기
        for(char op : list){
            
            for(int i = 0; i < operatorsList.size(); i++){
                if(op == operatorsList.get(i)){
                    
                    long num1 = operandsList.remove(i);
                    long num2 = operandsList.remove(i);
                    char operator = operatorsList.remove(i);
                    
                    long result = 0;
                    if(op == '*') result = num1 * num2;
                    else if(op == '+') result = num1 + num2;
                    else result = num1 - num2;
                    
                    operandsList.add(i, result);
                    
                    i--;
                } 
            }
 
        }
        
        // System.out.println(operandsList);
        max = Math.max(max, Math.abs(operandsList.get(0)));
        
        return;
    }
    
    
    
}