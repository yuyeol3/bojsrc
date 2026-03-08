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
    int n;
    int numOfprime = 0;
    
    scanf("%d", &n);
    int numbers[n];
    
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &numbers[i]);
    }
    
    for (int i = 0; i < n; i++)
    {
        if (isPrime(numbers[i]))
        {
            numOfprime++;
        }
    }
    
    printf("%d\n", numOfprime);
    
    return 0;
}
