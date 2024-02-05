import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //A, B, C에 포함된 숫자들
        long [] arrA = new long [A];
        long [] arrB = new long [B];
        long [] arrC = new long [C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<A; i++){
            arrA[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<B; i++){
            arrB[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            arrC[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        Arrays.sort(arrC);

        //3개의 모든 배열을 하나하나 돌면서 확인하면 시간초과
        //3개의 수 중, 가장 큰수와 가장 작은 수의 차이가 제일 적은것
        //가운데 수는 가장 큰수, 가장 작은수 사이에 있어야 한다.

        long ans = Long.MAX_VALUE;
        boolean flag1 = false;
        boolean flag2 = false;
        //A배열이 가운데 일 때,
        for(int i = 0; i<A; i++){
            //B가 작고 C가 더 클 때
            int s1 = 0;
            int e1 = B-1;
            long numB = 0;
            long numC = 0;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrB[idx] > arrA[i]){
                    e1 = idx - 1;
                }else if(arrB[idx] < arrA[i]){
                    s1 = idx + 1;
                    numB = arrB[idx];
                    flag1 = true;
                }else{
                    numB = arrB[idx];
                    flag1 = true;
                    break;
                }
            }

            int s2 = 0;
            int e2 = C-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrC[idx] > arrA[i]){
                    e2 = idx - 1;
                    numC = arrC[idx];
                    flag2 = true;
                }else if(arrC[idx] < arrA[i]){
                    s2 = idx + 1;
                }else{
                    numC = arrC[idx];
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numC - numB));
            }
            //C가 작고 B가 더 클 때
            s1 = 0;
            e1 = C-1;
            numB = 0;
            numC = 0;
            flag1 = false;
            flag2 = false;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrC[idx] > arrA[i]){
                    e1 = idx - 1;
                }else if(arrC[idx] < arrA[i]){
                    s1 = idx + 1;
                    flag1 = true;
                    numC = arrC[idx];
                }else{
                    flag1 = true;
                    numC = arrC[idx];
                    break;
                }
            }

            s2 = 0;
            e2 = B-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrB[idx] > arrA[i]){
                    e2 = idx - 1;
                    flag2 = true;
                    numB = arrB[idx];
                }else if(arrB[idx] < arrA[i]){
                    s2 = idx + 1;
                }else{
                    flag2 = true;
                    numB = arrB[idx];
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numB - numC));
            }
        }

        //B배열이 가운데 일 때,
        for(int i = 0; i<B; i++){
            //A가 작고 C가 더 클 때
            int s1 = 0;
            int e1 = A-1;
            long numA = 0;
            long numC = 0;
            flag1 = false;
            flag2 = false;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrA[idx] > arrB[i]){
                    e1 = idx - 1;
                }else if(arrA[idx] < arrB[i]){
                    s1 = idx + 1;
                    numA = arrA[idx];
                    flag1 = true;
                }else{
                    numA = arrA[idx];
                    flag1 = true;
                    break;
                }
            }

            int s2 = 0;
            int e2 = C-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrC[idx] > arrB[i]){
                    e2 = idx - 1;
                    numC = arrC[idx];
                    flag2 = true;
                }else if(arrC[idx] < arrB[i]){
                    s2 = idx + 1;
                }else{
                    numC = arrC[idx];
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numC - numA));
            }


            //C가 작고 A가 더 클 때
            s1 = 0;
            e1 = C-1;
            numA = 0;
            numC = 0;
            flag1 = false;
            flag2 = false;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrC[idx] > arrB[i]){
                    e1 = idx - 1;
                }else if(arrC[idx] < arrB[i]){
                    s1 = idx + 1;
                    numC = arrC[idx];
                    flag1 = true;
                }else{
                    numC = arrC[idx];
                    flag1 = true;
                    break;
                }
            }

            s2 = 0;
            e2 = A-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrA[idx] > arrB[i]){
                    e2 = idx - 1;
                    numA = arrA[idx];
                    flag2 = true;
                }else if(arrA[idx] < arrB[i]){
                    s2 = idx + 1;
                }else{
                    numA = arrA[idx];
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numA - numC));
            }
        }

        //C배열이 가운데 일 떄,
        for(int i = 0; i<C; i++){
            //A가 작고 B가 더 클 때
            int s1 = 0;
            int e1 = A-1;
            long numA = 0;
            long numB = 0;
            flag1 = false;
            flag2 = false;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrA[idx] > arrC[i]){
                    e1 = idx - 1;
                }else if(arrA[idx] < arrC[i]){
                    s1 = idx + 1;
                    numA = arrA[idx];
                    flag1 = true;
                }else{
                    numA = arrA[idx];
                    flag1 = true;
                    break;
                }
            }

            int s2 = 0;
            int e2 = B-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrB[idx] > arrC[i]){
                    e2 = idx - 1;
                    numB = arrB[idx];
                    flag2 = true;
                }else if(arrB[idx] < arrC[i]){
                    s2 = idx + 1;
                }else{
                    numB = arrB[idx];
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numB - numA));
            }


            //B가 작고 A가 더 클 때
            s1 = 0;
            e1 = B-1;
            numA = 0;
            numB = 0;
            flag1 = false;
            flag2 = false;

            while(s1 <= e1){
                int idx = (s1 + e1) / 2;
                if(arrB[idx] > arrC[i]){
                    e1 = idx - 1;
                }else if(arrB[idx] < arrC[i]){
                    s1 = idx + 1;
                    numB = arrB[idx];
                    flag1 = true;
                }else{
                    numB = arrB[idx];
                    flag1 = true;
                    break;
                }
            }

            s2 = 0;
            e2 = A-1;
            while(s2 <= e2){
                int idx = (s2 + e2) / 2;
                if(arrA[idx] > arrC[i]){
                    e2 = idx - 1;
                    numA = arrA[idx];
                    flag2 = true;
                }else if(arrA[idx] < arrC[i]){
                    s2 = idx + 1;
                }else{
                    numA = arrA[idx];
                    flag2 = true;
                    break;
                }
            }

            if(flag1 && flag2){
                ans = Math.min(ans, Math.abs(numA - numB));
            }
        }

        System.out.println(ans);

    }
}