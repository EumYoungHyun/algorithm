#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int s[100001] = {0};
int solution(int n) {
    s[0]=0; s[1]=1;
    return fibo(n);
}

int fibo(int n){
    if(n==0 || s[n]!=0) return s[n];
    else if(n!=0 && s[n]==0) s[n] = (fibo(n-1)+fibo(n-2))%1234567;
} 
