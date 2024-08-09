import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans = 2;
        for(int i = 0; i<N; i++){
            ans = ans + (ans - 1);
        }
        System.out.print(ans * ans);
    }
}