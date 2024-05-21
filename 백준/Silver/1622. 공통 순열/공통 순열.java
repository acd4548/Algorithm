import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] arr1 = new int [26];
        int [] arr2 = new int [26]; // 0이 a
        while(true){
            String a = br.readLine();
            if(a == null){
                break;
            }
            String b = br.readLine();

            for(int i = 0; i<a.length(); i++){
                arr1[a.charAt(i) - 'a']++;
            }

            for(int i = 0; i<b.length(); i++){
                arr2[b.charAt(i) - 'a']++;
            }

            for(int i = 0; i<26; i++){
                while(arr1[i] > 0 && arr2[i] > 0){
                    char c = (char) (i + 'a');
                    arr1[i]--;
                    arr2[i]--;
                    sb.append(c);
                }
                arr1[i] = 0;
                arr2[i] = 0;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}