import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] burgers = new int [3];
        int [] drinks = new int [2];
        for(int i = 0; i<3; i++){
            burgers[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<2; i++){
            drinks[i] = Integer.parseInt(br.readLine());
        }

        int min = 10000;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<2; j++){
                min = Math.min(min, burgers[i] + drinks[j]);
            }
        }
        System.out.println(min-50);
    }
}