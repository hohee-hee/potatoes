
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_회문인수 {
	public static void main(String[] args) {
        Deque<Charset> dq = new ArrayDeque<Charset>(); // 덱을 선언한다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 숫자를 입력
            for(int j=0; j < Math.log10(num); j++) {
              
            char ch = Integer.toString(num).charAt(j);
            dq.add(ch);
            System.out.println(ch);
 
            }
        }


             for (int j = 0; j < dq.size(); j++) {
            // 양 끝의 값이 같을 떄
            if (dq.peekFirst() == dq.peekLast()) {
                System.out.println("둘의 값이 같음");
                dq.poll();
                dq.pollLast();
                if (dq.size() <= 1) { // 여기서 실행 오류
                    System.out.println("1");
                }
            } else {
            	dq.poll();
            	dq.pollLast();
            	if (dq.size() <= 1) { // 여기서 실행 오류
                System.out.println("0");
            }
             }
        }
             dq.clear();
    }
}
