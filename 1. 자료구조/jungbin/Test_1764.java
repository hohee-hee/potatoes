package day0208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Test_1764 {
	public static void main(String[] args) throws Exception {
		Scanner sc =  new Scanner(System.in);
		//n과 m 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		HashMap<String, Integer> map = new HashMap<>(); 
		ArrayList<String> arr = new ArrayList<>();
	
		for(int i=0; i<n; i++) {
			String s = sc.next();
			map.put(s, 0);
		}
		
		//해시 맵의 키와 일치하면 리스트에 추가
		for(int i=0; i<m; i++) {
			String s1 = sc.next();
			if(map.get(s1)!=null) { 
				arr.add(s1);
			}
		}
		
		//사전순 출력을 위해 오름차순 정렬
		Collections.sort(arr);
		
		System.out.println(arr.size());
		//리스트 출력
		for(String a : arr) { 
			System.out.println(a);
		}
		sc.close();
	}

}
