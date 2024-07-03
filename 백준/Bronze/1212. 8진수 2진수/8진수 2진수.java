import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    static boolean flag = false;
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int num = 0;
        String temp = "";
        if(str.equals("0")){
            System.out.println(0);
            return;
        }
        for(int i = 0; i<str.length(); i++){
            if(i == 1) flag = true;
            sb.append(be2(str.charAt(i) - '0'));
        }
        System.out.println(sb);
    }

    private static String be2(int num){
        if(num == 0){
            if(!flag){
                return "";
            }else{
                return "000";
            }
        }else if(num == 1){
            if(!flag){
                return "1";
            }else{
                return "001";
            }
        }else if(num == 2){
            if(!flag){
                return "10";
            }else{
                return "010";
            }
        }else if(num == 3){
            if(!flag){
                return "11";
            }else{
                return "011";
            }
        }else if(num == 4){
            return "100";
        }else if(num == 5){
            return "101";
        }else if(num == 6){
            return "110";
        }else if(num == 7){
            return "111";
        }
        return "";
    }
}