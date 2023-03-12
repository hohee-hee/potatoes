package day0303;

import java.util.Scanner;

public class Main_2851슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 10개의 버섯이 일렬
		// 버섯을 순서대로 먹는다. 끊기면 안됨
		// 최대한 먹어야됨
		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();

		}

		// 처음부터 값을 구한다.
		// 누적합을 구하는데 100이 넘으면 멈춘다.
		
		// 하지만 백을 넘지 않는 경우???
		
		// 100보다 하나 적었을 때랑 해서 두가지 경우를 본다.
		int sum = 0;
		int i = 0;
		int cnt = 0;

		while (sum < 100) {
			sum += arr[i++];
			cnt++;
			// 100미만의 경우를 고려해준다.
			if(cnt == 10) {
				break;
			}
		}
		if (sum == 100) {
			System.out.println(sum);
		} else {
			int a = sum - arr[i - 1];
			int b = sum;
			if (100 - a < b - 100) {
				System.out.println(sum - arr[i - 1]);
			} else {
				System.out.println(sum);

			}

		}
	}
}