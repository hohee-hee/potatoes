package hw;

import java.util.Scanner;

public class P15649_n과m1 {
	
	static int m;
	static boolean[] ch;
	static int[] arr;
	static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1부터 n까지의 수 중
		int n = sc.nextInt();
		//중복 없는 m개
		m = sc.nextInt();
		
		//수 배열
		arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i]=i;
		}
		//체크 배열
		ch = new boolean[n+1];
		
		//정답 사전 순 증가 순서?********
		ans = new int[m];
		
		back(0);
	}
	
	private static void back(int a) {
		//기저 조건
		if(a==m) {
			//선택 끝나면 출력 끝
			for(int i=0; i<ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		//유도 조건
		for(int i=1; i<arr.length; i++) {
			//선택 안 된 수 추가
			if(!ch[i]) {
				ans[a]=arr[i];
				ch[i]=true;

				//다음 순서로 넘기기
				back(a+1);//**********
				
				//다 끝나고 돌아오면 선택 해제
				ch[i]=false;
				
			}
		}
	}

}
