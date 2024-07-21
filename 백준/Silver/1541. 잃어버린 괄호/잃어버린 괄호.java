import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int [] num = new int [30];
        int [] sign = new int [30]; // 0은 +, 1은 -
        int numIdx = 0;
        int signIdx = 0;
        String temp = "";
        char t;
        for(int i = 0; i<str.length(); i++){
            t = str.charAt(i);
            if(t != '+' && t!= '-'){
                temp += String.valueOf(t);
            }else{
                if(t == '+'){
                    num[numIdx++] = Integer.parseInt(temp);
                    temp = "";
                    signIdx++;
                }else{
                    num[numIdx++] = Integer.parseInt(temp);
                    temp = "";
                    sign[signIdx++] = 1;
                }
            }
        }
        num[numIdx++] = Integer.parseInt(temp);

        int ans = num[0];
        int numT = 0;
        int flag = 0; //+인상태, -인상태
        for(int i = 0; i<signIdx; i++){
            if(flag == 0){
                if(sign[i] == 0){
                    ans += num[i+1];
                }else{
                    flag = 1;
                    numT += num[i+1];
                }
            }else{
                if(sign[i] == 0){
                    numT += num[i+1];
                }else{
                    ans -= numT;
                    numT = num[i+1];
                }
            }
        }
        ans -= numT;
        System.out.println(ans);
    }
}