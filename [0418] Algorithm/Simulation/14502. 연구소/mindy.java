import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, max = 0;
    static int[][] arr;
    static ArrayList<int[]> vir = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for(int y=0; y<N; y++) {
            for (int x = 0; x < M; x++) {
                arr[y][x] = sc.nextInt();
                if(arr[y][x] == 2) vir.add(new int[]{x, y});
            }
        }

        select(0);
        System.out.println(max);
    }
    static void select(int k) {
        if(k==3) {
            bfs();
            return;
        }
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(arr[y][x] == 0) {
                    arr[y][x] = 1; // 벽 만들기
                    select(k+1);
                    arr[y][x] = 0; // 복구
                }
            }
        }
    }
    static void bfs() {
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) copy[i] = arr[i].clone();
        boolean[][] chk = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        q.addAll(vir);
        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N
                        || copy[ny][nx] != 0 || chk[ny][nx]) continue;

                chk[ny][nx] = true;
                copy[ny][nx] = 2;
                q.add(new int[]{nx, ny});
            }
        }

        int tmp = 0;
        for(int y=0; y<N; y++) {
            for (int x = 0; x < M; x++) {
                if(copy[y][x] == 0) tmp++;
            }
        }
        if(tmp > max) max = tmp;
    }
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
}