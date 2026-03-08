#include <stdio.h>
#include <string.h>

void reverse(char k[])
{
    char tmp[4];
    
    strcpy(tmp, k);
    
    for (int i = 2; i >= 0; i--)
    {
        k[2-i] = tmp[i];
    }
    
}


int main()
{
    char a[4], b[4];
    int num_a, num_b;
    scanf("%s %s", a, b);
    
    reverse(a);
    reverse(b);
    
    num_a = atoi(a);
    num_b = atoi(b);
    
    
    printf("%d", num_a > num_b ? num_a : num_b);
    
    
    return 0;
}