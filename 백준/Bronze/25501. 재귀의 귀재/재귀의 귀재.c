#include <stdio.h>
#include <string.h>

// 전역변수
int *C_NUM = NULL;

int recursion(const char *s, int l, int r){
    (*C_NUM)++;
    if(l >= r) return 1;
    else if(s[l] != s[r]) return 0;
    else return recursion(s, l+1, r-1);
}

int isPalindrome(const char *s){
    return recursion(s, 0, strlen(s)-1);
}

int main(){
    int n;
    scanf("%d", &n);
    char strings[n][1001];

    // 입력받기
    for (int i = 0; i < n; i++)
    {
        scanf("%s", strings[i]);
    }

    int tmp, res;
    C_NUM = &tmp;
    for (int i = 0; i < n; i++)
    { 
        tmp = 0;
        res = isPalindrome(strings[i]);
        printf("%d %d\n", res, tmp);
    }

    return 0;
}