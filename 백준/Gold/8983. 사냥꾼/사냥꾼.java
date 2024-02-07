import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 사대의 수
        int N = Integer.parseInt(st.nextToken()); // 동물의 수
        int L = Integer.parseInt(st.nextToken()); // 사정거리

        int cnt = 0; // 잡을 수 있는 동물의 수

        //사대의 위치 입력
        int [] arrM = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        //동물의 위치 입력
        int [][] arrN = new int [N][3];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arrN[i][0] = Integer.parseInt(st.nextToken());
            arrN[i][1] += Integer.parseInt(st.nextToken());
        }

        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i]) continue;

                long dis = Math.abs(arrM[j]-arrN[i][0]) + arrN[i][1];
                if(dis <= L) {
                    check[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}