package potato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P05_호희2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		ArrayList<Character> ans = new ArrayList<>();
		int sum =0;
		for(int i=0; i<s.length(); i++) {
			//알파벳
			if(Character.isLetter(s.charAt(i))) {
				ans.add(s.charAt(i));
			}
			//숫자합
			else {
				sum+= s.charAt(i)-'0';
			}
		}
		//오름차순
		Collections.sort(ans);
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i));
		}
		System.out.println(sum);
	}
}
