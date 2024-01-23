import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;

        int max = Integer.MIN_VALUE;

        while(s < e){
            int num = (e - s - 1) * Math.min(arr[s], arr[e]);

            if(num > max){
                max = num;
            }

            if(arr[s] > arr[e]){
                int temp = e;
                while(s < e){
                    e--;
                    if(arr[temp] < arr[e]){
                        break;
                    }
                }
            }else if(arr[s] < arr[e]){
                int temp = s;
                while(s < e){
                    s++;
                    if(arr[temp] < arr[s]){
                        break;
                    }
                }
            }else{
                int temp1 = s;
                int temp2 = e;
                while(s < e){
                    s++;
                    e--;
                    if(arr[temp1] < arr[s]){
                        e = temp2;
                        break;
                    }else if(arr[temp2] < arr[e]){
                        s = temp1;
                        break;
                    }
                }
            }
        }

        System.out.println(max);

    }
}