package day0206;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Test_12789 {
	public static void main(String[] args) throws EmptyStackException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<>();

		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			try {
				if(a==i+1) {//순서와 번호표가 같으면 계속
					continue;
				}else {//다르면 스택에서 확인
					if(st.peek()==a) {
						st.pop();
					}else {
						st.push(a);
					}
				}
			} catch(Exception e) {
				continue;
			}
			
		}
		if(st.isEmpty()) {
			System.out.println("Nice");
		}else {
			System.out.println("Sad");
		}
		sc.close();
	}

}
