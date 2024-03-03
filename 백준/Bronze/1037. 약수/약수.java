
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long num = 0;
        if(N % 2 == 0){
            num = arr[0] * arr[N-1];
        }else{
            num = arr[N/2] * arr[N/2];
        }

        System.out.println(num);
    }
}