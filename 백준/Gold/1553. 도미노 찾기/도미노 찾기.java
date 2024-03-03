import java.util.*;
import java.io.*;
public class Main {

    static int  map[][], visited[][], dominoes[][], used[][], cnt;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int [8][7]; // 끝까지 도달했을 때, 같은지 확인할 원본
        used = new int [8][7]; // map과 비교할 실제로 숫자가 들어가있는 격자
        visited = new int [9][8]; // 빈 격자에 어느 자리가 사용중인지.
        dominoes = new int [28][3]; // 28가지의 도미노, 0, 1은 해당숫자 2는 사용여부
        cnt = 0;
        for(int i = 0; i<8; i++){
            String str = br.readLine();
            for(int j = 0; j<7; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int num0 = 0;
        int num1 = 0;
        for(int i = 0; i<28; i++){
            dominoes[i][0] = num0;
            dominoes[i][1] = num1++;
            if(num1 == 7){
                num0 += 1;
                num1 = num0;
            }
        }

        for(int i = 0; i<9; i++){
            visited[i][7] = 1;
        }
        for(int i = 0; i<8; i++){
            visited[8][i] = 1;
        }


        recur(0, 0);
        System.out.println(cnt);

    }

    static void recur(int x, int y){
        if(y == 9 && x == 0){
            int flag = 1;
            outer:
            for(int i = 0; i<8; i++){
                for(int j = 0; j<7; j++){
                    if(map[i][j] != used[i][j]){
                        flag = 0;
                        break outer;
                    }
                }
            }

            if(flag == 1){
                cnt++;
                }
            return;
        }
        //지금 내가 있는 장소가 이미 사용중이라면 다음칸으로 이동한다.
        if(visited[y][x] == 1){
            x++;
            if(x >= 7){
                x = 0;
                y++;
                recur(x, y);
            }else{
                recur(x, y);
            }
            return;
        }

        //지금 내가 있는 장소가 사용중이 아니라면,,,
        for(int i = 0; i<28; i++){
            if(dominoes[i][2] == 1) continue;
            //가로로 2칸 잡아먹기
            if(visited[y][x] == 0 && visited[y][x+1] == 0){
                //0, 1 순서로 사용하기
                used[y][x] = dominoes[i][0];
                used[y][x+1] = dominoes[i][1];
                if(used[y][x] == map[y][x] && used[y][x+1] == map[y][x+1]) {
                    visited[y][x] = 1;
                    visited[y][x + 1] = 1;
                    dominoes[i][2] = 1;
                    recur(x + 2, y);
                    dominoes[i][2] = 0;
                    visited[y][x] = 0;
                    visited[y][x + 1] = 0;
                }
                //1, 0 순서로 사용하기
                if(dominoes[i][0] != dominoes[i][1]) {  // 중복은 제거해준다.
                    used[y][x] = dominoes[i][1];
                    used[y][x + 1] = dominoes[i][0];
                    if (used[y][x] == map[y][x] && used[y][x + 1] == map[y][x + 1]) {
                        visited[y][x] = 1;
                        visited[y][x + 1] = 1;
                        dominoes[i][2] = 1;
                        recur(x + 2, y);
                        dominoes[i][2] = 0;
                        visited[y][x] = 0;
                        visited[y][x + 1] = 0;
                    }
                }
            }

            //세로로 2칸 잡아먹기
            if(visited[y][x] == 0 && visited[y+1][x] == 0){
                //0, 1 순서로 사용하기
                used[y][x] = dominoes[i][0];
                used[y+1][x] = dominoes[i][1];
                if(used[y][x] == map[y][x] && used[y+1][x] == map[y+1][x]) {
                    visited[y][x] = 1;
                    visited[y+1][x] = 1;
                    dominoes[i][2] = 1;
                    recur(x+1, y);
                    dominoes[i][2] = 0;
                    visited[y][x] = 0;
                    visited[y+1][x] = 0;
                }
                //1, 0 순서로 사용하기
                if(dominoes[i][0] != dominoes[i][1]){   // 중복은 제거해준다
                    used[y][x] = dominoes[i][1];
                    used[y+1][x] = dominoes[i][0];
                    if(used[y][x] == map[y][x] && used[y+1][x] == map[y+1][x]) {
                        visited[y][x] = 1;
                        visited[y + 1][x] = 1;
                        dominoes[i][2] = 1;
                        recur(x + 1, y);
                        dominoes[i][2] = 0;
                        visited[y][x] = 0;
                        visited[y + 1][x] = 0;
                    }
                }
            }
        }
    }
}