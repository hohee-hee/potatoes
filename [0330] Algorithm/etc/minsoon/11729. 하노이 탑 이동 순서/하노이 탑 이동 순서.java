import java.util.Scanner;

public class Main {
	
	static int N;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		sb.append(((int)Math.pow(2, N) -1)).append("\n");
		hanoi(N,1,2,3);
		System.out.println(sb);
		
	}
	
	static void hanoi(int N, int start, int mid, int end) {
		// 1개가 남으면 끝 점으로 보내준다.
		if(1 == N) {
			sb.append(start + " " + end).append("\n");
			return;
		}
		// n-1 개를 가운데에 옮긴다.
		hanoi(N-1, start, end, mid);
		// 큰 덩이 하나를 끝으로 옮긴다.
		sb.append(start + " " + end).append("\n");
		//다시 b->c로 이동을 한다.
		hanoi(N-1,  mid, start, end);
		
		
		
	}

}