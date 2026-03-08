#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int start, end, target;
    int *primes;
    int is_prime, cur_idx;
    int prime_n;

    while (1)
    {
        scanf("%d", &start);

        if (start == 0)
        {
            break;
        }

        end = start * 2;
        target = (int) sqrt(end);
        primes = (int *) malloc(sizeof(int) * (target + 1));
        cur_idx = 0;


        for (int i = 2; i < target + 1; i++)
        {
            is_prime = 1;

            if ((i != 2) && (i % 2 == 0))
                is_prime = 0;

            else
            {
                for (int j = 3; j < i; j += 2)
                {
                    if (i % j == 0)
                    {
                        is_prime = 0;
                        break;
                    }
                }
            }

            if (is_prime)
            {
                primes[cur_idx] = i;
                cur_idx++;
            }
        }

        prime_n = 0;

        for (int i = start + 1; i < end + 1; i++)
        {
            is_prime = 1;

            for (int j = 0; j < cur_idx; j++)
            {
                if (i % primes[j] == 0)
                {
                    is_prime = 0;
                    break;
                }
            }

            if (is_prime)
            {
                prime_n++;
            }
        }

        printf("%d\n", prime_n);

    }

    

    return 0;
}