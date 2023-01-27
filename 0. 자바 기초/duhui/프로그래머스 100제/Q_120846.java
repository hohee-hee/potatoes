package programmers100;

public class Q_120846 {
	// 합성수 찾기
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        boolean[] Prime = new boolean[101];
	        Prime[0] = Prime[1] = true;
	        for(int i=2; i<Math.sqrt(100); i++){
	            if(Prime[i] == true) continue;
	            for(int j=i*2; j<101; j+=i){
	                Prime[j] = true;
	            }
	        }
	        for(int i=2; i<=n; i++){
	            if(Prime[i]) answer++;
	        }
	        return answer;
	    }
	}
}
