import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, M, A[], B[], temp, max;
        int T = Integer.parseInt(br.readLine());
        String str;

        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int [N];
            B = new int [M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            if(N > M){
                sb.append(act(A, B)).append("\n");
            }else{
                sb.append(act(B, A)).append("\n");
            }

        }
        System.out.print(sb);
    }

    static int act(int [] A, int [] B){
        int lenA = A.length;
        int lenB = B.length;

        int [] flag = new int [lenA];
        int max = Integer.MIN_VALUE;
        int temp = 0;

        for(int i = 0; i<lenA - lenB + 1; i++){
            for(int j = 0; j<lenB; j++){
                temp += A[j+i] * B[j];
                flag[j+i] = 1;
            }

            for(int j = 0; j<lenA; j++){
                if(flag[i] == 0){
                    temp += A[j];
                }
            }

            max = Math.max(max, temp);
            Arrays.fill(flag, 0);
            temp = 0;
        }
        return max;
    }
}