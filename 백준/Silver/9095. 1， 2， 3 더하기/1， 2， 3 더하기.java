import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            int a = Integer.parseInt(br.readLine());

            int one = a;
            int two = a / 2;
            int three = a / 3;

            int ans = 0;
            for(int j = 0; j<=one; j++){
                for(int k = 0; k<=two; k++){
                    for(int q = 0; q<=three; q++){
                        if(j + (k * 2) + (q * 3) == a){

                            int num = j + k + q;
                            int up = 1;
                            for(int u = 2; u<=num; u++){
                                up *= u;
                            }

                            if(j > 1){
                                for(int u = 2; u<=j; u++){
                                    up /= u;
                                }
                            }

                            if(k > 1){
                                for(int u = 2; u<=k; u++){
                                    up /= u;
                                }
                            }

                            if(q > 1){
                                for(int u = 2; u<=q; u++){
                                    up /= u;
                                }
                            }
                            ans += up;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}