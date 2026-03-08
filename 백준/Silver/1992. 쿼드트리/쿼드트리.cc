#include <iostream>
#include <vector>
#include <string>
using namespace std;

inline void preset()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

string compressByQuadTree(vector<vector<char>> &image, int size, int st_row, int st_col)
{
    
    if (size == 1) return string({image[st_row][st_col]});

    int split_size = size / 2;
    string lu, ru, lb, rb;
    string res = "";

    lu = compressByQuadTree(image, split_size, st_row, st_col);
    ru = compressByQuadTree(image, split_size, st_row, st_col + split_size);
    lb = compressByQuadTree(image, split_size, st_row + split_size, st_col);
    rb = compressByQuadTree(image, split_size, st_row + split_size, st_col + split_size);

    if ((lu.size() == 1 && ru.size() == 1 && lb.size() == 1 && rb.size() == 1) &&
        ((lu == ru) && (lb == rb) && (lu == lb))) 
    {
        res += lu;
    }
    else
    {
        res += "(";
        res += (lu + ru + lb + rb);
        res += ")";
    }

    return res;
}

int main()
{
    preset();
    int n;
    scanf("%d", &n);
    vector<vector<char>> image(n, vector<char>(n));

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            scanf("%1d", &image[i][j]);
            image[i][j] += '0';
        }
    }

    printf("%s\n", compressByQuadTree(image, n, 0, 0).c_str());
    return 0;
}