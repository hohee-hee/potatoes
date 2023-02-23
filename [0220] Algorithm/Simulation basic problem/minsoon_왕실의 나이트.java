package main;

import java.util.Scanner;

public class HO_왕실 {
	public static void main(String[] args) {
		// 채스판 만들기
		int[][] map = new int[8][8];

		// 값을 받아오기
		Scanner sc = new Scanner(System.in);
		String horse = sc.nextLine();
		char[] horse2 = horse.toCharArray();
		char[] alpa = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		// 이동횟수 탐지기
		int cnt = 0;
		int[] dr = { 2, 2, -2, -2, -1, 1, 1, -1 };
		int[] dc = { 1, -1, 1, -1, 2, 2, -2, -2 };

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				// 위치를 저정하면
				if (alpa[j] == horse2[0]) {
					//row값이 char 타입으로 나와서 바꿔줌
					// 0을 빼주면 우리가 알던 값이 나온다.
					int num = horse2[1] - '0' -1;
					int nr = j + dr[i];
					int nc = num + dc[i];
					// 경계조건.1 안쪽에 값이 있다면
					if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
						cnt++;
					}

				}

			}
		}
		System.out.println(cnt);

	}

}
