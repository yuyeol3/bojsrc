#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int toint(char k)
{
    return (int) (k - '0');
}

int main(void)
{
    int n, tot=0;
    char *number;
    
    scanf("%d", &n);
    
    number = (char *) malloc(sizeof(char) * (n + 1));
    scanf("%s", number);
    
    for (int i = 0; i < strlen(number); i++)
    {
        tot += toint(number[i]);
    }
    
    printf("%d\n", tot);
    
    return 0;
}