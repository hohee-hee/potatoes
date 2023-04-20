import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int[] p; // 대표를 저장할 배열

//	static String input = "7 11\r\n" + 
//			"0 1 32\r\n" + 
//			"0 2 31\r\n" + 
//			"0 5 60\r\n" + 
//			"0 6 51\r\n" + 
//			"1 2 21\r\n" + 
//			"2 4 46\r\n" + 
//			"2 6 25\r\n" + 
//			"3 4 34\r\n" + 
//			"3 5 18\r\n" + 
//			"4 5 40\r\n" + 
//			"4 6 51\r\n" + 
//			"\r\n";

	public static void main(String[] args) {
		// Scanner sc= new Scanner(input);
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수 0개부터 시작한다
		int E = sc.nextInt(); // 간선의 수

		// 간선을 저장하기 위해 클래스를 사용할 수도있자만
		// 배열을 이용해서 저장을 하겠다. 0 : 시작정점 / 1: 끝 정점 / 2: 가중치
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
			edges[i][2] = sc.nextInt();

		} // 입력끝

		// 크루스칼 1단계 : 간선을 정렬한다.(오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		// 간선이 잘 정리 되었다.
//		for (int[] arr : edges) {
//			System.out.println(Arrays.toString(arr));
//		}

		// 크루스칼 2단계 : V-1개의 간선을 뽑는데 사이클이 발생하지 안는 친구들로 뽑는다.
		p = new int[V];
		// make - set : 나 자신을 대표로 초기화를 하자
		for (int i = 0; i < V; i++) {
			//makeset(i);
			 p[i] = i;
			 //p[findset(i)] = 0;

		} // makeset 다햇다.

		int ans = 0; // 최소비용을 저장할 친구
		int pick = 0; // 내가 뽑은 간선의 수
		
		// while() for()응 사용 가능
		// 모든 간선을 순회하면서 체크한다.
		for (int i = 0; i < E; i++) {
			// i번쨰의 간선을 뽑아 두 정점의 대표를 확인하겠다.
			int x = edges[i][0];
			int y = edges[i][1];

			// 이건 무슨 의미?? : 각 대표가 다르다면 사이클이 아니면 고로
			// 고를 수 있다 즉 유니온 해야한다
			if (findset(x) != findset(y)) {
				union(x, y);
				ans += edges[i][2];
				pick++;
			}
			// 뽑은게 간선의 최소 갯수랑 같아진다면 멈춰
			if (pick == (V - 1)) break;
		}
		System.out.println(ans);

	}

	// 대표를 반환해야한다
	static int findset(int x) {
		// 순수기술
//		if(x == p[x]) return x;
//		return findset(p[x]);
		// 패쓰 컴프레션 적용버전
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];

	}

	// 유니온 간선 연결
	static void union(int x, int y) {
		p[findset(y)] = findset(x); //rank 이런거 고려 안했고 그냥 y를 무조건 x밑으로

		// rank고려하지 않고 y를 무조건 x 아래로
//		if (p[findset(x)] > p[findset(y)]) {
//			p[findset(y)] = findset(x);
//		} else {
//			p[findset(x)] = findset(y);
//			if (p[findset(x)] == p[findset(y)]) {
//				p[findset(y)]++;
//			}
//		}
	}

	static void makeset(int x) {
		p[x] = x;
		p[findset(x)] = 0;
		// Rank는 따로 하지 않겠습니당
	}

}