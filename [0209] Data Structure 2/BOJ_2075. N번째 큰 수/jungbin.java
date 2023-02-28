package day0208;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Test_2075 {
	public static void main(String[] args) {
		//우선순위 큐 정수형일 때 기본적으로 오름차순 정렬
		PriorityQueue<Integer> h = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//n*n개 받으면서 
		for(int i=0; i<n*n; i++) {
			int k = sc.nextInt();
			//크기 확인하면서 크기 초과하면 가장 작은 수 버린다.
			if(h.size()<n) {
				h.add(k);
			} else {
				if(k>h.peek()) {
					h.poll();
					h.add(k);
				}
			}
		}
		//가장 앞에 있는 수 출력
		System.out.println(h.poll());
	}

}
