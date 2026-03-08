#include <stdio.h>

int main()
{
    int arr[10] = {0}, remainder[49] = {0}, total = 0;
    
    
    for (int i = 0; i < 10; i++)
    {
        scanf("%d", &arr[i]);
        remainder[arr[i] % 42]++;
    }
    
    for (int i = 0; i < 49; i++)
    {
        if (remainder[i] > 0)
        {
            total++;
        }
    }
    
    printf("%d", total);
    
    return 0;
}