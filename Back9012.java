package main;

import java.util.Scanner;
import java.util.Stack;
public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 몇번 돌릴지 값을 입력받는다.
		Stack<Character> stack = new Stack();
		String s = sc.nextLine(); // 괄호 친구들 입장
		
		for (int i = 0; i < T; i++) {
			s = sc.nextLine(); 
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j); // char 형태로 값을 확인
				if(stack.isEmpty()) stack.push(c);
				else {
					if(c == ')') { // 왼쪽인 경우
						if(stack.peek() == '(') { 
							stack.pop();
						}
						else { // 
							stack.push(c);
						}
					}else { // (s.charAt(j) == '(')
						stack.push(c);
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			stack.clear();
		
		}
	}
}
