#include <stdio.h>

int max(int *nums, int n)
{
    int max_idx = 0;

    for (int i = 0; i < n; i++)
    {
        if (nums[i] > nums[max_idx])
        {
            max_idx = i;
        }
    }

    return nums[max_idx];
}

int min(int *nums, int n)
{
    int min_idx = 0;

    for (int i = 0; i < n; i++)
    {
        if (nums[i] < nums[min_idx])
        {
            min_idx = i;
        }
    }

    return nums[min_idx];
}

int main()
{
    int n;
    scanf("%d", &n);

    int nums[n], res;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", nums + i);
    }

    res = max(nums, n) * min(nums, n);
    printf("%d\n", res);

    return 0;
}