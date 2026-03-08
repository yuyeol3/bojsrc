#include <stdio.h>
#include <stdlib.h>

int rec(int (*sudoku_template)[9], int **empty_addrs, int addrs_len, int *prev, int idx_ptr)
{
    if (idx_ptr == addrs_len)
    {
        for (int row_idx = 0; row_idx < 9; row_idx++)
        {
            for (int col_idx = 0; col_idx < 9; col_idx++)
            {
                printf("%d ", sudoku_template[row_idx][col_idx]);
            }
            printf("\n");
        }
        return 1;
    }

    int possible_nums[9] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    int *target = empty_addrs[idx_ptr], element_val;

    for (int row_idx = 0; row_idx < 9; row_idx++)
    {
        element_val = sudoku_template[row_idx][target[1]];
        if (element_val)
        {
            possible_nums[element_val - 1] = 0;
        }
    }

    for (int col_idx = 0; col_idx < 9; col_idx++)
    {
        element_val = sudoku_template[target[0]][col_idx];
        if (element_val)
        {
            possible_nums[element_val - 1] = 0;
        } 
    }

    int base_row, base_col;

    base_row = (target[0] / 3) * 3;
    base_col = (target[1] / 3) * 3;

    for (int i = base_row; i < base_row + 3; i++)
    {
        for (int j = base_col; j < base_col + 3; j++)
        {
            element_val = sudoku_template[i][j];
            if (element_val)
            {
                possible_nums[element_val - 1] = 0;
            }
        }
    }

    for (int i = 1; i < 10; i++)
    {
        if (possible_nums[i - 1])
        {
            sudoku_template[target[0]][target[1]] = i;
            if (rec(sudoku_template, empty_addrs, addrs_len, target, idx_ptr + 1))
            {
                return 1;
            }
        }
    }

    if (prev != NULL)
    {
        sudoku_template[prev[0]][prev[1]] = 0;
    }
    return 0;

}


int main()
{
    int sudoku_template[9][9];
    int *empty_addrs[81], addrs_len = 0;

    for (int row_idx = 0; row_idx < 9; row_idx++)
    {
        for (int col_idx = 0; col_idx < 9; col_idx++)
        {
            scanf("%d", &sudoku_template[row_idx][col_idx]);

            if (!sudoku_template[row_idx][col_idx])
            {
                int *addr = (int *) malloc(sizeof(int) * 2);
                addr[0] = row_idx;
                addr[1] = col_idx;
                empty_addrs[addrs_len++] = addr;
            }
        }
    }

    rec(sudoku_template, empty_addrs, addrs_len, NULL, 0);


    return 0;
}