package programmers100;

public class Q_120921 {
	// 문자열 밀기
	class Solution {
	    public int solution(String A, String B) {
	        int answer = 0;
	        if(A.equals(B)) return answer;
			char[] Alist = A.toCharArray();
			char[] Blist = B.toCharArray();
			
			for(int i=0; i<A.length();i++) {
				int count=0;
				if(Alist[0] == Blist[i]) {
					for(int j=0; j<A.length(); j++) {
						if(Alist[j] == Blist[(i+j)%A.length()]) {
							count++;
						}
					}
					if (count==A.length()) {
						return i;
				}
				}
			}
			if(answer == 0)	answer = -1;
	        return answer;
	    }
	}
	
}
