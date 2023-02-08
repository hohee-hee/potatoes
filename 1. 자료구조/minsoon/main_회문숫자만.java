
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class main_회문숫자만 {
	public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<Integer>(); // 덱을 선언한다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 숫자를 입력
            while (num > 0) { // 이렇게 하면 뒤집혀
                dq.add(num % 10); // 값이 입력되지만 회문이라 상관없다
                num /= 10;
            }


             for (int j = 0; j < dq.size(); j++) {
            // 양 끝의 값이 같을 떄
            if (dq.peekFirst() == dq.peekLast()) {
                System.out.println("둘의 값이 같음");
                dq.poll();
                dq.pollLast();
                if (dq.size() == 1) { // 여기서 실행 오류
                    System.out.println("1");
                }
            } else {
            	dq.poll();
            	dq.pollLast();
            	if (dq.size() == 1) { // 여기서 실행 오류
                System.out.println("0");
            }
             }
        }
             dq.clear();
    }
}
}