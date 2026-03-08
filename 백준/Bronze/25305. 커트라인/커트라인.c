#include <stdio.h>
#include <stdlib.h>

void sort(int *arr, int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int max_idx = i, temp;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[max_idx] < arr[j])
            {
                max_idx = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[max_idx];
        arr[max_idx] = temp;
    }
}

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);

    int nums[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &nums[i]);
    }

    sort(nums, n);
    printf("%d\n", nums[k-1]);

    return 0;
}