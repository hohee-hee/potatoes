import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//test case 반복
		int t=sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			
			//날의 수 n 반복
			int n = sc.nextInt();
			//가격 배열
			long[] price = new long[n];

			for(int i=0; i<n; i++) {
				price[i]=sc.nextInt();
			}
			
			
			//이익
			long sum=0;
			//뒤에서 가장 큰 값
			long max_p=0;
			//뒤에서 부터 비교하면서 판매 가능할 경우 팔기
			for(int i=n-1; i>=0; i--) {
				if(max_p<price[i]) max_p=price[i];
				if(max_p>price[i]) sum += max_p-price[i];
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		sc.close();
	}

}
