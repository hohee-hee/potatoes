import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for(int t=1; t<=tests; t++) {
			String ans = "#"+t+" "; 
			int N = sc.nextInt(); // 선택받은 자들
			int M = sc.nextInt(), K = sc.nextInt(); // M초 -> 붕빵 K개
			
			int[] arv = new int[N];
			for(int i=0; i<N; i++) arv[i] = sc.nextInt();// 도착시간
			Arrays.sort(arv);
			
			Queue<String> q = new LinkedList<>();
			int time = 0;
			int cus = 0;
			if(arv[0] == 0 && M != 0) { ans += "Impossible"; time = arv[N-1]+1000; }
			OuterLoop : 
			while(time++ <= arv[N-1]) {
//				System.out.println("time: "+time);
				if(time % M == 0) {
					for(int i=0; i<K; i++) { q.offer("붕빵 한마리"); }
				}
				if(arv[cus] <= time) {
					while(arv[cus] <= time) {
//						System.out.println("손님 "+cus);
						if(q.isEmpty()) { ans += "Impossible"; break OuterLoop; }
						else q.poll();
						if(cus < N-1) cus++;
						else break;
					}
				}
			}
			if(!ans.contains("Im")) ans += "Possible";
			System.out.println(ans);
		}
	}
}
