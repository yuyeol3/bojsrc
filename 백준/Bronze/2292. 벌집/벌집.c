#include <stdio.h>

int main()
{
    long n;
    int start = 1, end = 1, count = 1;
    
    scanf("%ld", &n);
    
    while (start > n || end < n)
    {
        start = end + 1;
        end = end + 6 * count;
        count++;
    }
    
    printf("%d\n", count);
    
    return 0;
}