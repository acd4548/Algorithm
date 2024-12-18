import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int [N][2];
        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int [] answer = new int [N];
        Arrays.fill(answer, Integer.MAX_VALUE);

        int [] temp = new int [2];
        for(int i = 0; i<N; i++){
            temp[0] = arr[i][0];
            for(int j = 0; j<N; j++){
                temp[1] = arr[j][1];

                int [] costs = new int [N];
                for(int k = 0; k<N; k++){
                    costs[k] = Math.abs(temp[0] - arr[k][0]) + Math.abs(temp[1] - arr[k][1]);
                }

                Arrays.sort(costs);
                int cost = 0;
                for(int k = 0; k<N; k++){
                    cost += costs[k];
                    answer[k] = Math.min(answer[k], cost);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}