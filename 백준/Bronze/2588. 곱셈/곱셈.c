#include <stdio.h>
#include <math.h>

int charToNum(char *c, int len)
{
    int result = 0;
    
    for (int i =0; i < len; i++)
    {
        result += (c[i] - '0') * (int) pow(10.0, (float)(len - i - 1));
    }
    
    return result;
}

int main(void)
{
    char a[4], b[4], b_sep[4];
        
    scanf("%s", a);
    scanf("%s", b);

    for (int i = 2; i >= 0; i--)
    {
        b_sep[2-i] = b[i];
    }

    for (int i = 0; i < 3; i++)
    {
        printf("%d\n", charToNum(a, 3) * charToNum(&b_sep[i], 1));
    }
    
    printf("%d", charToNum(a, 3) * charToNum(b, 3));
    
    return 0;
}