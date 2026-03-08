#include <stdio.h>
#include <stdlib.h>

void setBoard(char ***board, int board_size)
{
    *board = (char **) malloc(sizeof(char *) * board_size);
    for (int i = 0; i < board_size; i++)
    {
        (*board)[i] = (char *) malloc(sizeof(char) * board_size);
    }
}

void delBoard(char **board, int board_size)
{
    for (int i = 0; i < board_size; i++)
    {
        free(board[i]);
    }
    free(board);
}


int maxContinuousCount(char **board, int board_size)
{
    int max_cont = 0;

    for (int i = 0; i < board_size; i++)
    {
        int row_cont = 1, col_cont = 1;
        for (int j = 0; j < board_size; j++)
        {
            if (j + 1 != board_size)
            {
                if (board[i][j] == board[i][j + 1])
                    row_cont++;
                else
                {
                    if (row_cont > max_cont)
                        max_cont = row_cont;
                    row_cont = 1;
                }
                if (board[j][i] == board[j + 1][i])
                    col_cont++;
                else
                {
                    if (col_cont > max_cont)
                        max_cont = col_cont;
                    col_cont = 1;
                }
                    
            }
        }

        if (row_cont > max_cont)
            max_cont = row_cont;
        
        if (col_cont > max_cont)
            max_cont = col_cont;
    }

    return max_cont;
}

void changeVals(char *a, char *b)
{
    char temp = *a;
    *a = *b;
    *b = temp;
}

int chkMaxCandy
(char **board, int board_size, int t1, int t2)
{

    if (t1 + 1 == board_size && t2 + 1 == board_size)
    {
        return maxContinuousCount(board, board_size);
    }
    
    int res1 = 0, res2 = 0;
    if (t2 + 1 != board_size)
    {
        changeVals(&board[t1][t2], &board[t1][t2 + 1]);
        res1 = maxContinuousCount(board, board_size);
        changeVals(&board[t1][t2], &board[t1][t2 + 1]);

    }

    if (t1 + 1 != board_size)
    {
        changeVals(&board[t1][t2], &board[t1 + 1][t2]);
        res2 = maxContinuousCount(board, board_size);
        changeVals(&board[t1][t2], &board[t1 + 1][t2]); 
    }    

    
    if (res1 > res2)
        return res1;
    else
        return res2;
}


int main()
{
    int board_size;
    int max_candy = 0;
    scanf("%d", &board_size);
    getchar();

    // board 설정하기
    char **board; setBoard(&board, board_size);

    // 입력받기
    for (int i = 0; i < board_size; i++)
    {
        for (int j = 0; j < board_size; j++)
        {
            scanf("%c", &board[i][j]);
        }
        getchar();
    }

    // 모든 칸마다 탐색
    for (int i = 0; i < board_size; i++)
    {
        for (int j = 0; j < board_size; j++)
        {
            int tmp = chkMaxCandy(board, board_size, i, j);
            
            if (tmp > max_candy)
                max_candy = tmp;
        }

    }

    printf("%d\n", max_candy);
    delBoard(board, board_size);
    return 0;
}
