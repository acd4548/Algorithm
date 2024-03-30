function solution(numbers) {
    var answer = [];
    
    for(let i = 0; i<numbers.length-1; i++){
        for(let j = i+1; j<numbers.length; j++){
            var temp = numbers[i] + numbers[j];
            if(!answer.includes(temp)){
                answer.push(temp);
            }
        }
    }
    answer.sort((a, b) => (a - b));
    return answer;
}