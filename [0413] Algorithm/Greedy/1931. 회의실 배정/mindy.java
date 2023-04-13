import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
        });

        int ed = arr[0][1];
        int cnt = 1;
        for (int i=1; i<N; i++) {
            if(arr[i][0] >= ed) {
                ed = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}