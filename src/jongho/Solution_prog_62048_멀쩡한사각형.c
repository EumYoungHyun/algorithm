#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
int rec_gcd(int x, int y){
    if(y==0) return x;
    return rec_gcd(y,x%y);
}

long long solution(long long w, long long h) {
    return w*h-(w+h-rec_gcd((int)w,(int)h));
}
