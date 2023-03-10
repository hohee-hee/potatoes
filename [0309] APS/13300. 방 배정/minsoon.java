package main;

import java.util.Scanner;

public class Main_13300방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수학여행에 참여하는 학생수
		int N = sc.nextInt();

		// 한방배정 최대 인우너수
		int K = sc.nextInt();

		int arr[] = new int[13];
		for (int i = 0; i < N; i++) {
			// t성별
			int S = sc.nextInt();
			// 학년
			int Y = sc.nextInt();

			// 남자 여자를 생각하면 총 12반이 있다고 가정을 하고
			// 그 값을 들어갈 수 있는 명수로 나눠서 계산한다.
			// 남자의 반은 곱하기 6을 해준다.
			if (S == 0) {
				arr[Y]++;
			} else {// 1인경우
				arr[6 + Y]++;
			}
		}
		// 명수로 나눈 합을 구해준다.
		int sum = 0;
		for (int i = 1; i < 13; i++) {
			// 3가지 경우가 있다. 0인 경우, k보다 작은 경우, 그렇지 않은 경우
			// 0은 카운트 하지 않고 0보다 작음 1을 더해준다.
			if (arr[i] == 0) {
				sum = sum;
			}
			else if (arr[i] > 0 && arr[i] <= K) {
				sum++;
			}

			else {
				// 그렇지 않은 경우 나눈 값에 1을 더한다
				sum += (arr[i] / K) + 1;
			}

		}
		System.out.println(sum);

	}

}