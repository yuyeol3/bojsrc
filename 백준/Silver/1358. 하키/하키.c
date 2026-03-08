#include <stdio.h>
#include <stdlib.h>

#define FIGURE(t) int (*isin)(t self, int *other)

typedef struct _rectangle {
    int x, y, w, h;
    FIGURE(struct _rectangle);
} Rectangle;

typedef struct _circle {
    int x, y, r;
    FIGURE(struct _circle);
} Circle;

int rect_isin(Rectangle self, int *other)
{
    int cond_1 = ((self.x <= other[0]) && (other[0] <= self.x + self.w));
    int cond_2 = ((self.y <= other[1]) && (other[1] <= self.y + self.h));
    
    return (cond_1 && cond_2);
}

int circle_isin(Circle self, int *other)
{
    return (self.x - other[0]) * (self.x - other[0]) + (self.y - other[1]) * (self.y - other[1]) <= self.r * self.r;
}

int main()
{
    int w, h, x, y, p;
    scanf("%d %d %d %d %d", &w, &h, &x, &y, &p);
    int r =  h / 2;

    Circle circle_l = {x, y + r, r, &circle_isin};
    Circle circle_r = {x + w, y + r, r, &circle_isin};
    Rectangle rect = {x, y, w, h, &rect_isin};

    int cnt = 0, athlete[2];

    for (int i = 0; i < p; i++)
    {
        scanf("%d %d", athlete, athlete + 1);

        if (athlete[0] < x)
        {
            cnt += circle_l.isin(circle_l, athlete);
        }
        else if (athlete[0] <= x + w)
        {
            cnt += rect.isin(rect, athlete);
        }
        else
        {
            cnt += circle_r.isin(circle_r, athlete);
        }
    }

    printf("%d\n", cnt);

    return 0;
}