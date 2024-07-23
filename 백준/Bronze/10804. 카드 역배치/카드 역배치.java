import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int [] arr = new int [21];
        for(int i = 1; i<21; i++){
            arr[i] = i;
        }

        int s, e;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            for(int j = s; j<=e; j++){
                stack.add(arr[j]);
            }

            for(int j = s; j<=e; j++){
                arr[j] = stack.pop();
            }
        }

        for(int i = 1; i<21; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}