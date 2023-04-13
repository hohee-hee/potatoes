import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수열의 크기 n 반복
		int n = sc.nextInt();
		//수열
		int[] arr = new int[n];
		//0존재 여부
		boolean zero = false;
		//음수값 수
		int cnt_m =0;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i]==0) zero=true;
			if(arr[i]<0) cnt_m++;
		}
		
		//오름차순
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int sum=0;
		//0존재, 음수값 1개 경우 서로 묶어주고 시작
		if(zero && cnt_m==1) arr[0]=0;
		//음수값이 2이상일 경우 묶어주고 시작**
		else if(cnt_m>1) {
			for(int i=0; i<cnt_m-1; i++) {

				arr[i]=arr[i]*arr[i+1];

				arr[i+1]=0;
				i++;
			}
			if(cnt_m<n && arr[cnt_m]==0 && cnt_m%2 !=0) arr[cnt_m-1]=0; 
		}
		
		//뒤에서 시작해 묶으면서 2까지 도달하고  나머지는 그냥 더하기**
		for(int i=n-1; i>=0; i--) {
			if(i-1>=cnt_m && arr[i-1]>=2) {
				sum+=arr[i]*arr[i-1];
				i--;
			}else sum+=arr[i];

		}
		System.out.println(sum);
		sc.close();
	}

}
