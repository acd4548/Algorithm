import java.util.*;
import java.io.*;
public class Main {
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    static int [] info = {-1, -1, -1, -1};
    static int R, C, T, map[][], clone[][], ans, visited[][];
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int [R][C];
        clone = new int [R][C];
        visited = new int [R][C];
        ans = 0;
        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(info[0] == -1){
                        info[0] = i;
                        info[1] = j;
                    }else{
                        info[2] = i;
                        info[3] = j;
                    }
                }
            }
        }

        for(int i = 1; i<T+1; i++){
            diffusion();
            clean();
            mirroring(i);
        }

        int ans = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if((i == info[0] && j == info[1]) || (i == info[2] && j == info[3])){
                    continue;
                }
                ans += clone[i][j];
            }
        }

        System.out.print(ans);
    }

    private static void diffusion(){
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                int temp = 0;
                if(map[i][j] != -1 && map[i][j] != 0){
                    temp = map[i][j];
                }else{
                    continue;
                }

                int num = temp / 5;

                for(int k = 0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if(map[nr][nc] == -1) continue;
                    clone[nr][nc] += num;
                    map[i][j] -= num;
                }
                clone[i][j] += map[i][j];
            }
        }
    }

    private static void clean(){
        int before = clone[info[0]][1];
        int temp = before;
        for(int i = 2; i<C; i++){
            before = clone[info[0]][i];
            clone[info[0]][i] = temp;
            temp = before;
        }

        for(int i = info[0] - 1; i>=0; i--){
            before = clone[i][C-1];
            clone[i][C-1] = temp;
            temp = before;
        }

        for(int i = C-2; i>=0; i--){
            before = clone[0][i];
            clone[0][i] = temp;
            temp = before;
        }

        for(int i = 1; i<=info[0] + 1; i++){
            before = clone[i][info[1]];
            clone[i][info[1]] = temp;
            temp = before;
        }

        clone[info[0]][info[1] + 1] = 0;

        before = clone[info[2]][info[3] + 1];
        temp = before;
        for(int i = 2; i<C; i++){
            before = clone[info[2]][i];
            clone[info[2]][i] = temp;
            temp = before;
        }

        for(int i = info[2] + 1; i<R; i++){
            before = clone[i][C-1];
            clone[i][C-1] = temp;
            temp = before;
        }

        for(int i = C-2; i>=0; i--){
            before = clone[R-1][i];
            clone[R-1][i] = temp;
            temp = before;
        }

        for(int i = R-2; i>info[2]; i--){
            before = clone[i][0];
            clone[i][0] = temp;
            temp = before;
        }
        clone[info[2]][info[3] + 1] = 0;
    }

    private static void mirroring(int num){
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                map[i][j] = clone[i][j];
                if(num != T){
                    clone[i][j] = 0;
                }
            }
        }

        map[info[0]][info[1]] = -1;
        map[info[2]][info[3]] = -1;
    }
}