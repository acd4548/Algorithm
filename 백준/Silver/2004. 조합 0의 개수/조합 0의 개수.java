import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = n - m;

        int n1 = 0; // 5가 몇갤까?
        int m1 = 0; // 5가 몇갤까?
        int t1 = 0; // 5가 몇갤까?

        int n11 = 0; // 2가 몇갤까?
        int m11 = 0; // 2가 몇갤까?
        int t11 = 0; // 2가 몇갤까?

        long key = 5; // 이번엔 이 숫자 차례 ~ 다음건 5곱한 애
        long key2 = 2;

        //아직 5의 제곱수
        boolean n2 = false;
        boolean m2 = false;
        boolean t2 = false;

        while(true){
            if(key <= n){
                n1 += n / key;
            }
            if(key2 <= n){
                n11 += n / key2;
            }
            if(key > n && key2 > n){
                n2 = true;
            }

            if(key <= m){
                m1 += m / key;
            }
            if(key2 <= m){
                m11 += m / key2;
            }
            if(key > m && key2 > m){
                m2 = true;
            }

            if(key <= t){
                t1 += t / key;
            }
            if(key2 <= t){
                t11 += t / key2;
            }
            if(key > t && key2 > t){
                t2 = true;
            }

            if(n2 && m2 && t2) break;

            key *= 5;
            key2 *= 2;
        }
        int count5 = n1 - (m1 + t1);
        int count2 = n11 - (m11 + t11);

        if(count5 >= count2){
            System.out.println(count2);
        }else{
            System.out.println(count5);
        }
    }
}