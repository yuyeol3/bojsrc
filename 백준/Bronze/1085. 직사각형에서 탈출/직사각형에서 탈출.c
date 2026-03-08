#include <stdio.h>

int main()
{
    int x, y, w, h;
    
    scanf("%d %d %d %d", &x, &y, &w, &h);
    
    int distances[4] = {(w - x), (h - y), x, y};

    int min_idx = 0;
    for (int i = 1; i < 4; i++)
    {
        if (distances[min_idx] > distances[i])
            min_idx = i;
    }

    printf("%d\n", distances[min_idx]);

    return 0;
}