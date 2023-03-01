import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pNum = sc.nextInt();
		//ArrayList<Queue<String>> ar = new ArrayList<>();
		// 앵무새가 들어갈 리스트
		Queue arr[] = new Queue[pNum];
		
		// 한마리씩 공간
		for(int i=0; i<pNum; i++) {
			Queue<Integer> q = new LinkedList<>();
			arr[i] = q;
		}
		sc.nextLine();
		
		// 한마리씩 말한거 넣기
		for(int i=0; i<pNum; i++) {
			String str = sc.nextLine();
			String [] tmp = str.split(" ");
			for(int j=0; j<tmp.length; j++) { arr[i].offer(tmp[j]); }
		}
		// 잘 들어감? ㅇㅇ
//		Iterator iter = arr[0].iterator();
//		while (iter.hasNext()) System.out.println(iter.next()+" ");
		
		// 가능 불가능 확인
		String[] phrase = sc.nextLine().split(" ");
		for(int i=0; i<phrase.length; i++) {
			int chk = 0;
			// n마리 다 확인
			for(int j=0; j<pNum; j++) {
				if(!(arr[j].isEmpty()) && (arr[j].peek().equals(phrase[i]))) {
					chk = 1;
					arr[j].poll();
				}
			}
			if(chk == 0) { System.out.println("Impossible"); return; }
		}
		
		for(int i=0; i<pNum; i++) {
			if(!arr[i].isEmpty()) {
				System.out.println("Impossible"); return;
			}
		}
		
		System.out.println("Possible");
	}
}