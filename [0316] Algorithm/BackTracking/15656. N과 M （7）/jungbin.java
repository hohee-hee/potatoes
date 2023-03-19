package day0314;

import java.io.*;

import java.util.*;


public class P15656_n과m7 {
	
	static int m;
	static int[] ans;
	static int n;
	static int[] s;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// N과 M을 입력받음
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		//n개의 자연수 집합
		s = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			s[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(s);
		//정답 배열 중복 가능 사전 순 증가
		ans = new int[m];
		
		back(0);
		bw.close();
	}
	
	private static void back(int k) throws IOException {
		if(k==m) {
			
			for(int i : ans) {
				bw.write(i+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
				ans[k]=s[i];
				back(k+1);
		}
	}

}