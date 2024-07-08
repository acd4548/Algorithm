import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int [] arr = new int [T];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<T; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + 1;
        }

        int Y = 0;
        int M = 0;

        for(int i = 0; i<T; i++){
            Y += (arr[i] / 30) * 10;
            if( arr[i] % 30 > 0 ){
                Y += 10;
            }

            M += (arr[i] / 60) * 15;
            if( arr[i] % 60 > 0 ){
                M += 15;
            }
        }

        if(Y > M){
            sb.append("M").append(" ").append(M);
        }else if(Y < M){
            sb.append("Y").append(" ").append(Y);
        }else{
            sb.append("Y M").append(" ").append(M);
        }
        System.out.println(sb);
    }
}