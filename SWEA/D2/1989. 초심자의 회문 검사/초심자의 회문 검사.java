import java.util.*;
import java.io.*;
public class Solution {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        String str;

        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            str = br.readLine();
            temp = new StringBuilder();
            temp.append(str).reverse();
            if(str.contentEquals(temp)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}