import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int K = sc.nextInt();
		Queue<int[]> q = new ArrayDeque<>();
		HashSet<Integer> hs = new HashSet<>();
		
		int[] tmp = { N, 0 }; // 현위치, cnt
		q.offer(tmp);
		
		while(!q.isEmpty()) {
			int now = q.peek()[0];
			int cnt = q.poll()[1];
			if(now == K) { System.out.println(cnt); return; }
			hs.add(now);
			
			if(!hs.contains(now-1) && now-1 >= 0) { 
				int[] ttmp = new int[2];
				ttmp[0] = now-1; ttmp[1] = cnt+1; 
				q.offer(ttmp); 
			}
			if(!hs.contains(now+1) && now+1 <= 100000) { 
				int[] ttmp = new int[2];
				ttmp[0] = now+1; ttmp[1] = cnt+1; 
				q.offer(ttmp); 
			}
			if(!hs.contains(now*2) && now*2 <= 100000) {
				int[] ttmp = new int[2];
				ttmp[0] = now*2; ttmp[1] = cnt+1; 
				q.offer(ttmp);
			}
		}
		
	}
}