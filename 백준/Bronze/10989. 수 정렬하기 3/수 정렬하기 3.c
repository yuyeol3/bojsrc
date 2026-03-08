#include <stdio.h>

#define MAX 10001

int main()
{
    int c_arr[MAX] = {0};
    int n;

    scanf("%d", &n);
    
    int num;
    int maximum = 0;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &num);
        c_arr[num]++;

        if (maximum < num)
        {
            maximum = num;
        }
    }

    for (int idx = 1; idx < maximum + 1; idx++)
    {
        while (c_arr[idx] > 0)
        {
            printf("%d\n", idx);
            c_arr[idx]--;
        }
    }

    return 0;
}