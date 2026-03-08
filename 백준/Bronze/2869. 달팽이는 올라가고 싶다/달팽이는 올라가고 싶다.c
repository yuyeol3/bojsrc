#include <stdio.h>

int main()
{
    long a, b, v;
    double x, cmp;
    
    scanf("%ld %ld %ld", &a, &b, &v);
    
    x = ((double) (v - b)) / ((double) (a - b));
    
    cmp = (long) x; // 비교용 변수

    if (cmp < x && x < cmp + 1)
        printf("%ld\n", (long) x + 1);
    else
        printf("%ld\n", (long) x);


    return 0;
}