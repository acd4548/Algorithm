import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long [][] arr = new long [N+1][M+1];
        long [][] prefix = new long [N+1][M+1];

        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j<M+1; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i][j];
            }

        }

        long max = Long.MIN_VALUE;
        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<M+1; j++){
                for(int q = 1; q<i+1; q++){
                    for(int w = 1; w<j+1; w++){
                        long temp = prefix[i][j] - prefix[i][w-1] - prefix[q-1][j] + prefix[q-1][w-1];
                        if(max < temp){
                            max = temp;
                        }
                    }
                }
            }
        }

        System.out.println(max);

    }
}