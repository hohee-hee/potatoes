package pratice0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1218괄호찍기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스
		for (int i = 0; i < 10; i++) {
			// ( [ { < 순서대로 값을 입력, 여기 넣어서 값을 초기화
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			Queue<String> q3 = new LinkedList<>();
			Queue<String> q4 = new LinkedList<>();
			
			int N = sc.nextInt();sc.nextLine();
			
			String ch = sc.nextLine();
			String[] arr = ch.split("");
			System.out.print("#" + (i + 1) + " ");

			// 값이 모두 들어갔다.
			// 값 찾고 그 값을 알맞는 큐에 넣기
			for (int j = 0; j < N; j++) {
				// (를 만나는 경우
				if (arr[j].equals("(")) {
					q1.add(arr[j]);
				} else if (arr[j].equals("[")) {
					q2.add(arr[j]);
				} else if (arr[j].equals("{")) {
					q3.add(arr[j]);
				} else if (arr[j].equals("<")) {
					q4.add(arr[j]);
				}
				// 각 부호를 각각의 큐에 넣어줬다.// 스택도 상관없다.
				// 다음 반대 부호를 만나면 q값의 값을 빼준다.
				 else if (arr[j].equals(")")) {
					 if(q1.isEmpty()) {
						 System.out.println(0);
						 break;

					 }
					 else  q1.poll();
				} else if (arr[j].equals("]")) {
					if(q2.isEmpty()) {
						 System.out.println(0);
						 break;

					 }
					q2.poll();
				} else if (arr[j].equals("}")) {
					if(q3.isEmpty()) {
						 System.out.println(0);
						 break;

					 }
					q3.poll();
				} else if (arr[j].equals(">")) {
					if(q4.isEmpty()) {
						 System.out.println(0);
						 break;
					 }
					q4.poll();
				}

			}
			// 모든 큐 값이 비어있으면 1을 반환 그렇지 않으면 0을 반환
			if (q1.isEmpty() == true && q2.isEmpty() == true && q3.isEmpty() == true && q4.isEmpty() == true) {
				System.out.println(1);}
			
			}

		}

	}