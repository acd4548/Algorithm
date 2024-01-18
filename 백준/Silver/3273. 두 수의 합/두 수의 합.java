import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = n-1;

        int num = Integer.parseInt(br.readLine());

        int sum = 0;

        int ans = 0;

        while(s < e){
            sum = arr[s] + arr[e];
            if(sum > num){
                e--;
            }else if(sum < num){
                s++;
            }else{
                e--;
                s++;
                ans++;
            }
        }

        System.out.println(ans);

    }
}