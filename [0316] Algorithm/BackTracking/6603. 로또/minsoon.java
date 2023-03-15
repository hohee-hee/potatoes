import java.util.*;

public class Main {
    static int N, M, num1;
    static int[] arr;
    static int[] num;
    static boolean[] isUsed;
	public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();
//
//        isUsed = new boolean[N + 1];
//        arr = new int[M + 1];
        while(true) {
        	num1  = sc.nextInt();
        	
        	if(num1 == 0) break;
        	num = new int[num1];
        	for(int i =0; i<num1; i++) {
        		num[i] = sc.nextInt();
        	}
        	arr = new int[6];
        	 isUsed = new boolean[num1 + 1];
        
        	 bfs(0, 0);
        	 System.out.println(sb);
        	 // 출력하고 sb  초기화를 해야하는데
        	 sb.setLength(0);
        }
        System.out.println();
    }

    private static void bfs(int idx, int start) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
				sb.append(arr[i] + " ");
            }
			sb.append('\n');
            return;
        }

        for (int i = start; i < num1; i++) {
        	//false 인 경우 값이 돌아가는데
            if (!isUsed[i]) {
            	isUsed[i] = true;
            	arr[idx] = num[i];
                bfs(idx + 1, i); // arr의 인덱스를 +1 시켜준다.
                isUsed[i] = false;
            }
        }
    }
}