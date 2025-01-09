import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int [][] arr = new int [H+X][W+Y];
        for(int i = 0; i<H+X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<W+Y; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<H; i++){
            for(int j = 0; j<W; j++){
                if(i - X >= 0 && j - Y >= 0){
                    arr[i][j] = arr[i][j] - arr[i-X][j-Y];
                    sb.append(arr[i][j]).append(" ");
                }else{
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}