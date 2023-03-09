import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// sugar를 저장할 int 배열을 만들고 -1로 채운다.
		int[] sugar = new int[N+1];
		Arrays.fill(sugar, -1);
		
		// 3번과 5번에 1을 채우고 시작한다.
		sugar[3] = 1;
		if(N>=5) {
			sugar[5] = 1;			
		}
		
		// 반복문을 돌리며 sugar 배열을 채운다.
		for(int i=3; i<=N; i++) {
			
			int a = sugar[i-3];
			int b = -1;
			if(i-5 >= 0) {
				b = sugar[i-5];				
			}
			
			if(a>0 && b>0) {
				sugar[i] = Math.min(a, b) + 1;
			} else if(a > 0) {
				sugar[i] = a + 1;
			} else if(b > 0) {
				sugar[i] = b + 1;
			}
		}
		// 결과를 출력한다.
		System.out.println(sugar[N]);
	}
}
