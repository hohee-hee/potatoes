import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, min = -1;
	static int[] popu; 
	static ArrayList<Integer> ans = new ArrayList<>();
	static ArrayList<Integer>[] link; // 인접지역 정보 저장 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		popu = new int[N+1];
		link = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			popu[i] = sc.nextInt();
			link[i] = new ArrayList<>();
		}
		for(int i=1; i<=N; i++) {
			int n = sc.nextInt();
			while(n-->0) link[i].add(sc.nextInt());
		}
		
		select(0, 1);
		System.out.println(min);
	}
	static void select(int k, int now) {
		if(k == N) { // 인접 노드를 조건에 맞게 고르기 완료한 상태
			if(ans.isEmpty() || ans.size()==N) return;
			ArrayList<Integer> ab = new ArrayList<>();
			ArrayList<Integer> ans2 = new ArrayList<>();			
			for(int i=1; i<=N; i++) {
				if(!ans.contains(i)) {
					ans2.add(i);
					ab.addAll(link[i]);
				}
			}
			if(!chkLink(ans) || !chkLink(ans2)) return;
			
			// 계산
			int sum1 = 0, sum2 = 0;
			for(int a : ans) sum1 += popu[a];
			for(int a : ans2) sum2 += popu[a];
			if(min == -1 || Math.abs(sum1-sum2) < min)
				min = Math.abs(sum1-sum2);
			return;
		}
		
		for(int i=now; i<=N; i++) {
			ans.add(i);
			select(k+1, i+1);
			ans.remove(Integer.valueOf(i));
			select(k+1, i+1);
		}
	}
	static boolean chkLink(ArrayList<Integer> ans) { // 묶음 다 연결됐는지 확인
		boolean[] chk = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(ans.get(0));
		while(!q.isEmpty()) { // 그래프 bfs
			int tmp = q.poll();
			chk[tmp] = true;
			for(int a : link[tmp]) {
				if(!chk[a] && ans.contains(a)) q.add(a);
			}
		}
		for(int a : ans) { if(!chk[a]) return false; } // 방문 안한 노드 있으면
		return true;
	}
}
