import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] edgeCnt = new int[N+1]; // 진입차수 저장(몇개가 들어오냐)
        ArrayList<Integer>[] al = new ArrayList[N+1]; // 간선 정보 저장
        for(int i=1; i<=N; i++) al[i] = new ArrayList<>();
        while(M-->0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            al[from].add(to);
            edgeCnt[to]++;
        }

        ////
        Queue<Integer> q = new ArrayDeque<>();
        // 진입차수가 0이면 큐에 넣기 반복
        for(int i=1; i<=N; i++){
            if(edgeCnt[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            System.out.print(q.peek()+ " ");
            int done = q.poll();

            for(int i=0; i<al[done].size(); i++){
                int tmp = al[done].get(i); // done이 들어가는 다른 노드
                edgeCnt[tmp]--;
                if(edgeCnt[tmp] == 0) q.add(tmp);
            }
        }
        System.out.println();
    }
}