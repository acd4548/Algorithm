import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            while(st.hasMoreTokens()){
                q.offer(Integer.parseInt((st.nextToken())));
            }

            int size = q.size();
            int [] arr = new int [size];

            for(int i = 0; i<size; i++){
                arr[i] = q.poll();
            }

            int max = -1;
            for(int i = 0; i<size-1; i++){
                for(int j = i+1; j<size; j++){
                    int a = 0;
                    int b = 0;
                    if(arr[i] > arr[j]){
                        a = arr[i];
                        b = arr[j];
                    }else{
                        b = arr[i];
                        a = arr[j];
                    }
                    while(true){
                        if(b == 0 || a % b == 0){
                            break;
                        }
                        int temp = a;
                        a = b;
                        b = temp % b;
                    }
                    if(b == 0){
                        if(max < a) max = a;
                    }else{
                        if(max < b) max = b;
                    }
                }
            }
            System.out.println(max);
        }
    }
}