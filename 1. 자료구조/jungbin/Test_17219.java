package day0208;

import java.util.ArrayList;
//왜 암것도 안 나올까??ㅜㅜ

import java.util.HashMap;
import java.util.Scanner;

public class Test_17219 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<>(); 
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		
		for(int i =0; i<n; i++) {
			String s = sc.next();//주소
			String k = sc.next();//비번
			map.put(s, i); //주소값과 인덱스를 넣.. 왜 비번 못 넣고...ㅜㅜ
			arr2.add(k);//비번
		}
		
		//해시 맵 주소와 일치하면 비번 인덱스를 저장
		for(int i=0; i<n; i++) {
			String s1 = sc.next();
			if(map.get(s1) != null) {
				arr.addAll(map.values());//이 부분 이상?
			}
		}
		
		//인덱스 값에 맞는 비번 출력
		for(int a : arr) {
			System.out.println(arr2.get(a));
		}
		
	}

}
