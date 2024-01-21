import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr1 = new int [N];
        int [] arr2 = new int [M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 <= N && idx2 <= M){
            if(idx1 < N && idx2 < M){
                if(arr1[idx1] <= arr2[idx2]){
                    sb.append(arr1[idx1]).append(" ");
                    idx1++;
                }else{
                    sb.append(arr2[idx2]).append(" ");
                    idx2++;
                }
            }else if(idx1 == N){
                for(int i = idx2; i<M; i++){
                    sb.append(arr2[i]).append(" ");
                }
                break;
            }else if(idx2 == M){
                for(int i = idx1; i<N; i++){
                    sb.append(arr1[i]).append(" ");
                }
                break;
            }
        }
        System.out.println(sb);
    }
}