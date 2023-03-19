import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1w 2l 3w 4 5 6
		// 홀수는 sk
		// 짝수는 cy
		int N = sc.nextInt();

		if (N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}

	}

}