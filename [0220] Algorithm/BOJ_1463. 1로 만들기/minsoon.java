package main;

import java.util.Scanner;

public class Main_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//n이 3의 배수
		// 2의 배수
		// 1을 뺀경우 // 해서 1을 만든다.
		int cnt = 0;
		
		while(N > 1) {
			// 3보다 크면서 3인경우는 
		if(N>3 && N%3 ==0) {
			N = N/3;
			cnt++;
		}
		// 2의 배수인경우
		if(N>2 && N%2 == 0) {
			N = N/2;
			cnt++;
		}
		//2인경우
		if(N==2) {
			cnt++;
		}
		//3인경우
		if(N==3) {
			cnt = cnt+2;
		}
			}
		System.out.println(cnt);
		
	
	}
	}
