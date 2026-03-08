#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct _node {
    int key;
    struct _node *next;
} Node;

typedef struct _bucket {
    Node *head;
    int count;
} Bucket;

Bucket *hash_table = NULL;
int BUCKET_SIZE = 1;

Node *create_node(int key)
{
    Node *new_node = (Node *) malloc(sizeof(Node));

    new_node->key = key;
    new_node->next = NULL;

    return new_node;
}

int hash_func(int key)
{
    // printf("%d\n", BUCKET_SIZE);
    return abs(key % BUCKET_SIZE);
}

int add(int key)
{
    Node *new_node = create_node(key);
    int hash_idx = hash_func(key);

    if (hash_table[hash_idx].count == 0)
    {
        hash_table[hash_idx].head = new_node;
        hash_table[hash_idx].count = 1;
    }
    else
    {
        new_node->next = hash_table[hash_idx].head;
        hash_table[hash_idx].head = new_node;
        hash_table[hash_idx].count++;
    }

}

int search(int key)
{
    int hash_idx = hash_func(key);
    int find_result = 0;

    Node *node = hash_table[hash_idx].head;

    while (node != NULL)
    {
        if (node->key == key)
        {
            find_result = 1;
            break;
        }
        node = node->next;
    }

    return find_result;
}

int main()
{
    int n, m;
    
    scanf("%d", &n);

    BUCKET_SIZE = n;
    hash_table = (Bucket *) malloc (n * sizeof(Bucket));

    for (int i = 0; i < n; i++)
    {
        hash_table[i].head = NULL;
        hash_table[i].count = 0;
    }

    for (int i = 0; i < n; i++)
    {
        int temp;
        scanf("%d", &temp);
        add(temp);
    }

    scanf("%d", &m);

    for (int i = 0; i < m; i++)
    {
        int temp;
        scanf("%d", &temp);
        printf("%d ", search(temp));
    }
    printf("\n");
    return 0;
}