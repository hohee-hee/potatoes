import java.util.Scanner;
 
public class Solution {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        //테슼ㅔ이스 돌리기
        for(int tc = 1; tc<=T; tc++) {
            System.out.print("#" + tc + " ");
            // 전체 합을 초기화
            int total = 0;
            //부먹왕국 도시수
            int N = sc.nextInt();
            //이동제한거리
            int D = sc.nextInt();
            int[] map = new int[N];
            for(int i=0; i<N; i++) {
                map[i] = sc.nextInt();
            }
            // 0의 갯수를 카운트 하는데
            int cnt  =0;
            for(int i =0; i<N; i++) {
                if(map[i] == 0) {
                    cnt++;
                    //map 을 0 으로 카운트 한 경우 
                }else { // 1을 만나는 경우이 아닌 경우 카운트를 하지 않는다.
                    //1을 만나면 필요한 포탈의갯수를 불러옴
                    int sum =  cnt / D;
                    total += sum; 
                    cnt = 0;
                }
            }
            // 0으로 끝나는 경우
            if(map[N-1] == 0) {
                System.out.println(total + cnt/D);
            }else { // 1로 끝나는경우
                System.out.println(total);}
                    }
          
          
          
          
          
    }
 
}