function solution(n, m, section) {
    var answer = 0;
    var arr = new Array(n+1);
    arr.fill(0);
    for(let i = 0; i<section.length; i++){
        arr[section[i]] = 1;
    }
    
    for(let i = 1; i<arr.length; i++){
        if(arr[i] === 1){
            answer++;
            for(let j = i; j<i+m; j++){
                if(j > n){
                    return answer;
                }
                arr[j] = 0;
            }
        }
    }
    
    return answer;
}