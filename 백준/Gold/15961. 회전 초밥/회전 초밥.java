import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int [] sushiArr = new int [N];
        int [] cntArr = new int [d + 1];
        for(int i = 0; i<N; i++){
            sushiArr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int cnt = 1;
        cntArr[c]++;
        for(int i = 0; i<k; i++){
            if(cntArr[sushiArr[i]]++ == 0){
                cnt++;
            }
        }

        int removeIdx = 0;
        int addIdx = k;
        for(int i = 0; i<N; i++){
            if(--cntArr[sushiArr[removeIdx]] == 0){
                cnt--;
            }

            if(cntArr[sushiArr[addIdx]]++ == 0){
                cnt++;
            }

            max = Math.max(max, cnt);
            removeIdx = (removeIdx + 1) % N;
            addIdx = (addIdx + 1) % N;
        }

        System.out.println(max);
    }
}