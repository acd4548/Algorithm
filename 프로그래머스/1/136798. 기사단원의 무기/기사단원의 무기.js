function solution(number, limit, power) {
    var answer = 0;
    
    for(let i = 1; i<=number; i++){
        var temp = cal(i);
        if(temp > limit){
            answer += power;
        }else{
            answer += temp;
        }
    }
    
    return answer;
}

//약수의 개수를 구하는 함수
function cal(number){
    var cnt = 0;
    for(let i = 1; i*i<=number; i++){
        if(i * i === number){
            cnt++;
        }else if(number % i === 0){
            cnt += 2;
        }
    }
    
    return cnt;
}