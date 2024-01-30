import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<c; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 나누어떨어져야하는수
            int n = Integer.parseInt(st.nextToken()); // 수열의 크기

            int ans = 0;

            st = new StringTokenizer(br.readLine());
            long [] prefix = new long [n+1]; // 누적합 배열 만들어주기
            for(int i = 1; i<n+1; i++){
                int num = Integer.parseInt(st.nextToken());
                prefix[i] = prefix[i-1] + num;
            }

            int left [] = new int [d]; // d로 나눴을 때 나머지 몇인지 배열

            // 내앞에 있는 수들 중 나머지가 같은애 있다면 그 수만큼 ans에 더하고 1(본인) 더해주기
            for(int i = 0; i<n+1; i++){
                ans += left[(int) (prefix[i] % d)]++;
            }

            System.out.println(ans);

        }

    }
}