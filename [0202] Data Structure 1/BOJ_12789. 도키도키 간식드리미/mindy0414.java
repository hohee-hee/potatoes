import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int leng = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		int[] list = new int[leng];
		
		for(int i=0; i<leng; i++) {
			list[i] = sc.nextInt();
		}
		
		// 순서에 안맞으면 스텍으로
		int now = 1;
		for(int i=0; i<leng; i++) {
			// 원래 줄 x
			if(list[i] != now) {
				// 스텍 o
				if(!(stack.isEmpty()) && (stack.peek() == now)) {
					// System.out.println(now);
					now++; i--;
					stack.pop();
				} else { // 원래 줄이랑 스텍 둘다 앙댐
					stack.push(list[i]);
				}
			} else {
				// System.out.println(now);
				now++;
			}
		}
		
		// 스텍 확인
		int sSize = stack.size();
		for(int i=0; i<sSize; i++) {
			if(stack.peek() == now) {
				// System.out.println(now);
				now++;
				stack.pop();
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
	}
}