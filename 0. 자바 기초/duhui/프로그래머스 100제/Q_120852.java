package programmers100;

public class Q_120852 {
	// 소인수분해
	class Solution {
	    public int[] solution(int n) {
	        int m = n;
			boolean[] Prime = new boolean[10001];
			Prime[0] = Prime[1] = true;
			
			for(int i=0; i<=Math.sqrt(10000); i++) {
				if(Prime[i] == true) continue;
				
				for(int j=i*2; j<=10000; j+=i) {
					Prime[j] = true;
				}
			}
			int[] numlist = new int[n+1];
			while(n != 1) {
				for(int i=2; i<=n; i++) {
					if(Prime[i] == false && n%i == 0) {
						numlist[i] += 1;
						n=n/i;
					}
				}
			}
			
			int idx=0;
			for(int i=0; i<=m; i++) {
				if(numlist[i] != 0) {
					idx++;
				}
			}

			int[] answer = new int[idx];
			for(int i=0, j=0; i<=m; i++) {
				if(numlist[i] != 0) {
					answer[j++] = i;
				}
			}
			return answer;
	    }
	}
}
