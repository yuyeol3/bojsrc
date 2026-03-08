#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void dfs(int **ability, int n,
         int *minimum, int reg_n, int *st_team, int *visited)
{

    if (reg_n == (n / 2))
    {

        int lk_team[n / 2], lk_idx = 0;

        for (int i = 0; i < n; i++)
        {
            int unincluded = 1;
            for (int j = 0; j < n / 2; j++)
            {
                if (i == st_team[j])
                {
                    unincluded = 0;
                    break;
                }
            }

            if (unincluded)
            {
                lk_team[lk_idx++] = i;
            }
        }

        // printf("st_team: ");
        // for (int i = 0; i < n / 2; i++)
        // {
        //     printf("%d ", st_team[i]);
        // }
        // printf("\n");

        // printf("lk_team: ");
        // for (int i = 0; i < n / 2; i++)
        // {
        //     printf("%d ", lk_team[i]);
        // }
        // printf("\n");


        int st_ab, lk_ab;
        st_ab = lk_ab = 0;

        for (int i = 0; i < (n / 2) - 1; i++)
        {
            for (int j = i + 1; j < n / 2; j++)
            {
                st_ab += ability[st_team[i]][st_team[j]] + ability[st_team[j]][st_team[i]];
                lk_ab += ability[lk_team[i]][lk_team[j]] + ability[lk_team[j]][lk_team[i]];
            }
        }

        if (abs(st_ab - lk_ab) < *minimum)
        {
            *minimum = abs(st_ab - lk_ab);
        }

    }


    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            visited[i] = 1;
            int *new_visited = (int *) malloc(sizeof(int) *n);
            memcpy(new_visited, visited, n * sizeof(int));
            st_team[reg_n] = i;
            dfs(ability, n, minimum, reg_n + 1, st_team, new_visited);
            free(new_visited);
            st_team[reg_n] = 0;
        }
    }
}

int main(void)
{
    // 인원수 입력받기
    int n;
    scanf("%d", &n);

    // 능력치 조합 입력받기
    int **ability = (int **) malloc(sizeof(int *) * n);
    for (int i = 0; i < n; i++)
    {
        ability[i] = (int *) malloc(sizeof(int) *n);
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &ability[i][j]);
        }
    }


    int *st_team = (int *) calloc((size_t) n / 2, sizeof(int));
    int minimum = 100 * 100 * 100;
    int *visited = (int *) calloc((size_t) n, sizeof(int));

    dfs(ability, n, &minimum, 0, st_team, visited);
    printf("%d\n", minimum);

    // 할당 해제
    //free(st_team);
    //free(visited);
    for (int i = 0; i < n; i++)
    {
        free(ability[i]);
    }
    free(ability);

    return 0;
}