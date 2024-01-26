import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr1 = new int [1001];
        int [] arr2 = new int [1001];

        for(int i = 0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr1[Integer.parseInt(st.nextToken())]++;
            arr2[Integer.parseInt(st.nextToken())]++;
        }

        for(int i = 1; i<1001; i++){
            if(arr1[i] % 2 == 1){
                System.out.print(i);
            }
        }

        System.out.print(" ");

        for(int i = 1; i<1001; i++){
            if(arr2[i] % 2 == 1){
                System.out.print(i);
            }
        }

    }
}