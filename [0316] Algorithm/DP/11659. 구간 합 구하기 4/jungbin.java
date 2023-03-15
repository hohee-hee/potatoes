package day0314;

import java.io.*;
import java.util.*;

public class P11659_구간합4_1 {
	
	static int ii;
	static int jj;
	static int ans;
	static int[] num;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//수의 개수  n
		int n = Integer.parseInt(st.nextToken());
		//합 횟수 m
		int m = Integer.parseInt(st.nextToken());
		
		//n개의 수 집합 num 누적합
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num1= Integer.parseInt(st.nextToken());
			if(i==0)
				num[i]=num1;
			else
				num[i]=num1+num[i-1];
		}
		
		//합 m번 구간
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			ii = Integer.parseInt(st.nextToken());
			jj = Integer.parseInt(st.nextToken());
			
			bw.write(sum(ii, jj)+"\n");
			
		}
		bw.close();
	}
	
	private static int sum(int k, int kk) {
		if(k==1)
			return num[kk-1];
		else
			return num[kk-1]-num[k-2];
	}

}
