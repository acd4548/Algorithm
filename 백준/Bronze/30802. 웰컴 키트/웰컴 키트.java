import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());
        long [] info = new long [6];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<6; i++){
            info[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long ansT = 0;
        for(int i = 0; i<6; i++){
            if(info[i] <= T && info[i] > 0){
                ansT++;
            }else{
                ansT += info[i] / T;
                if(info[i] % T > 0){
                    ansT++;
                }
            }
        }

        sb.append(ansT).append("\n");
        sb.append(N/P).append(" ").append(N%P);
        System.out.println(sb);

    }
}