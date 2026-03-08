#include <stdio.h>

int gcd(int x, int y)
{
    // gcd(x , y) == gcd(y, x % y)
    int tmp;
    while (y)
    {
        tmp = x;
        x = y;
        y = tmp % y;
    }
    return x;
}

int lcm(int x, int y)
{
    return (x * y) / gcd(x, y);
}

int main()
{
    int x, y;

    scanf("%d %d", &x, &y);
    printf("%d\n%d\n", gcd(x, y), lcm(x, y));

    return 0;
}