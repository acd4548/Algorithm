import java.util.*;
import java.io.*;
public class Main {
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int [] arr1 = new int [27];
            int [] arr2 = new int [27];

            for(int j = 0; j<a.length(); j++){
                arr1[a.charAt(j) - 'a']++;
            }

            int flag = 1;
            for(int j = 0; j<b.length(); j++){
                int temp = b.charAt(j) - 'a';
                arr1[temp]--;
                if(arr1[temp] < 0){
                    flag = 0;
                    break;
                }
            }

            if(flag == 0 || a.length() != b.length()){
                sb.append("Impossible").append("\n");
            }else{
                sb.append("Possible").append("\n");
            }
        }
        System.out.print(sb);
    }
}