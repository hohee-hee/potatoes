package potato;
//이건 왜 맞음????
import java.util.Scanner;

public class P15651 {
	//n과 m (3)
	//1부터 n까지의 n개 중
	//m개를 뽑는데 중복이 있어도 괜찮앙
	//사전순 증가
	
	private static int n;
	private static int m;
	private static int[] arr;
	private static boolean[] check;
	private static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for(int k=0; k<n; k++) {
			arr[k] = k+1;
		}
		check = new boolean[n];
		ans = new int[m];
		
		backTracking(0);
	}
	
	private static void backTracking(int i) {
		if(i==m) {
			for(int j=0; j<m; j++) {
				System.out.print(ans[j]+" ");
			}
			System.out.println();
			return;
		}
		//어케 순서가 넘어가지??? 께속 1만 나와야 하는거 아니닝>???
		for(int j=0; j<n; j++) {
				ans[i]=arr[j];
				backTracking(i+1);
		}
		
	}
	

}
