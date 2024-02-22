import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int info [][] = new int [41][2];
        info[0][0] = 1;
        info[1][1] = 1;
        for(int i = 2; i<41; i++){
            info[i][0] = info[i-1][0] + info[i-2][0];
            info[i][1] = info[i-1][1] + info[i-2][1];
        }
        for(int t = 0; t <tc; t++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(info[N][0] + " " + info[N][1]);
        }
    }
}