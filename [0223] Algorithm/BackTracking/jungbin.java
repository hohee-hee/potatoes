package potato;

import java.util.Arrays;

public class BackTracking {
	//{3, 7, 8, 9, 11} 중
	//중복되지 않는 3개 요소 조합 구하기
	//배열의 크기 n=5
	//고를 수의 크기 m=3
	//m=3번의 깊이를 반복
	//사용했던 원소면 check 
	//이미 check된 원소이면 false 중지
	//다른 원소를 탐색
	//깊이가 3에 도달하면 출력이라는 건데....
	//왜 못하겟지...
	
	//클래스에서 사용할 변수들
	private static int[] arr = {3, 7, 8, 9, 11};
	private static int n =5;
	private static int m =3;
	private static boolean[] check = new boolean[n];
	private static int[] ans = new int[m];
	
	//실행할 메인 메소드
	public static void main(String[] args) {
		backTracking(0);
		
	}
	
	//백트레킹을 정의하라는 건뎅..
	//m=3까지 도달하라는 건뎅...인덱스를 받나..뭘받아?
	//주어진 배열 arr의 인덱스를 받는게 맞는 거 같은데
	private static void backTracking(int i) {
		//끝 조건을 먼저 제시하기
		//m에 도달하면 종료
		if(i==m) {
			//찾은 배열을 출력
			System.out.println(Arrays.toString(ans));
			//종료? 
			return;
		}
		
		//조합 찾기
		for(int j=0; j<n; j++) {
			if(!check[j]) {
				//사용 안 한 원소
				ans[i] = arr[j];
				//표시하기
				check[j] = true;
				//여기서 반복한다는 건데... 이거 위에서 조건 m에 도달하면 바로 종료 아님??
				backTracking(i+1);
				//재 실행을 위해서 초기화  그런데 이 위치에서 적용이 어케 됨?
				check[j] = false;
			}
			
		}
	}
	
}
