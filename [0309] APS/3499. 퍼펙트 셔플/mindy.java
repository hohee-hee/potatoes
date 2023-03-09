import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt(); 
		
		for(int t=1; t<=tests; t++) {
			String ans = "";
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			float num = sc.nextInt();
			for(int i=0; i<num/2; i++) q1.offer(sc.next());
			for(int i=0; i<(int)num/2; i++)  q2.offer(sc.next());
			
			// 합치기
			int loc = 1;
			for(int i=0; i<num; i++) { 
				if(loc == 1) { ans += q1.poll()+" "; loc = 2; }
				else { ans += q2.poll()+" "; loc = 1; }
			}
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
