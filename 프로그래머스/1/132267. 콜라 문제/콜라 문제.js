function solution(a, b, n) { // a개주면 b개받고 나지금 n개있음
    var answer = 0;
    
    while(n >= a){
        var temp = ~~(n / a);
        console.log(temp);
        answer += temp * b;
        n -= (temp * a);
        n += temp * b;
    }
    
    return answer;
}