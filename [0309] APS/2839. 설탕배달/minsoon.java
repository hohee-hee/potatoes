package day0303;

import java.util.Scanner;

public class Main_2839설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int N = sc.nextInt();
		int cnt =0;
		// 봉지는 3과 5만큼 배달해야한다.
		// 최소의 봉지 수는
		while(true) {
			// 5로 나눠지는 경우 바로 출력
			if(N%5 == 0) {
				cnt += N/5;
				System.out.println(cnt);
				break;
				// 그렇지 않음 3씩 빼면서 0이 되면 들어가서 출력
			}else {
				N -=3;
				cnt++;
			}
			// 음수가 되면 나눠지지 않음으로 -1 출력
			if(N<0) {
				System.out.println(-1);
				break;
			}
		}
		

	}

}