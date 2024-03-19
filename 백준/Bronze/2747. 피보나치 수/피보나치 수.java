import java.util.*;
import java.io.*;

public class Main {
    static int N, memories[];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memories = new int [N+1];
        Arrays.fill(memories, -1);
        memories[0] = 1;
        memories[1] = 1;

        recur(N);
        System.out.println(memories[N-1]);
    }
    static int recur(int cur){
        if(cur == 0 || cur == 1){
            return 1;
        }

        if(memories[cur] != -1){
            return memories[cur];
        }

        memories[cur] = recur(cur-1) + recur(cur-2);
        return memories[cur];
    }
}