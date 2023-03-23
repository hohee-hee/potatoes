import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 가장 긴 값 두개랑
		// 12, 43 총 합해서 가장 큰 값을 구하고
		// 반대로 이중 가장 작은 값들을 구하고
		// 곱하고 빼준다.
		// 가장 짝은 값 두개를 빼고 값을 구해준다.
		// 어짜피 큰 값이 나온 값에서 +3뒤에 값에 각 작은 값들이나온다.

		// 한 구역당 참외
		int K = sc.nextInt();

		// 거리
		int[] dist = new int[6];
		// 최대값
		int max12 = 0;
		// 인덱스 포함
		int max12idx = 0;

		int max34 = 0;
		int max34idx = 0;

		for (int i = 0; i < 6; i++) {
			int n = sc.nextInt();
			dist[i] = sc.nextInt();
			if (n == 1 || n == 2) {
				if (max12 <= dist[i]) {
					max12 = dist[i];
				   max12idx = i;
				}
			} else {
				if (max34 <= dist[i]) {
					max34 = dist[i];
				    max34idx = i;
				}
			}
		}

		int big = max34 * max12;
		//System.out.println(big);
		int small = dist[(max12idx + 3) % 6] * dist[(max34idx + 3) % 6];
		//System.out.println(small);
		System.out.println((big - small) * K);

	}

}