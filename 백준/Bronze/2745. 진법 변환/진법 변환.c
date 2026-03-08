#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#define CHAR_ZRO '0'
#define CHAR_LA  'A'

int to_base10(char *num, int base)
{
    int res = 0;
    int numLen = strlen(num);

    for (int i = 0; i < numLen; i++)
    {
        if (isdigit(num[i]))
        {
            res += (num[i] - CHAR_ZRO) * (int) pow(base, (numLen - i -1));
        }
        else
        {
            res += (num[i] - CHAR_LA + 10) * (int) pow(base, (numLen - i - 1));
        }
    }

    return res;
}

int main()
{
    char num[100];
    int digit;

    scanf("%s %d", num, &digit);

    printf("%d\n", to_base10(num, digit));

    return 0;
}