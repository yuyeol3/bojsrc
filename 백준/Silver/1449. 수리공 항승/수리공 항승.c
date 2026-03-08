#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*((int *)a) > *((int *)b));
}

int main(void)
{
    int n, l;
    scanf("%d %d", &n, &l);

    int arr[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);    
    qsort(arr, n, sizeof(int), compare);

    int count = 0, coverableLim = 0;

    for (int i = 0; i < n; i++)
    {
        if (arr[i] > coverableLim)
        {
            count++;
            coverableLim = arr[i] + l - 1;
        }
    }

    printf("%d\n", count);
    return 0;
}