import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int max = -1;
        int s = 0;
        int e = 0;
        int first = arr[0];
        int lastIdxOfFirst = 0;
        int second = arr[0];
        int lastIdxOfSecond = 0;

        while(e < N+1){
            if(e == N){
                max = Math.max(max, e - s);
                break;
            }

            if(arr[e] == first){
                lastIdxOfFirst = e;
            }else if(arr[e] == second){
                lastIdxOfSecond = e;
            }else{
                if(first == second){
                    second = arr[e];
                    lastIdxOfSecond = e;
                }else{
                    max = Math.max(max, e - s);
                    if(lastIdxOfFirst < lastIdxOfSecond){
                        s = lastIdxOfFirst + 1;
                        first = second;
                        second = arr[e];
                        lastIdxOfFirst = lastIdxOfSecond;
                        lastIdxOfSecond = e;
                    }else{
                        s = lastIdxOfSecond + 1;
                        second = arr[e];
                        lastIdxOfSecond = e;
                    }
                }
            }
            e++;
        }
        System.out.println(max);
    }
}