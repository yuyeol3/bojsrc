#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct _member {
    int age;
    char name[101];
} Member;

void msort(Member *arr, int len)
{
    if (len <= 1) {return;}

    int mid = len / 2;
    int g1_size = mid;
    int g2_size = len - mid;

    Member g1[g1_size], g2[g2_size];

    memcpy(g1, arr, sizeof(Member) * g1_size);
    memcpy(g2, arr + g1_size, sizeof(Member) * g2_size);

    msort(g1, g1_size);
    msort(g2, g2_size);

    int i1, i2, ia;
    i1 = i2 = ia = 0;

    while (i1 < g1_size && i2 < g2_size)
    {
        if (g1[i1].age <= g2[i2].age)
        {
            arr[ia++] = g1[i1++]; 
        }
        else
        {
            arr[ia++] = g2[i2++];
        }
    }

    while (i1 < g1_size)
    {
        arr[ia++] = g1[i1++];
    }
    while (i2 < g2_size)
    {
        arr[ia++] = g2[i2++];
    }

}

int main()
{
    int n;
    scanf("%d", &n);

    Member members[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d %s", &members[i].age, members[i].name);
    }

    msort(members, n);

    for (int i = 0; i < n; i++)
    {
        printf("%d %s\n", members[i].age, members[i].name);
    }


    return 0;
}