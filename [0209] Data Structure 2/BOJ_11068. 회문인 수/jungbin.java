package day0208;//어디선가 틀림

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Test_11068 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
 
		int n = Integer.parseInt(br.readLine());
		
		//n번 반복 쪼개서 덱에 넣어주기
		for(int i =0; i<n; i++) {
			String a = br.readLine();
			int k = a.length();
			String[] s = a.split("");
			for(int j=0; j<n; j++) {
				dq.offer(Integer.parseInt(s[j]));
			}
			//덱의 첫번째와 마지막이 같으면 제거하고 반복 아니면 0출력
			//덱 길이/2 (몫)만큼 반복
			for(int t=0; t<k/2; t++) {
				if(dq.getFirst() == dq.getLast()) {
					dq.removeFirst();
					dq.removeLast();
				} else {
					System.out.println("0");
					break;
				}
			}
			System.out.println("1");
		}
		
	}

}
