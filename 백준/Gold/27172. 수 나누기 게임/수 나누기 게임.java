import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int [][] info = new int [1000010][2]; // [몇번숫자의] [0]은 존재유무 [1]은 점수
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            info[arr[i]][0] = 1;
        }

        for(int i = 1; i<=1000000; i++){
            if(info[i][0] == 1){
                for(int j = i*2; j<=1000000; j+=i){
                    if(info[j][0] == 0) continue;
                    info[i][1]++;
                    info[j][1]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(info[arr[i]][1]).append(" ");
        }
        System.out.print(sb);
    }
}