#include <stdio.h>

int gcd(int x, int y)
{   
    int tmp;
    while (y)
    {
        tmp = x % y;
        x = y;
        y = tmp;
    }

    return x;
}

int lcm(int x, int y)
{
    return (x * y) / gcd(x, y);
}

int main()
{
    int t, x, y;
    scanf("%d", &t);

    for (int i = 0; i < t; i++)
    {
        scanf("%d %d", &x, &y);
        printf("%d\n", lcm(x, y));
    }


    return 0;
}