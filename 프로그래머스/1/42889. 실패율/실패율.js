function solution(N, stages) {
    var arr = new Array(N+1);
    for(let i = 0; i<N+1; i++){
        arr[i] = new Array(4);
        arr[i].fill(0);
    }
    
    var len = stages.length;
    var clearAll = 0;
    for(let i = 0; i<len; i++){
        var num = stages[i];
        if(num > N) {
            clearAll++;
        }else{
            arr[num][0]++;
        }
    }
    
    let num2 = clearAll;
    for(let i = N; i>0; i--){
        num2 += arr[i][0];
        arr[i][1] += num2;
    }
    
    for(let i = 1; i<N+1; i++){
        arr[i][3] = i;
        arr[i][2] = arr[i][0] / arr[i][1];
    }
    
    arr.sort((a, b) => b[2] - a[2]);
    
    var ans = []
    for(let i = 0; i<N+1; i++){
        if(arr[i][3] != 0){
            ans.push(arr[i][3]);
        }
    }
    
    return(ans);
}