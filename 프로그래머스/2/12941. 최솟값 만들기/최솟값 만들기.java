import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = 0;
        int idxB = B.length - 1;
        
        while(idxA < A.length){
            answer += A[idxA++] * B[idxB--];
        }

        return answer;
    }
}