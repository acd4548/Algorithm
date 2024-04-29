let arr = new Array(3000);

function solution(nums) {
    arr[0] = 0;
    arr[1] = 0;
    check();
    var answer = 0;
    var len = nums.length;
    for(let i = 0; i<len-2; i++){
        for(let j = i+1; j<len-1; j++){
            for(let k = j+1; k<len; k++){
                var num = nums[i] + nums[j] + nums[k];
                if(arr[num] === 1){
                    answer++;
                }
            }
        }
    }
    return answer;
}

function check() { //0 은 소수아님, 1은 소수임, undefined는 미방문
     for(let i = 2; i<=3000; i++){
         if(arr[i] === 0) continue;
         if(arr[i] === undefined){
             console.log(i);
             for(let j = i+i; j<=3000; j+=i){
                 arr[j] = 0;
             }
             arr[i] = 1;
         }
     }
}