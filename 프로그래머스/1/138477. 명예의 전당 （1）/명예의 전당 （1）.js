function solution(k, score) {
    var answer = [];
    var temp = [];
    for(let i = 0; i<score.length; i++){
        temp.push(score[i]);
        temp.sort((a, b) => (a - b));
        if(temp.length > k){
            temp.shift();
        }
        
        answer.push(temp[0]);
    }
    
    return answer;
}