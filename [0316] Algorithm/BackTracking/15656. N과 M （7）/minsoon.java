import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] num;
    static boolean[] isUsed;
	public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        isUsed = new boolean[N + 1];
        arr = new int[M + 1];
        
        num = new int[N];
        for(int i =0; i<N; i++) {
        	num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        bfs(0, 0);
        System.out.println(sb);
    }

    private static void bfs(int idx, int start) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
            }
			sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
        	//false 인 경우 값이 돌아가는데
            //if (!isUsed[i]) {
            	//isUsed[i] = true;
            	arr[idx] = num[i];
                bfs(idx + 1, i); // arr의 인덱스를 +1 시켜준다.
             //   isUsed[i] = false;
           // }
        }
    }
}