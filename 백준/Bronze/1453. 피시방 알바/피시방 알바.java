import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int [] arr = new int [101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(arr[num] == 0){
                arr[num] = 1;
            }else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}