#include <stdio.h>

int isPrime(int num)
{
    if (num <= 1)
    {
        return 0;
    }
    
    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
        {
            return 0;
        }
    }
    
    return 1;
}

int main()
{
    int m, n;
    scanf("%d %d", &m, &n);

    int summation = 0, minPrime;

    for (int i = m; i <= n; i++)
    {
        if (isPrime(i))
        {
            if (summation == 0)
            {
                minPrime = i;
            }

            summation += i;
        }
    }

    if (summation > 0)
        printf("%d\n%d\n", summation, minPrime);
    else
        printf("-1\n");

    return 0;
}
