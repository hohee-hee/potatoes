import java.util.Scanner;

public class Main {
    static boolean chk[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); sc.nextLine();
        int[][] arr = new int[n][m];
        for(int y=0; y<n; y++) {
            String str = sc.nextLine();
            for(int x=0; x<m; x++)
                arr[y][x] = Integer.parseInt(str.substring(x, x+1));
        }

        int max = 0;
        int[][] dp = new int[n][m];
        for(int y=0; y<n; y++) {
            for (int x = 0; x < m; x++) {
                if(arr[y][x] == 1) {
                    int tmpMin = Integer.MAX_VALUE;
                    for(int d=0; d<3; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(nx < 0 || ny < 0) {
                            tmpMin = 0;
                            continue;
                        }
                        if(tmpMin > dp[ny][nx]) tmpMin = dp[ny][nx];
                    }
                    dp[y][x] = tmpMin+1;
                    if(max < dp[y][x]) max = dp[y][x];
                }
            }
        }
        System.out.println(max*max);
    }
    static int[] dx = { 0, -1, -1 };
    static int[] dy = { -1, 0, -1 };
}