import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int ans = -1;
		out:
		for(int _3=0; _3<=a/3; _3++) {
			for(int _5=0; 5*_5 + 3*_3 <= a; _5++) {
				if(_5*5 + _3*3 == a) { ans = _3+_5; break out; }
			}
		}
		System.out.println(ans);
	}
}