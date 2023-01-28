package programmers100;

public class Q_120876 {
	// 겹치는 선분의 길이 (틀림)..
	class Solution {
	    public int solution(int[][] lines) {
	        int answer = 0;
			int[] line = new int[201];
			
			int cnt=0; int lncnt = 0;
			for(int i=0; i<3; i++) {
				boolean isFirst = true;
				for(int j=lines[i][0]; j<=lines[i][1]; j++) {
					if(j==lines[i][0] && line[lines[i][0]+100] > 0 && isFirst == true) {
						cnt++;
						isFirst = false;
					}
					line[100 + j]++;
				}
			}
			
			for(int i=0; i<line.length; i++) {
				if(line[i] > 1) {
					lncnt++;
				}
			}
			answer = lncnt-cnt;
	        return answer;
	    }
	}
}
