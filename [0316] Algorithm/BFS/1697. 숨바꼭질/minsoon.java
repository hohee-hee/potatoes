import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 최단거리를 찾기위해 bfs 를 사용해야한다.

		int[] arr = new int[100001];
		// 수빈이는 점 N
		// 동생은 점 k
		// 걸으면 +- 1 씩 이동, 순간이동은 본인의 두배만큼
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(N ==K) {
			System.out.println(0);
			return;
		}

		// 경우를 +1, -1, *2 의 경우를 찾아준다.
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(N);
		//
		arr[N] = 1;

		// 각 값을 넣어준다.
		while (!q.isEmpty()) {
			int now = q.poll();
			// 델타 탐색과 같이 각 경우를 넣어준다.
			for (int i = 0; i < 3; i++) {

				// 다음값을 저장해준다.
				// 더한 뒤에 곱을 하는게 더 최적이다.
				int next;
				if (i == 0) {
					next = now + 1;
				} else if (i == 1) {
					next = now - 1;
				} else {
					next = now * 2;
				}
				// 1부터 시작햇음으로 다음 위치에 k 가 되면 정지
				if (next == K) {
					System.out.println(arr[now]);
					return;
				}
				if (next >= 0 && next < arr.length && arr[next] == 0) {
					q.add(next);
					// 이동할때마다 카운트를 해준다.
					arr[next] = arr[now] + 1;
				}

			}

		}

	}

}