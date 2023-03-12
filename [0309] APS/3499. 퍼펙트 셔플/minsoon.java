package pratice0222;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_3499퍼펙트셔플 {
	public static void main(String[] args) {
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
	// 교대로 카드를 뽑아 새로운 덱을 만듬
	// 절반으로 나누고 나눈 값이 들어가게 되는데
	// 홀수인 경우 먼저 놓는 쪽에 한장이 더 들어간다.
	Scanner sc = new Scanner(System.in);
	//테케 입력
	int T = sc.nextInt();
	for(int i = 0; i< T; i++) {
		// 카드의 갯수를 받아온다.
		int N = sc.nextInt(); 
		//먼저 N이 짝수인 경우
		if(N%2 ==0) {
			for(int j = 0; j<N/2; j++) {
			q1.add(sc.next());
			}
			for(int j = 0; j<N/2; j++) {
				q2.add(sc.next());
			}
		}
		else { // 홀수인 경우
			for(int j = 0; j<N/2+1; j++) {
				q1.add(sc.next());
			}
			for(int j = 0; j<N/2; j++) {
				q2.add(sc.next());
			}
		}
	// 각각 반을 나눠서 값을 가져왔다.
	// 값이 잘 들어감을 확인.
		
		
	String[] arr = new String[N];
	// 둘다 비어있으면 나가기
	int cnt = 0;
	// 둘다 비어있지 않으면 와일문이 돌아간다.
	// 둘중 하나라도 비지 않으면 값이 들어가지 않음
	while(q1.isEmpty() == false || q2.isEmpty() == false) {
		//비어 있지 않으면 각 값이 들어간다.
		if(q1.isEmpty() == false) {
		arr[cnt++] = q1.poll();
		}
		if(q2.isEmpty() == false) {
		arr[cnt++] = q2.remove();
			}
		}
	System.out.print("#" + (i+1) + " ");
	for(int k = 0; k< N; k++) {
		System.out.print(arr[k]+ " ");
	}
	System.out.println();
	}
	

	}
}