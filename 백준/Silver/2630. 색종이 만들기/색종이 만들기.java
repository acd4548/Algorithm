import java.util.*;
import java.io.*;
public class Main {
    static int N, map[][], visited[][], blue, white, divide;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        visited = new int [N][N];
        blue = 0;
        white = 0;
        divide = N;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag = 0;
        int cnt;
        while(flag == 0){
            cnt = 0;
            for(int i = 0; i<N; i += divide){
                for(int j = 0; j<N; j += divide){
                    if(visited[i][j] == 0){
                        if(check(i, j)){
                            beVisited(i, j);
                            cnt++;
                        }
                    }else{
                        cnt++;
                    }
                }
            }

            if(cnt == (N/divide) * (N/divide)){
                flag = 1;
            }else{
                divide /= 2;
            }
        }
        System.out.println(white);
        System.out.println(blue);
    }

    private static boolean check(int r, int c){
        int b = 0;
        int w = 0;
        for(int i = r; i<r+divide; i++){
            for(int j = c; j<c+divide; j++){
                if(map[i][j] == 1){
                    b++;
                }else{
                    w++;
                }
                if(w > 0 && b > 0){
                    return false;
                }
            }
        }

        if(b > 0){
            blue++;
        }else{
            white++;
        }
        return true;
    }

    private static void beVisited(int r, int c){
        for(int i = r; i<r+divide; i++){
            for(int j = c; j<c+divide; j++){
                visited[i][j] = 1;
            }
        }
    }
}