package hw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2667_단지 {
	private static int[] dx;
    private static int[] dy;
    private static int[] home;
    private static int n;
    private static int num_a;
    private static boolean[][] ch;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //크기
        n = sc.nextInt();
        //배열
        map = new int[n][n];
        ch = new boolean[n][n];

        //전체 사각형 입력 받기
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j)-'0';
             }
        }
        
        //델타
        dx = {0, 0,1,-1};
        dy = {1,-1,0,0};
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !초[i][j]){
                    num_a++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(home);
        System.out.println(num_a);

        for(int i=0; i<home.length; i++){
            if(home[i] == 0){
            }else{
                System.out.println(home[i]);
            }
        }

}

    private static void bfs(int x, int y) {
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});
        ch[x][y] = true;
        home[num_a]++;

        while(!que.isEmpty()){

            
            int cx = que.peek()[0];
            int cy = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(map[nx][ny] == 1 && !ch[nx][ny]){
                        que.add(new int[]{nx,ny});
                        ch[nx][ny] = true;
                        home[num_a]++;
                    }
                }
            }
        }
    }
}
