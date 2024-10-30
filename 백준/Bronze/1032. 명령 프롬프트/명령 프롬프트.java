import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [] arr = new char [60];
        String str = "";
        for(int i = 0; i<n; i++){
            str = br.readLine();
            for(int j = 0; j<str.length(); j++){
                if(i == 0){
                    arr[j] = str.charAt(j);
                }else{
                    if(arr[j] != str.charAt(j)){
                        arr[j] = '?';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}