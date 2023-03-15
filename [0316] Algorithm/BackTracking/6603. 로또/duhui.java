import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            if(S == 0) break;

            // 입력 받기
            int[] arr = new int[S];
            for (int i = 0; i < S; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 정답 저장할 배열
            int[] answer = new int[6];
            backTracking(arr, answer, 0);

            sb.append("\n");
        }
        System.out.println(sb);
    }
    // 백트래킹 method
    private static void backTracking(int[] arr, int[] answer, int k) {
        // 6개의 숫자를 고르면 종료하고 프린트한다.
        if (k == 6) {
            for (int a: answer) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        // k==0이면 모든 숫자를 넣을 수 있다.
        // k!=0이면 이전 숫자보다 큰 숫자만 넣게 만들어서 중복을 막는다.
        for (int i = 0; i < arr.length; i++) {
            if(k == 0) {
                answer[k] = arr[i];
                backTracking(arr, answer, k+1);
            } else if (answer[k-1] < arr[i]) {
                answer[k] = arr[i];
                backTracking(arr, answer, k+1);
            }
        }
    }
}