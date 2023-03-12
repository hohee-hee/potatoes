import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Set<Integer> s = new HashSet<>();
		int i = 10;
		while(i-- > 0) s.add(sc.nextInt()%42);
		
		System.out.println(s.size());
	}
}