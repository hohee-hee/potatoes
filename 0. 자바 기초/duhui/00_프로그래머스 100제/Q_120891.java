package programmers100;

public class Q_120891 {
	// 369 게임
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
    		    String orders = Integer.toString(order);
   			     for(int i=0; i<orders.length(); i++){
     			       if(orders.charAt(i) == '3'
        			       || orders.charAt(i) == '6'
       			       || orders.charAt(i) == '9') {
	        		        answer++;
    			        }
  		      }
        return answer;
	    }
	}
}
