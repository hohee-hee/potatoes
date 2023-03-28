package hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P15666_n과m12 {
	static int n;
	static int m;
	static int[] num;
	static boolean[] ch;
	static HashSet<String> ans;
	static int[] temp;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb= new StringBuilder();
		//n개의 수 중
		n = sc.nextInt();
		//m개를 고른 수열
		m = sc.nextInt();
		//수 배열
		num = new int[n];
		for(int i=0; i<n; i++) {
			num[i]= sc.nextInt();
		}
		//오름차순
		Arrays.sort(num);
		//확인
		ch = new boolean[n];
		temp=new int[m];
		//정답
		ans = new LinkedHashSet<>();
		
		
		back(0);
		for(String a : ans) {
			System.out.println(a);
		}
	}
	
	static void back(int k) {
		if(k==m) {
			for(int i=0; i<temp.length; i++) {
				sb.append(temp[i]+" ");
			}
			ans.add(sb.toString());
			
			sb.setLength(0);
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(k==0 ||(k>0 && temp[k-1]<=num[i])){
				temp[k]=num[i];
				back(k+1);
			}
				
		
		}
		
	}
}


