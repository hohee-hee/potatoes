import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int score = 0;
		int tmp = 0;
		while(sc.hasNext() && score <= 100) { tmp = sc.nextInt(); score += tmp; }

		if((score-100) > (100-(score-tmp))) score -= tmp;

		System.out.println(score);
	}
}