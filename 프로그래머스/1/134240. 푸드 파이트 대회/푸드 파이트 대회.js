function solution(food) {
    var answer = '0';
    for(var i = food.length-1; i>0; i--){
        for(var j = 0; j<~~(food[i]/2); j++){
            answer = i + answer + i;
        }
    }
    return answer;
}