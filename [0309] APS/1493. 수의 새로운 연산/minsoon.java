package main;

import java.util.Scanner;

public class Solution_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 처음 시작되는 값들을 모두 모아서 그 다음값을 유추
		int[] arr = new int[501];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 1; i < 501; i++) {
			arr[i] = arr[i - 1] + i;
		}
		// 여기서 생긴 수로 몇번째 줄인지 유추한다.

		// 테케
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int num = 0;
			int num1 = 0;

			// 유사 값을 찾아 몇 번째 줄인지 알아낸다.
			for (int i = 0; i < 501; i++) {
				if (arr[i] >= a) {
					// 몇번째 줄인지 알아냈다.
					// 줄의 좌표는 줄 길이 +1 값이다.
					num = i + 1;
					break;
				}
			}

			// 좌표의 합을 안다.
			int x = arr[num - 1] - a;
			int xx = num - 1 - x;
			int y = num - xx;

			// 유사 값을 찾아 몇 번째 줄인지 알아낸다.
			for (int i = 0; i < 501; i++) {
				if (arr[i] >= b) {
					// 몇번째 줄인지 알아냈다.
					// 줄의 좌표는 줄 길이 +1 값이다.
					num1 = i + 1;
					break;
				}
			}

			// 좌표의 합을 안다.
			int x1 = arr[num1 - 1] - b;
			int xx1 = num1 - 1 - x1;
			int y1 = num1 - xx1;

			// 각 좌표의 합을 구한다.
			int new_x = xx + xx1;
			int new_y = y + y1;
			
			
			//각 좌표로 어디에 있는지 알아야됨.
			// 몇번째 줄에 있는지 알아았다.
			int new_sum = new_x + new_y -1;
			// 그 줄의 제일 큰 수 까지 구했다.
			// 줄 갯수가 있다.
			// x 좌표에서 1을 빼     이걸 큰수에서 빼준다. =줄 -(x-1)
			System.out.print("#" + (tc+1) + " ");
			System.out.println(arr[new_sum] - (new_sum -1 - (new_x-1)) );
			

		}
	}

}