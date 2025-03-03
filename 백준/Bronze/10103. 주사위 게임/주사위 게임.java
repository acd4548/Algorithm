import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cn = 100;
        int ds = 100;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnT = Integer.parseInt(st.nextToken());
            int dsT = Integer.parseInt(st.nextToken());

            if(cnT > dsT){
                ds -= cnT;
            }else if(cnT < dsT){
                cn -= dsT;
            }
        }

        System.out.println(cn);
        System.out.println(ds);
    }
}