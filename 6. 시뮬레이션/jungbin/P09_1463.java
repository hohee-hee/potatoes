int[] d = new int[n+1];
d [1]=0;

//안녕 두희...d[i]랑 d[i-1]의 관계 식을 모르겠네...

while(d[i]>=1) {
//먼저 3으로 나누기
if(i % 3 == 0) {
	if(d[i==1]) {
		cnt++
		break;
	} else cnt++;
	
	//그 다음 2로 누눠지는 지 확인
} else if(i % 2 == 0){
    if(d[i]==1) {
    	cnt++;
    	break;
    } else cnt++;
  //없으면 1을 빼고 
} else if(d[i]!=1) {
		d[i]-1;
		cnt++;
		break;
}
}

//의 반복
//1이 될 때 cnt++



package potato;

import java.util.Scanner;

public class P09_1463 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];

        dp[1] = 0;

       
        System.out.print(dp[N]);
    }
}

