import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static String arr[], used[];
    static StringBuilder sb = new StringBuilder();
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        used = new String[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        recur(0, 0, 0, 0);
        System.out.println(sb);
    }

    static void recur(int cur, int idx, int cntJ, int cntM){
        if(idx == L){
            if(cntJ > 1 && cntM > 0){
                for(int i = 0; i<L; i++){
                    sb.append(used[i]);
                }
                sb.append("\n");
            }
            return;
        }
        if(cur == C) return;

        if(arr[cur].equals("a") || arr[cur].equals("e") || arr[cur].equals("i") || arr[cur].equals("o") || arr[cur].equals("u")){
            used[idx] = arr[cur];
            recur(cur+1, idx+1, cntJ, cntM+1);
            recur(cur+1, idx, cntJ, cntM);
        }else{
            used[idx] = arr[cur];
            recur(cur+1, idx+1, cntJ+1, cntM);
            recur(cur+1, idx, cntJ, cntM);
        }
    }
}