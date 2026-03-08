#include <stdio.h>

int main()
{
    long long a, b, c;
    
    scanf("%Ld %Ld %Ld", &a, &b, &c);
    
    if (c - b <= 0)
    {
        printf("-1\n");
        return 0;
    }
    
    
    printf("%Ld", (a / (c - b)) + 1);
    
    return 0;
}