import java.util.*;
import java.io.*;
public class Main {
    static int real[][], clone[][], min, visited[];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        real = new int [3][3];
        clone = new int [3][3];
        min = Integer.MAX_VALUE;
        visited = new int [10];
        for(int i = 0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                real[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(min);

    }

    static void recur(int x, int y){
        if(x == 3) {
            x = 0;
            y += 1;
        }

        if(y == 3){
            if(check()){
                min = Math.min(min, cal());
            }
            return;
        }

        for(int i = 1; i<10; i++){
            if (visited[i] == 0) {
                visited[i] = 1;
                clone[x][y] = i;
                recur(x+1, y);
                visited[i] = 0;
            }
        }

    }

    static boolean check(){
        if(clone[0][0] + clone[0][1] + clone[0][2] != 15) return false;
        if(clone[1][0] + clone[1][1] + clone[1][2] != 15) return false;
        if(clone[2][0] + clone[2][1] + clone[2][2] != 15) return false;

        if(clone[0][0] + clone[1][0] + clone[2][0] != 15) return false;
        if(clone[0][1] + clone[1][1] + clone[2][1] != 15) return false;
        if(clone[0][2] + clone[1][2] + clone[2][2] != 15) return false;

        if(clone[0][0] + clone[1][1] + clone[2][2] != 15) return false;
        if(clone[2][0] + clone[1][1] + clone[0][2] != 15) return false;

        return true;
    }

    static int cal(){
        int num = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                num += Math.abs(clone[i][j] - real[i][j]);
            }
        }
        return num;
    }
}