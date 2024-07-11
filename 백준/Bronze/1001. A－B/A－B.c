#include <stdio.h>

int main(void)
{
    int k[2];
    
    scanf("%d %d", &k[0], &k[1]);
    printf("%d", k[0] - k[1]);
    
    return 0;
}