import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> dq = new ArrayDeque<>();
		
		// 몇개 확인?
		for(int i=0; i<n; i++) {
			// 확인할 수 
			int no = sc.nextInt();
			
			int chk = 0;
			// 2~64 진수
			for(int j=2; j<=64; j++) {
				// 나눠서 덱에 넣기
				int num = no;
				while(num > 0) {
					// System.out.print(num%j + " ");
					dq.offer(num % j);
					num = num / j;
				}
				
				//System.out.println();
				chk = 0;
				// 양쪽 비
				while(dq.size() > 1) {
					// 다른 경우
					int front = dq.pollFirst();
					int back = dq.pollLast();
					//System.out.println("진수: "+j+", front: "+front+", back: "+back);
					if(!(front == back)) {
						chk = -1; break;
					}
				}
				dq.clear();
				if(chk == 0) { chk = 1; break; }
			} 
			if(chk == 1) { System.out.println(1); }
			else if (chk == -1) { System.out.println(0); }
		} 
    }
}