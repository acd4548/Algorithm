import java.util.*;
import java.io.*;
public class Main {
    static int N, info[][], gom[], sel[], min;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int [N][3];
        gom = new int [3];
        sel = new int [7];
        min = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<3; i++){
            gom[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0);
        System.out.println(min);
    }

    static void recur(int cur, int idx){
        if(idx >= 7){
            min = Math.min(min, cal(idx));
            return;
        }

        if(cur >= N){
            if(idx <= 1) return;
            min = Math.min(min, cal(idx));
            return;
        }

        sel[idx] = cur;
        recur(cur+1, idx+1);
        recur(cur+1, idx);
    }

    static int cal(int idx){
        int R = 0;
        int G = 0;
        int B = 0;
        for(int i = 0; i<idx; i++){
            R += info[sel[i]][0];
            G += info[sel[i]][1];
            B += info[sel[i]][2];
        }
        R /= idx;
        G /= idx;
        B /= idx;
        int num = Math.abs(gom[0] - R) + Math.abs(gom[1] - G) + Math.abs(gom[2] - B);
        return num;
    }
}