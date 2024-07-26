import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int ans = 0;
        int [] arrA = new int [27];
        int [] arrB = new int [27];

        for(int i = 0; i<a.length(); i++){
            arrA[a.charAt(i) - 'a']++;
        }

        for(int i = 0; i<b.length(); i++){
            arrB[b.charAt(i) - 'a']++;
        }

        for(int i = 0; i<27; i++){
            if(arrA[i] > arrB[i]){
                ans += arrA[i] - arrB[i];
            }if(arrB[i] > arrA[i]){
                ans += arrB[i] - arrA[i];
            }
        }
        System.out.print(ans);
    }
}