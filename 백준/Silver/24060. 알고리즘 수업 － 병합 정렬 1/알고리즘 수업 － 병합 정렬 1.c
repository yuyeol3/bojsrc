#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct _node {
    int n;
    struct _node *next;
} Node;

Node *HEAD = NULL;
Node *TAIL = NULL;
int LEN = 0;

void list_add(int n)
{
    Node *cur = (Node *) malloc(sizeof(Node));
    cur->next = NULL;
    cur->n = n;

    if (HEAD == NULL)
        HEAD = cur;
    
    if (TAIL != NULL)
        TAIL->next = cur;
    
    TAIL = cur;
    LEN++;
}

void merge_sort(int *arr, int st, int ed);
void merge(int *arr, int st, int mid, int ed);

void print_arr(int *arr, int n)
{
    printf("[");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("]\n");
}

void merge_sort(int *arr, int st, int ed)
{
    if (st < ed)
    {
        int mid = (st + ed) / 2;
        merge_sort(arr, st, mid);
        merge_sort(arr, mid + 1, ed);
        merge(arr, st, mid, ed);
        // print_arr(arr, 5);
    }
}

void merge(int *arr, int st, int mid, int ed)
{
    int bf = mid - st + 1;
    int af = ed - mid;
    int g1[bf], g2[af];
    memcpy(g1, (arr + st), sizeof(int) * bf);
    memcpy(g2, (arr + st) + (mid-st) + 1, sizeof(int) * af);
    int tmp[ed - st + 1];

    int i1 = 0, i2 = 0, it = 0;
    while ((i1 < bf) && (i2 < af))
    {
        if (g1[i1] < g2[i2])
        {
            tmp[it++] = g1[i1++];
        }
        else
        {
            tmp[it++] = g2[i2++];
        }
    }

    while (i1 < bf)
    {
        tmp[it++] = g1[i1++];
    }

    while (i2 < af)
    {
        tmp[it++] = g2[i2++];
    }

    it = 0;
    for (int i = st; i < ed + 1; i++)
    {
        arr[i] = tmp[it];
        list_add(tmp[it]);
        it++;
    }
}


int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    int arr[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    merge_sort(arr, 0, n - 1);

    Node *cur = HEAD;
    int idx = 1;
    while ((cur != NULL) && (idx < k))
    {
        idx++;
        cur = cur->next;
    }

    if (cur == NULL)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", cur->n);
    }

    return 0;
}