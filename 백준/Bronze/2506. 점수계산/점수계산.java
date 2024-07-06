import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int num = 0;
        int temp = 1;

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++){
            if(arr[i] == 1){
                num += temp++;
            }else{
                temp = 1;
            }
        }

        System.out.println(num);

    }
}