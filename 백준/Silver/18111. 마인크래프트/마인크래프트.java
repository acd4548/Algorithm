import java.io.*;
import java.util.*;
public class Main {
    static int N, M, B, map[][], min, hight, maxBlock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //최소시간, 그 경우 땅의 높이.
        //시간이 같다면 높이가 큰걸로
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        maxBlock = B;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxBlock += map[i][j];
            }
        }

        for(int i = 256; i>= 0; i--){
            if(N * M * i > maxBlock) continue;
            count(i);
        }

        System.out.println(min + " " + hight);
    }
    private static void count(int h){
        int tempTime = 0;
        int tempB = B;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] > h){
                    tempTime += (map[i][j] - h) * 2;
                    B++;
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] < h){
                    tempTime += (h - map[i][j]);
                    B--;
                    if(B < 0) return;
                }
            }
        }

        if(tempTime < min){
            min = tempTime;
            hight = h;
        }
    }
}