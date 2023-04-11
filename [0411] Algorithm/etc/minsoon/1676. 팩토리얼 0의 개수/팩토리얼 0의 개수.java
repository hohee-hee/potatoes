import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int num = sc.nextInt();
		int count = 0;
		 // 2랑 5가 들어오는 경우 숫자가 들어오고
		// 2랑 5의 짝의 갯수만 카운트 해주면된다.
		
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);
		
	}

}