#include <stdio.h>

int count(int *arr, int x)
{
    int cnt = 0;
    for (int i = 0; i < 3; i++)
    {
        if (arr[i] == x)
            cnt++;
    }

    return cnt;
}

int main()
{
    int coordinate_x[3], coordinate_y[3];

    int x, y;
    for (int i = 0; i < 3; i++)
    {
        scanf("%d %d", &x, &y);
        coordinate_x[i] = x;
        coordinate_y[i] = y;
    }

    int omitted_x, omitted_y;

    for (int i = 0; i < 3; i++)
    {
        if (count(coordinate_x, coordinate_x[i]) <= 1)
        {
            omitted_x = coordinate_x[i];
            break;
        }
    }

    for (int i = 0; i < 3; i++)
    {
        if (count(coordinate_y, coordinate_y[i]) <= 1)
        {
            omitted_y = coordinate_y[i];
            break;
        }
    }

    printf("%d %d\n", omitted_x, omitted_y);

    return 0;
}