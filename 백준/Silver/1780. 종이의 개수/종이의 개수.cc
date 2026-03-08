#include <iostream>
#include <vector>
using namespace std;

inline void preset()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

struct PaperCount {
    int one;
    int zero;
    int mone;

    PaperCount() : one(0), zero(0), mone(0)
    {}

    PaperCount(int o, int z, int m) : one(o), zero(z), mone(m)
    {}

    PaperCount(int a) : one(0), zero(0), mone(0)
    {
        switch(a) {
            case -1:
                mone = 1;
                break;
            case 0:
                zero = 1;
                break;
            case 1:
                one = 1;
                break;
        }
    }

    PaperCount CheckUnified()
    {
        int tot = mone + zero + one;

        if (tot == mone)
            return PaperCount(0, 0, 1);

        else if (tot == zero)
            return PaperCount(0, 1, 0);

        else if (tot == one)
            return PaperCount(1, 0, 0);

        else
            return *this;
    }

    void Print()
    {
        printf("%d\n%d\n%d\n", mone, zero, one);
    }
};

PaperCount countPapers(vector<vector<int>> &paper, int paper_size, int st_row, int st_col)
{
    // 종료 조건
    if (paper_size == 1)
        return PaperCount(paper[st_row][st_col]);
    
    vector<PaperCount> results(9);
    int split_unit = paper_size / 3;
    int result_idx = 0;
    // 종이를 9개로 분할하기
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            results[result_idx++] = 
            countPapers(paper, split_unit, st_row + i * split_unit, st_col + j * split_unit);
        }
    }

    PaperCount summation(0, 0, 0);
    for (auto e : results) {
        summation.mone += e.mone;
        summation.zero += e.zero;
        summation.one  += e.one;
    }
    summation = summation.CheckUnified();

    return summation;
}

int main()
{
    preset();

    int n;
    vector<vector<int>> paper;

    scanf("%d", &n);
    for (int i = 0; i < n; ++i)
    {
        int buff;
        vector<int> line;
        for (int j = 0; j < n; ++j)
        {
            scanf("%d", &buff);
            line.push_back(buff);
        }
        paper.push_back(line);
    }

    countPapers(paper, paper.size(), 0, 0).Print();
    return 0;
}
