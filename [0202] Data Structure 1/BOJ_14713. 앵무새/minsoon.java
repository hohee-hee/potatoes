import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14713앵무새 {
		//문제 드럽게 기네
		// 한 앵무새는 한문장 기억, 단어 순서
		// 다음 단어를 말하기전 간격에 다른 앵무새 말함
		// 단어를 말하는 도중에 가로패지 않음
		// 같은 말 중복이 없음
		
		// N마리, 말한 문장 s , 받아 적은 문장 L
		// 문장이 가능하면 possible, 아니면 Impossible
		
	    static int N;
	    static Queue<String> Q[];
	    static Queue<String> T = new LinkedList<String>();
	    
	    
	    //데이터 값을 집어 넣는다.
	    public void InputData() {
	        Scanner sc = new Scanner(System.in);
	        // 앵무새 마리 수
	        N = sc.nextInt();
	        Q = new LinkedList[N];
	        for (int i=0; i<N; i++) {
	            Q[i] = new LinkedList<String>();
	        }
	        // 빈칸 방지
	        sc.nextLine();
	        for (int i=0; i<N; i++) {
	            String str = sc.nextLine();
	            String s[] = str.split(" ");
	            for (int j=0; j<s.length; j++) {
	                Q[i].add(s[j]);
	            }
	        }
	        String tmp = sc.nextLine();
	        String t[] = tmp.split(" ");
	        for (int i=0; i<t.length; i++) {
	            T.add(t[i]);
	        }
	    }
	 
		public void Solve() {
	        while (!T.isEmpty()) {
	            String word = T.poll();
	            boolean found = false;
	            for (int i=0; i<N; i++) {
	                //System.out.println(word+" / "+Q[i].peek());
	                if (word.equals(Q[i].peek())) {
	                    Q[i].poll();
	                    found = true;
	                }
	            }
	            if (!found) { // 앵무새 한 사이클에서 찾는 단어가 없는 경우
	                System.out.println("Impossible");
	                return;
	            }
	        }
	        for (int i=0; i<N; i++) { // (반례) 받아적은 단어가 앵무새 단어보다 적을 경우
	            while(!Q[i].isEmpty()) {
	                System.out.println("Impossible");
	                return;
	            }
	        }
	        System.out.println("Possible");
		}
	    
		public static void main(String[] args){
			Main m = new Main();
			m.InputData();///입력
			//코드를 작성하세요
	        m.Solve();
		}
}

		
		
	


