import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 갯수
		E = sc.nextInt(); // 간선의 갯수

		// 진입차수를 저장해야하는 배열
		int[] in_degree = new int[N + 1];
		List<List<Integer>> arr = new ArrayList<List<Integer>>();

		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}

		// 간선들을 입력받는다.
		int[] v1 = new int[E];
		int[] v2 = new int[E];

		for (int i = 0; i < E; i++) {
			v1[i] = sc.nextInt();
			v2[i] = sc.nextInt();

			arr.get(v1[i]).add(v2[i]);
			in_degree[v2[i]]++;
		}
		topologicalSort(in_degree, arr);

	}

	static void topologicalSort(int[] in_degree, List<List<Integer>> arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();

		// 큐 값에 0인 값을 넣는다.
		for (int i = 1; i < N + 1; i++) {
			if (in_degree[i] == 0) {
				q.offer(i);
			}
		}
		// 큐에서 값을 꺼내면서 노드를 하나씩 감서ㅗ
		// 0이되면 큐에 넣기
		while (!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);

			for (Integer i : arr.get(node)) {
				in_degree[i]--;

				if (in_degree[i] == 0) {
					q.offer(i);
				}
			}

		}
		for(int i =0; i<N; i++) {
		System.out.print(result.remove()+" ");	
		}
		

	}
}