import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());


        int cntB = 0;
        int cntW = 0;

        int s = 0;
        int e = 1;

        String str = br.readLine();
        if(str.charAt(0) == 'B'){
            cntB++;
        }else{
            cntW++;
        }

        int len = str.length();
        int max = Integer.MIN_VALUE;
        while(e < len){
            if(str.charAt(e) == 'W'){
                cntW++;
            }else{
                cntB++;
            }

            if(cntB > B){
                while(true){
                    if(str.charAt(s) == 'B'){
                        s++;
                        cntB--;
                        if(cntW >= W && cntB <= B){
                            max = Math.max(max, (cntW + cntB));
                        }
                        if(s >= e) {
                            e++;
                            break;
                        }
                        e++;
                        break;
                    }else{
                        s++;
                        cntW--;
                    }
                }
            }else if(cntW >= W && cntB <= B){
                max = Math.max(max, (cntW + cntB));
                e++;
            }else{
                e++;
            }
        }
        if(len == 1){
            if(cntB <= B && cntW >= W){
                System.out.println(cntB + cntW);
            }else if(max == Integer.MIN_VALUE){
                System.out.println(0);
            }
        }else if(max == Integer.MIN_VALUE){
            System.out.println(0);
        }else {
            System.out.println(max);
        }
    }
}