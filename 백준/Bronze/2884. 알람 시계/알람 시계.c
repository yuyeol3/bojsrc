#include <stdio.h>

int main(void)
{
    int hour, minute;
    
    scanf("%d %d", &hour, &minute);
    
    int sub_m = minute;
    int sub_h = hour;
    
    sub_m = minute - 45;
    if (sub_m < 0)
    {
        sub_m = 60 + sub_m;
        sub_h = hour - 1;
        if (sub_h < 0)
        {
            sub_h = 24 - 1;
        }
    }
    
    printf("%d %d", sub_h, sub_m);
    
    return 0;
}