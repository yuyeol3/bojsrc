#include <stdio.h>

int prime_check(int num)
{
    int is_prime = 1;

    for (int i = 2; i < num; i++)
    {
        if (num % i == 0)
        {
            is_prime = 0;
            break;
        }
    }

    return is_prime;
}

int main()
{
    int t, n;

    scanf("%d", &t);

    for (int i = 0; i < t; i++)
    {
        int subtracted, answer[2];
        scanf("%d", &n);
        for (int i = n / 2; i > 1; i--)
        {
            subtracted = n - i;
            if (prime_check(i) && prime_check(subtracted))
            {
                answer[0] = i;
                answer[1] = subtracted;
                break;
            }
        }

        printf("%d %d\n", answer[0], answer[1]);
    }

}