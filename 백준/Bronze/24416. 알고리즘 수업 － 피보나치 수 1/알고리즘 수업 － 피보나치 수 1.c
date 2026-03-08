#include <stdio.h>
#include <stdlib.h>

typedef struct _li {
    int element;
    struct _li *next;
    struct _li *prev;
} List;


List *head;
List *tail;
int DPCount, RecCount;

void ListAdd(int element)
{
    List *li = (List *) malloc(sizeof(List));
    li->element = element;
    li->next = NULL;
    li->prev = NULL;

    if (head == NULL)
    {
        head = li;
    }

    if (tail != NULL)
    {
        li->prev = tail;
        tail->next = li;
    }
    tail = li;

}


void ListDelete()
{
    List *ptr = head->next;
    while (ptr != NULL)
    {
        free(ptr->prev);
        ptr = ptr->next;
    }
}

int DPFibo(int n)
{
    if (n <= 1)
    {
        return n;
    }

    ListAdd(1);
    ListAdd(1);

    for (int i = 3; i < n + 1; i++)
    {
        ListAdd((tail->element) + (tail->prev->element));
        DPCount++;
    }

    return tail->element;
}

int RecFibo(int n)
{
    if (n <= 2)
    {
        RecCount++;
        return 1;
    }


    return RecFibo(n - 1) + RecFibo(n - 2); 
}

int main()
{
    head = tail = (List *) NULL;
    RecCount = DPCount = 0;
    int n;
    scanf("%d", &n);
    DPFibo(n); RecFibo(n);
    ListDelete();
    printf("%d %d\n", RecCount, DPCount);

    return 0;
}