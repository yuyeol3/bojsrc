#include <stdio.h>

typedef struct _psys {
    int x;
    int y;
    int r;
} PlanetSys;

int isin(PlanetSys *self, int x, int y)
{
    return (x - self->x) * (x - self->x) + (y - self->y) * (y - self->y) < self->r * self->r;
}

int main()
{
    int T;

    scanf("%d", &T);

    for (int i = 0; i < T; i++)
    {
        int start[2];
        int end[2];

        scanf("%d %d %d %d", &start[0], &start[1], &end[0], &end[1]);

        int n;
        scanf("%d", &n);

        PlanetSys psys_l[n];
        for (int j = 0; j < n; j++)
        {
            scanf("%d %d %d", &psys_l[j].x, &psys_l[j].y, &psys_l[j].r);
        }

        int cnt = 0;
        for (int j = 0; j < n; j++)
        {
            if (isin(&psys_l[j], start[0], start[1]) && isin(&psys_l[j], end[0], end[1])) {}
            else if (isin(&psys_l[j], start[0], start[1]))
            {
                cnt++;
            }
            else if (isin(&psys_l[j], end[0], end[1]))
            {
                cnt++;
            }
            
        }

        printf("%d\n", cnt);
    }

    return 0;
}