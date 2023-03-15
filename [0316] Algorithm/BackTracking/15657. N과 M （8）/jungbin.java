package day0314;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15657_n과m8 {
	
	private static BufferedWriter bw;
	static int m;
	static int n;
	static int[] ans;
	static int[] s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		//n개중 m개
		n = Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		//n개의 자연수 집합
		s= new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			s[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(s);
		//정답 배열 중복 가능 비내림차순 사전 순 증가
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
			if(k==0|| ans[k-1]<=s[i]) {
				ans[k]=s[i];
				back(k+1);
			}
		
		}
	}

}
