#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int combination(int n, int m)
{
    int und = 1, upp = 1;
    for (int i = 2; i <= m; i++)
    {
        und *= i;
    }

    for (int i = 0; i < m; i++)
    {
        upp *= (n - i);
    }

    return upp / und;
}

int main()
{
    int n, m;
    int *cards, *possible_sums;

    scanf("%d %d", &n, &m);
    cards = (int *) malloc(sizeof(int) * n);
    possible_sums = (int *) malloc(sizeof(int) * combination(n, 3));

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &cards[i]);
    }

    int temp, idx = 0;
    for (int i = 0; i < n - 2; i++)
    {
        for (int j = i + 1; j < n - 1; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                temp = cards[i] + cards[j] + cards[k];
                possible_sums[idx++] = temp;
            }
        }
    }

    int last_max = 0;
    for (int i = 0; i < idx; i++)
    {
        if ((last_max < possible_sums[i]) && (possible_sums[i] <= m))
        {
            last_max = possible_sums[i];
        } 
    }

    printf("%d\n", last_max);

    return 0;
}