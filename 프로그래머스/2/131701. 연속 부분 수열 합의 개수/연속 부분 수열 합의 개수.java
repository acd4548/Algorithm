import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet <Integer> s = new HashSet<>();
        for(int i = 0; i<elements.length; i++){
            int sum = 0;
            for(int j = i; j<i + elements.length; j++){
                sum += elements[j % elements.length];
                s.add(sum);
            }
        }
        return s.size();
    }
}