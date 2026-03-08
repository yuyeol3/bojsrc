#include <cstdio>
#include <algorithm>
#define N 9
using namespace std;

void print_heights(const int *arr, int ex_i, int ex_j)
{
    for (int i = 0; i < N; i++)
    {
        if (i != ex_i && i != ex_j)
            printf("%d\n", arr[i]);
    }
}

int main()
{
    int heights[N], tot = 0;

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &heights[i]);
        tot += heights[i];
    }
    sort(heights, heights + N);

    for (int i = 0; i < N - 1; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            if (tot - heights[i] - heights[j] == 100)
            {
                print_heights(heights, i, j);
                return 0;
            }
        }
    }

    return 1;
}