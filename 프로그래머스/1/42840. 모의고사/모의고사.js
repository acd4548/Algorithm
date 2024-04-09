function solution(answers) {
    var answer = [];
    var max = -1;
    
    var correct = [0, 0, 0];
    var first = [1, 2, 3, 4, 5];
    var seceond = [2, 1, 2, 3, 2, 4, 2, 5];
    var third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    for(let i = 0; i<answers.length; i++){
        if(answers[i] == first[i%first.length]) correct[0]++;
        if(answers[i] == seceond[i%seceond.length]) correct[1]++;
        if(answers[i] == third[i%third.length]) correct[2]++;
    }
    

    for(let i = 0; i<3; i++){
        max = Math.max(max, correct[i]);
    }
    
    for(let i = 0; i<3; i++){
        if(correct[i] == max){
            answer.push(i+1);
        }
    }
    return answer;
}