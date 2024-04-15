function solution(k, m, score) {
    var answer = 0;
    
    score.sort();
    while(score.length >= m){
        for(let i = 0; i<m-1; i++){
            score.pop();
        }
        var num = score.pop();
        answer += num * m;
    }
    
    return answer;
} 
    