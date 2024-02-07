import java.util.*;
import java.io.*;

public class Main {
    static int [] arr;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new int [N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 1;
        int e = arr[N-1] - arr[0] + 1;

        while(s <= e){
            int mid = (s + e) / 2;

            if(check(mid) < C){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        System.out.println(s - 1);

    }

    public static int check(int num){
        int count = 1;
        int last = arr[0];

        for(int i = 1; i<arr.length; i++){
            int locate = arr[i];

            if(locate - last >= num){
                count++;
                last = locate;
            }
        }
        return count;
    }
}