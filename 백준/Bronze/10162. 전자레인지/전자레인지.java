import java.util.*;
import java.io.*;
public class Main {
    static int T;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        T = Integer.parseInt(br.readLine());
        int AT = 300;
        int BT = 60;
        int CT = 10;

        cntA = check(AT);
        cntB = check(BT);
        cntC = check(CT);

        if(T != 0){
            System.out.print(-1);
        }else{
           System.out.print(cntA + " " + cntB + " " + cntC);
        }
    }

    static int check(int curT){
        int num = T / curT;
        T %= curT;
        return num;
    }
}