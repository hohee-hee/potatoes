import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][2]; // 합, 출발지
		for(int i=1; i<=N; i++) arr[i][0] = 1000000;
		
		int now = 0;
		arr[1][0] = 0;
		while(++now < N) {
			if(now*3 <= N && arr[now*3][0] > arr[now][0]+1) {
				arr[now*3][0] = arr[now][0]+1; 
				arr[now*3][1] = now;
			}
			if(now*2 <= N && arr[now*2][0] > arr[now][0]+1) {
				arr[now*2][0] = arr[now][0]+1; 
				arr[now*2][1] = now;
			}
			if(now+1 <= N && arr[now+1][0] > arr[now][0]+1) {
				arr[now+1][0] = arr[now][0]+1; 
				arr[now+1][1] = now;
			}
		}
		
		System.out.print(arr[N][0] +"\n"+ N);
		while(N != 1) {
			System.out.print(" "+arr[N][1]); 
			N = arr[N][1];
		} 
		System.out.println();
	}
}