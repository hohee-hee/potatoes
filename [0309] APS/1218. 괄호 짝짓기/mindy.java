import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = 10;
		
		for(int t=1; t<=tests; t++) {
			int ans = 1;
			int leng = sc.nextInt(); sc.nextLine();
			char[] chArr = sc.nextLine().toCharArray();
			Stack<Character> st = new Stack<>();
			
			for(int i=0; i<chArr.length; i++) {
				if(chArr[i] == ')') {
					if(st.isEmpty() || st.pop() != '(') { ans = 0; break; }
				} else if(chArr[i] == ']') {
					if(st.isEmpty() || st.pop() != '[') { ans = 0; break; }
				} else if(chArr[i] == '}') {
					if(st.isEmpty() || st.pop() != '{') { ans = 0; break; }
				} else if(chArr[i] == '>') {
					if(st.isEmpty() || st.pop() != '<') { ans = 0; break; }
				}
				else st.add(chArr[i]);
			}
			if(!st.isEmpty()) { ans = 0; }
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
// () -> 40, 41
// [] -> 91, 93
// {} -> 123, 125
// <> -> 60, 62
// 차이가 달라서 안되겠다. 