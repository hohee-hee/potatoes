import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> al = new ArrayList<>();
		String[] t = bf.readLine().split(" ");
		int duedDo = Integer.parseInt(t[0]);
		int boDo = Integer.parseInt(t[1]);; 
		int ans = 0;

		Hashtable<String, String> ht = new Hashtable<>();
		
		for(int i=0; i<duedDo; i++) {
			String tmp = bf.readLine();
			ht.put(tmp, tmp);
		}
		
		for(int i=0; i<boDo; i++) {
			String tmp = bf.readLine();
			if(ht.get(tmp) != null) {
				ans++;
				al.add(tmp);
			}
		}
		
		Collections.sort(al);
		// 
		System.out.println(ans);
		for(String a : al) {
			System.out.println(a);
		}
	}
}