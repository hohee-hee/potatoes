import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<String> st = new Stack<>();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		// 몇번 반복할거냐
		for(int i=0; i<n; i++) {
			// 한줄
			int chk = 0; 
			String[] strAr = bf.readLine().split("");
			for(int j=0; j<strAr.length; j++) {
				//System.out.println(strAr[j]);
				if(strAr[j].equals("(")) { st.push("stackk"); }
				else if(strAr[j].equals(")")) { 
					if(st.empty()) { chk = -1; break; }
					else { st.pop(); } 
				}
			}
			if(!st.empty() || chk == -1 ) { System.out.println("NO"); }
			else { System.out.println("YES"); }
			st.clear();
		}
		
	}
}
