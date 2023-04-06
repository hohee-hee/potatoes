import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		Deque<Integer> q = new ArrayDeque();

		for (int i = 0; i < T; i++) {

			int num = sc.nextInt();

			int check = 0;
			// 각 진수
			for (int j = 2; j <= 64; j++) {
				int num2 = num;
				while (num2 > 0) {
					q.offer(num2 % j);
					num2 = num2 / j;
				}
				check = 0;
				while (q.size() > 1) {
					int front = q.pollFirst();
					int back = q.pollLast();
					if (!(front == back)) {
						check = -1;
						break;
					}
				}
				q.clear();
				if (check == 0) {
					check = 1;
					break;
				}
			}
			if (check == 1)
				System.out.println(1);
			else if (check == -1)
				System.out.println(0);
		}

	}

}