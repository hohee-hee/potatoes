package hw;

import java.util.Scanner;

public class P15650_n과m2 {
	
	static int m;
	static int[] ans;
	static int[] nums;
	static boolean[] ch;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1부터 n까지 수 중
		int n = sc.nextInt();
		
		//중복 없는 m개
		m = sc.nextInt();
		
		//숫자 배열
		nums = new int[n+1];
		for(int i=1; i<=n; i++) {
			nums[i]=i;
		}
		//확인 배열
		ch = new boolean[n+1];
		
		//정답 중복 없는 오름차 순
		ans = new int[m]; 
		
		back(0);
	}
	
	private static void back(int k) {
		//기저조건
		if(k==m) {
			for(int i=0; i<ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//유도조건
		for(int i=1; i<nums.length; i++) {
			//오름차순 조건 만족, 선택 안 한 숫자일 때*****
			if(!ch[i] && (k==0 || k>0 && ans[k-1]<i)) {
				ans[k]=nums[i];
				ch[i]=true;
				back(k+1);
				ch[i]=false;
			}
		}
		
	}

}
