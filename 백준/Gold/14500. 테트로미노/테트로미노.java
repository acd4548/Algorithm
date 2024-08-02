import java.util.*;
import java.io.*;
public class Main {
    static int max, N, M, map[][];
    static int [] t1_d1_dr = {0, 0, 0, 0};
    static int [] t1_d1_dc = {0, 1, 2, 3};
    static int [] t1_d2_dr = {0, 1, 2, 3};
    static int [] t1_d2_dc = {0, 0, 0, 0};
    static int [] t2_d1_dr = {0, 1, 0, 1};
    static int [] t2_d1_dc = {0, 0, 1, 1};
    //
    static int [] t3_d1_dr = {0, 1, 2, 2};
    static int [] t3_d1_dc = {0, 0, 0, 1};
    static int [] t3_d2_dr = {0, 0, 0, -1};
    static int [] t3_d2_dc = {0, 1, 2, 2};
    static int [] t3_d3_dr = {0, -1, -2, -2};
    static int [] t3_d3_dc = {0, 0, 0, -1};
    static int [] t3_d4_dr = {0, 0, 0, 1};
    static int [] t3_d4_dc = {0, -1, -2, -2};
    static int [] t3_d5_dr = {0, 1, 2, 2};
    static int [] t3_d5_dc = {0, 0, 0, -1};
    static int [] t3_d6_dr = {0, 0, 0, 1};
    static int [] t3_d6_dc = {0, 1, 2, 2};
    static int [] t3_d7_dr = {0, -1, -2, -2};
    static int [] t3_d7_dc = {0, 0, 0, 1};
    static int [] t3_d8_dr = {0, 0, 0, -1};
    static int [] t3_d8_dc = {0, -1, -2, -2};
    static int [] t4_d1_dr = {0, 1, 1, 2};
    static int [] t4_d1_dc = {0, 0, 1, 1};
    static int [] t4_d2_dr = {0, 0, -1, -1};
    static int [] t4_d2_dc = {0, 1, 1, 2};
    static int [] t4_d5_dr = {0, 1, 1, 2};
    static int [] t4_d5_dc = {0, 0, -1, -1};
    static int [] t4_d6_dr = {0, 0, 1, 1};
    static int [] t4_d6_dc = {0, 1, 1, 2};
    static int [] t5_d1_dr = {0, 0, 0, 1};
    static int [] t5_d1_dc = {0, 1, 2, 1};
    static int [] t5_d2_dr = {0, -1, -2, -1};
    static int [] t5_d2_dc = {0, 0, 0, 1};
    static int [] t5_d3_dr = {0, 0, 0, -1};
    static int [] t5_d3_dc = {0, -1, -2, -1};
    static int [] t5_d4_dr = {0, 1, 2, 1};
    static int [] t5_d4_dc = {0, 0, 0, -1};
    public static void main (String [] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check_t1_d1();
        check_t1_d2();
        check_t2_d1();
        check_t3_d1();
        check_t3_d2();
        check_t3_d3();
        check_t3_d4();
        check_t3_d5();
        check_t3_d6();
        check_t3_d7();
        check_t3_d8();
        check_t4_d1();
        check_t4_d2();
        check_t4_d5();
        check_t4_d6();
        check_t5_d1();
        check_t5_d2();
        check_t5_d3();
        check_t5_d4();

        System.out.print(max);
    }

    static void check_t1_d1(){
        int sum, dr, dc;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M-3; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t1_d1_dr[k];
                    dc = j + t1_d1_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t1_d2(){
        int sum, dr, dc;
        for(int i = 0; i<N-3; i++){
            for(int j = 0; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t1_d2_dr[k];
                    dc = j + t1_d2_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t2_d1(){
        int sum, dr, dc;
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-1; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t2_d1_dr[k];
                    dc = j + t2_d1_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d1(){
        int sum, dr, dc;
        for(int i = 0; i<N-2; i++){
            for(int j = 0; j<M-1; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d1_dr[k];
                    dc = j + t3_d1_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d2(){
        int sum, dr, dc;
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M-2; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d2_dr[k];
                    dc = j + t3_d2_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d3(){
        int sum, dr, dc;
        for(int i = 2; i<N; i++){
            for(int j = 1; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d3_dr[k];
                    dc = j + t3_d3_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d4(){
        int sum, dr, dc;
        for(int i = 0; i<N-1; i++){
            for(int j = 2; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d4_dr[k];
                    dc = j + t3_d4_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d5(){
        int sum, dr, dc;
        for(int i = 0; i<N-2; i++){
            for(int j = 1; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d5_dr[k];
                    dc = j + t3_d5_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d6(){
        int sum, dr, dc;
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-2; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d6_dr[k];
                    dc = j + t3_d6_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d7(){
        int sum, dr, dc;
        for(int i = 2; i<N; i++){
            for(int j = 0; j<M-1; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d7_dr[k];
                    dc = j + t3_d7_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t3_d8(){
        int sum, dr, dc;
        for(int i = 1; i<N; i++){
            for(int j = 2; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t3_d8_dr[k];
                    dc = j + t3_d8_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t4_d1(){
        int sum, dr, dc;
        for(int i = 0; i<N-2; i++){
            for(int j = 0; j<M-1; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t4_d1_dr[k];
                    dc = j + t4_d1_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t4_d2(){
        int sum, dr, dc;
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M-2; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t4_d2_dr[k];
                    dc = j + t4_d2_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t4_d5(){
        int sum, dr, dc;
        for(int i = 0; i<N-2; i++){
            for(int j = 1; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t4_d5_dr[k];
                    dc = j + t4_d5_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t4_d6(){
        int sum, dr, dc;
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-2; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t4_d6_dr[k];
                    dc = j + t4_d6_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t5_d1(){
        int sum, dr, dc;
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-2; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t5_d1_dr[k];
                    dc = j + t5_d1_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t5_d2(){
        int sum, dr, dc;
        for(int i = 2; i<N; i++){
            for(int j = 0; j<M-1; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t5_d2_dr[k];
                    dc = j + t5_d2_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t5_d3(){
        int sum, dr, dc;
        for(int i = 1; i<N; i++){
            for(int j = 2; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t5_d3_dr[k];
                    dc = j + t5_d3_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void check_t5_d4(){
        int sum, dr, dc;
        for(int i = 0; i<N-2; i++){
            for(int j = 1; j<M; j++){
                sum = 0;
                for(int k = 0; k<4; k++){
                    dr = i + t5_d4_dr[k];
                    dc = j + t5_d4_dc[k];
                    sum += map[dr][dc];
                }
                max = Math.max(max, sum);
            }
        }
    }
}