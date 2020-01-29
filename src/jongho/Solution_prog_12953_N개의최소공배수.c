#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int solution(int arr[], size_t arr_len) {
    int answer = rec_lcm(arr[0],arr[1]);
    for(int i=2; i<arr_len; i++){
        answer=rec_lcm(arr[i],answer);
    }    
    return answer;
}

int rec_gcd(int x, int y){
    if(y==0) return x;
    else return rec_gcd(y,x%y);
}

int rec_lcm(int x, int y){
    return x*y/rec_gcd(x,y);
}