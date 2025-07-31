import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		// 중요한점 : 어디까지가 한 단어인지 판단하기
        // 1. 한글자씩 잘라서 같은 글자가 나올떄까지 리스트에 넣는다.
        // 2. 같은 글자가 나오면 리스트의 첫번째 인덱스부터 비교를 한다.
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.next();
           
            int len = str.length();
            int ans = 0;
            
            // 패턴의 최대 길이가 10이기 때문에 i는 10까지로 설정
            for(int i = 1; i < 11; i++){
                // i-1까지 문자열을 잘라서 저장
            	String pattern = str.substring(0, i);
                boolean isMatch = true;
                // 뒤에 오는 문자열을 저장한 문자열 길이만큼 잘라서 비교
                for(int j = i; j+i <= len; j += i){
                    // 비교 중 pattern과 다른 문자가 들어오면 isMatch를 false로 변경 후 break;
                	if(!str.substring(j, j+i).equals(pattern)){
                    	isMatch = false;
                        break;
                    }
                }
                
                if(isMatch){
                	ans = i;
                    break;
                }
            }
           
			System.out.println("#" + test_case + " " + ans);
		}
	}
}