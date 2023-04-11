 package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1600 {
    
    static int K, H, W, min;
    static int[][] map;
    static boolean[][] isVisited;
    
    //델타배열
    static int[] drH = {-1,-2,-2,-1,1,2,2,1};
    static int[] dcH = {-2,-1,1,2,2,1,-1,-2};
    static int[] drM = {0,-1,0,1};
    static int[] dcM = {-1,0,1,0};
    
    
    public static void main(String[] args) throws IOException {
        
        //1. 입력 받기    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        
        for(int r = 0 ; r < H ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < W ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        //2. 백트래킹
        min = Integer.MAX_VALUE;
        isVisited = new boolean[H][W];
        bt(0,0,0,0);
        
        //3. 출력
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }


    private static void bt(int depth, int row, int col, int horse) {
        //기저 조건
        //1. 이미 최솟값보다 크거나 같은 경우 종료
        System.out.println(depth + " " + horse);
        if(depth >= min) return;
        
        //2. 잘 도착했을 때
        if(row == H-1 && col == W-1) {
            if(min > depth) min = depth;
            return;
        }
        
        //3. 도착한 장소가 장애물일때
        if(map[row][col] == 1) return;
        
        //재귀
        //1. 말처럼 움직일 수 있을 때
        if(horse < K) {
            for(int dir = 0 ; dir < 8 ; dir++) {
                int nr = row + drH[dir];
                int nc = col + dcH[dir];
                
                //Bounds chk
                if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
                
                //visited chk
                if(isVisited[nr][nc]) continue;
                
                //change visited
                isVisited[nr][nc] = true;
                
                //bt
                bt(depth+1, nr,nc,horse+1);
                
                //change visited
                isVisited[nr][nc] = false;                
            }
        }
        
        for(int dir = 0 ; dir < 4 ; dir++) {
            int nr = row + drH[dir];
            int nc = col + dcH[dir];
            
            //Bounds chk
            if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
            
            //visited chk
            if(isVisited[nr][nc]) continue;
            
            //change visited
            isVisited[nr][nc] = true;
            
            //bt
            bt(depth+1, nr,nc,horse+1);
            
            //change visited
            isVisited[nr][nc] = false;        
        }
    }
}