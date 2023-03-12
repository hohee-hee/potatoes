package main;

import java.util.Scanner;

public class Main_3052나머지 {
	public static void main(String[] args) {
		//a와 b가 있으 ㄹ때
		//10개의 수를 입력받고 42로 나눈 나머지를 구한다.
		//서로 다른 값이 몇개 인지 출력한다.
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		
		
		for(int i = 0; i< 10; i++) {
		int num = sc.nextInt();
		int num42 = num%42;
		arr[num42]++;
		
		}
		int cnt =0;
		for(int i = 0; i<42; i++) {
			if(arr[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}

}