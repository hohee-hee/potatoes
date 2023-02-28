package day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test_14713 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//어떻게 n+1개 만큼 queue를 반복해서 만드나???
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		Queue<String> q3 = new LinkedList<>();
		Queue<String> q4 = new LinkedList<>();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//각각의 큐에 한줄씩 받아 단어 단위로 넣기
		for(int i=0; i<n+1; i++) {
			String st = br.readLine();
			//q1.get(i) = st.split(" "); //각각의 큐에 넣기???
				
		}
		
		//q4의 원소가 각큐들의 첫 원소들과 일치하면 비워준다. 다 비우면  possible, 중간에 찾지 못하면 impossible 출력하고 중지 
		if(q4.get(i).equals(q1.get(i))) {
			q4.poll();
			q1.poll();
			if(q4.isEmpty()) {
				System.out.println("possible");
				break;
			} else {
				continue;
			}
		} else if(q4.get(i).equals(q2.get(i))) {
			q4.poll();
			q2.poll();
			if(q4.isEmpty()) {
				System.out.println("possible");
				break;
			} else {
				continue;
			}
		} else if(q4.get(i).equals(q3.get(i))) {
			q4.poll();
			q3.poll();
			if(q4.isEmpty()) {
				System.out.println("possible");
				break;
			} else {
				continue;
			}
		} else {
			System.out.println("impossible");
		}
		
	}
}
