import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int [3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if(arr[0] == arr[1] && arr[1] == arr[2]){
            System.out.println(arr[0] * 3);
        }else if(arr[0] + arr[1] > arr[2]){
            System.out.println(arr[0] + arr[1] + arr[2]);
        }else{
            System.out.println((arr[0] + arr[1]) * 2 - 1);
        }
    }
}