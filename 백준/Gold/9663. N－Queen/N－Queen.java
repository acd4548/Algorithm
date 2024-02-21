import java.io.*;
import java.util.*;

public class Main {

    static int count, visited[][];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new int [N][N];
        count = 0;

        for(int i = 0; i<N ;i++) {
            visited[0][i] = 1;
            search(0,i);
            visited[0][i] = 0;
        }

        System.out.println(count);
    }

    public static void search(int c, int r) {
        if(c+1 == N) {
            count++;
            return;
        }
        for(int i = 0; i<N; i++) {
            if(isPossible(c+1,i) == 1) {
                visited[c+1][i] = 1;
                search(c+1,i);
                visited[c+1][i] = 0;
            }
        }
    }

    public static int isPossible(int c, int r) {
        for(int i = 0; i<=c; i++) {
            if(visited[i][r] == 1) {
                return 0;
            }
        }

        for(int i = c, j = r; i>=0 && j>=0; i--, j--) {
            if(visited[i][j] == 1) {
                return 0;
            }
        }

        for(int i = c, j = r; i>=0 && j<N; i--, j++) {
            if(visited[i][j] == 1) {
                return 0;
            }
        }
        return 1;
    }
}