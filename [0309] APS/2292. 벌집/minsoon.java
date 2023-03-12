package day0303;

import java.util.Scanner;

public class Main_2292벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int cnt =1;
		int range = 2;
		
		if(N ==1) {
			System.out.println(1);
		}
		else {
			//1(1) / 2~7(6) / 8~19(12) / 20~37(18)
			while(range <= N) {
				range =  range + (6*cnt);
				cnt++;
			}
			System.out.println(cnt);
		}

		

	}

}