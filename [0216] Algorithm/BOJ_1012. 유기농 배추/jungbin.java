import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P03_1012 {

    static int[][] ground;      
    static boolean[][] check;   
    static int weight;          
    static int height;          

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            ground = new int[weight][height];
            check = new boolean[weight][height];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;   
            }
        
            int count=0;    
            
            for (int j = 0; j < weight; j++) {
                for (int k = 0; k < height; k++) {
 
                     if(ground[j][k] == 1 && !check[j][k]){
                         bfs(j, k);
                         count++;
                     }
                }
            }

            System.out.println(count);
        }

    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();  
        queue.offer(new int[] {startX, startY});

        check[startX][startY] = true;

        
        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
      
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + X[i];
                int y = poll[1] + Y[i];
        
                if(x < 0 || x >= weight || y < 0 || y >= height){
                    continue;
                }

                if(ground[x][y] == 1 & !check[x][y]){
                    queue.offer(new int[] {x, y});

                    check[x][y] = true;
                }

            }
        }

    }

}