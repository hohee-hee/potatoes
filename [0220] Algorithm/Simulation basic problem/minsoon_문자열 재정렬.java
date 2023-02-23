package main;

import java.util.Arrays;
import java.util.Scanner;

public class Ho_문자열재정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		char[] arr = S.toCharArray();
		Arrays.sort(arr);
		
		// 숫자의 아스키코드  48 ~ 57 (0~9)까지
		System.out.println(arr);
		//만약 숫자면 뒤에 넣기
		for(int i =0; i<arr.length; i++) {
			// 아
			if(arr[i]>= 48 && arr[i]<=58) {
				arr = remove(arr, i);
			}
			
		}
	

		
		
		
	}

}
