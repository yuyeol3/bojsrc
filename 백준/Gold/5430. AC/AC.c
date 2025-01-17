#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>


void print_arr(int *arr, int n, bool is_reversed)
{
    printf("[");

    if (is_reversed)
    {
        for (int i = n - 1; i >= 0; i--)
        {
            printf("%d", arr[i]);

            if (i != 0)
            {
                printf(",");
            }
        }
    }
    else
    {
        for (int i = 0; i < n; i++)
        {
            printf("%d", arr[i]);

            if (i != n - 1)
            {
                printf(",");
            }
        }
    }
    printf("]\n");
}

void get_num(char *str, int *arr, int n)
{
    char *temp;
    int idx = 0;
    temp = strtok(str, ",");
    while (1)
    {
        if (strchr(temp, '[') != NULL)
        {   
            temp = temp + 1;
        }

        arr[idx++] = atoi(temp);
        temp = strtok(NULL, ",");

        if (temp == NULL)
            break;
    }
}

int count_d(char *p)
{
    int num = 0;
    for (int i = 0; i < strlen(p); i++)
    {
        if (p[i] == 'D')
            num++;
    }

    return num;
}

int main()
{
    int T;

    scanf("%d", &T);
    char p[100001];
    int n;
    int *arr;
    bool is_error;
    bool is_reversed;

    for (int i = 0; i < T; i++)
    {
        scanf("%s", p);

        scanf("%d", &n);
        arr = (int *) malloc(sizeof(int) * n);
        char str[4*n + 2];
        is_error = false;
        is_reversed = false;
        scanf("%s", str);
        get_num(str, arr, n);

        if (n < count_d(p))
        {
            is_error = true;
        }
        else
        {
            for (int i = 0; i < strlen(p); i++)
            {   
                if (p[i] == 'R')
                {
                    // reverse(arr, n);
                    is_reversed = !is_reversed;
                }
                else
                {

                    if (!is_reversed)
                    {
                        arr += 1;
                        n--;
                    }
                    else
                    {
                        n--;
                    }

                }
            }
        }


        if (is_error)
        {
            printf("error\n");
        }
        else
        {
            print_arr(arr, n, is_reversed);
        }
    }
    free(arr);
    return 0;
}