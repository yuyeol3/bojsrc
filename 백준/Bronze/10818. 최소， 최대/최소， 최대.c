#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, min, max, *arr;
    
    scanf("%d", &n);
    arr = (int*) malloc(sizeof(int) * n);
    
    for (int i = 0; i < n; i++) // 배열 값 입력받기
    {
        scanf("%d", &arr[i]);
    }
    
    min = arr[0];
    max = arr[0];
    
    for (int i = 0; i < n; i++)
    {
        if (arr[i] < min)
        {
            min = arr[i];
        }
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    
    printf("%d %d\n", min, max);
    
    return 0;
}