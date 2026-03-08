#include <stdio.h>
#include <stdlib.h>

int findMax(float * array, int len)
{
    float max = array[0];
    
    for (int i = 1; i < len; i++)
    {
        if (array[i] > max)
        {
            max = array[i];
        }
    }
    
    return max;
}

void meanManipulate(float * array, int max, int len)
{
    
    for (int i = 0; i < len; i++)
    {
        *(array + i) = (array[i] / max) * 100;
    }
}

float getMean(float * array, int len)
{
    float tot = 0;
    
    for (int i = 0; i < len; i++)
    {
        tot += array[i];
    }
    
    return tot / (float) len;
    
}


int main(void)
{
    int n, max;
    float * arr, mean;
    
    scanf("%d", &n);
    arr = (float*) malloc(sizeof(float) * n);
    

    for (int i = 0; i < n; i++)
    {
        scanf("%f", &arr[i]);
    }
    
    max = findMax(arr, n);
    meanManipulate(arr, max, n);
    mean = getMean(arr, n);
    
    printf("%f\n", mean);

    free(arr);
    
    return 0;
}