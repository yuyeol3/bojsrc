#include <stdio.h>

int main()
{
    int arr[9], max_idx;
    
    for (int i = 0; i < 9; i++)
    {
        scanf("%d", &arr[i]);
    }
    
    max_idx = 0;
    
    for (int i = 1; i < 9; i++)
    {
        if (arr[i] > arr[max_idx])
        {
            max_idx = i;
        }
    }
    
    printf("%d\n%d", arr[max_idx], max_idx + 1);
    
    return 0;
}