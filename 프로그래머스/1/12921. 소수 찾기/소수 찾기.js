var arr;

function solution(n) {
    arr = new Array(n+1);
    arr.fill(0);
    return indiv(n);
}

function indiv(n){
    var cnt = 0;
    for(let i = 2; i<=n; i++){
        if(arr[i] === 0){
            cnt++;
            for(let j = i; j<=n; j+=i){
                arr[j] = 1;
            }
        }
    }
    return cnt;
}