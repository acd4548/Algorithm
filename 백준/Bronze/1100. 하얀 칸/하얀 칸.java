import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [][] map = new char [8][8];
        for(int i = 0; i<8; i++){
            String str = br.readLine();
            for(int j = 0; j<8; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0 && map[i][j] == 'F'){
                        cnt++;
                    }
                }else{
                    if(j % 2 == 1 && map[i][j] == 'F'){
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}