import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=1; t<=tests; t++) {
			long[] arr = new long[sc.nextInt()]; // 주가 
			for(int i=0; i<arr.length; i++) arr[i] = sc.nextInt();
			
			Queue<Long> q = new ArrayDeque<>();
			int st = 0;
			while(st < arr.length) {
				long max = 0, idx = -1;
				for(int i=st; i<arr.length; i++) {
					if(arr[i] >= max) {
						max = arr[i];
						idx = i;
					}
				}
				q.add(idx);
				st = (int)idx+1;
			}
			
			long sum = 0;
			int now = 0;
			while(!q.isEmpty()) {
				long idx = q.poll();
				int cnt = 0;
				for(int i=now; i<idx; i++) { // 사
					cnt++;
					sum -= arr[i];
				}
				sum += cnt * arr[(int)idx];// 팔아
				now = (int)(idx+1);
			}
			System.out.println(sum);
		}
	}
}
