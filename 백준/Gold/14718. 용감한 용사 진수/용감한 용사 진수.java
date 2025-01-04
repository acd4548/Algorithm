import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int info [][] = new int [N][3];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int q = 0; q<N; q++){
                    int s = info[i][0];
                    int d = info[j][1];
                    int in = info[q][2];

                    cnt = 0;
                    for(int w = 0; w<N; w++){
                        if(s >= info[w][0] && d >= info[w][1] && in >= info[w][2]){
                            cnt++;
                        }

                        if(cnt == K){
                            ans = Math.min(ans, s + d + in);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}