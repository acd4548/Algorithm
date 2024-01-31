import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int [] prefixP = new int [N+1];
        int [] prefixH = new int [N+1];
        int [] prefixS = new int [N+1];
        for(int i = 1; i<N+1; i++){
            String str = br.readLine();
            if(str.equals("P")){
                prefixP[i] = prefixP[i-1] + 1;
                prefixH[i] = prefixH[i-1];
                prefixS[i] = prefixS[i-1];
            }else if(str.equals("H")){
                prefixP[i] = prefixP[i-1];
                prefixH[i] = prefixH[i-1] + 1;
                prefixS[i] = prefixS[i-1];
            }else if(str.equals("S")){
                prefixP[i] = prefixP[i-1];
                prefixH[i] = prefixH[i-1];
                prefixS[i] = prefixS[i-1] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i<N+1; i++){
            //P -> S
            int temp = prefixP[i] + prefixS[N] - prefixS[i];
            if( max < temp){
                max = temp;
            }

            //P -> H
            temp = prefixP[i] + prefixH[N] - prefixH[i];
            if( max < temp){
                max = temp;
            }

            //S -> P
            temp = prefixS[i] + prefixP[N] - prefixP[i];
            if( max < temp){
                max = temp;
            }

            //S -> H
            temp = prefixS[i] + prefixH[N] - prefixH[i];
            if( max < temp){
                max = temp;
            }

            //H -> S
            temp = prefixH[i] + prefixS[N] - prefixS[i];
            if( max < temp){
                max = temp;
            }

            //H -> P
            temp = prefixH[i] + prefixP[N] - prefixP[i];
            if( max < temp){
                max = temp;
            }

        }

        //싹다 P일때
        if(max < prefixP[N]){
            max = prefixP[N];
        }

        //싹다 S일때
        if(max < prefixS[N]){
            max = prefixS[N];
        }

        //싹다 H일때
        if(max < prefixH[N]){
            max = prefixH[N];
        }

        System.out.println(max);
    }
}